package jp.co.isol.api.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.api.exception.HealthInfoException;
import jp.co.isol.api.request.HealthInfoRequest;
import jp.co.isol.api.request.check.HealthInfoCheck;
import jp.co.isol.api.request.key.HealthInfoRequestKey;
import jp.co.isol.api.response.HealthInfoResponse;
import jp.co.isol.api.service.HealthInfoService;
import jp.co.isol.common.dao.AccountDao;
import jp.co.isol.common.dao.HealthInfoDao;
import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.common.entity.Account;
import jp.co.isol.common.entity.HealthInfo;
import jp.co.isol.common.manager.CodeManager;
import jp.co.isol.common.manager.MainKey;
import jp.co.isol.common.manager.SubKey;
import jp.co.isol.common.util.CalcUtil;
import jp.co.isol.common.web.api.BaseRequestKey;

/**
 * 健康情報サービス実装クラス<br>
 *
 */
@Service
public class HealthInfoServiceImpl implements HealthInfoService {

	/** 健康情報Dao */
	@Autowired
	private HealthInfoDao healthInfoDao;
	/** アカウントDao */
	@Autowired
	private AccountDao accountDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HealthInfoResponse execute(HealthInfoRequest request) {

		// リクエスト情報をDtoにつめる
		HealthInfoDto dto = toHealthInfoDto(request);

		// DtoをEntityにつめる
		HealthInfo healthInfo = toEntity(dto);

		// 登録処理を行う
		healthInfoDao.registHealthInfo(healthInfo);

		HealthInfoResponse response = toResponse(healthInfo);

		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HealthInfoResponse toResponse(HealthInfo healthInfo) {

		HealthInfoResponse response = new HealthInfoResponse();
		response.setDataId(healthInfo.getDataId());
		response.setUserId(healthInfo.getUserId());
		response.setHeight(healthInfo.getHeight());
		response.setWeight(healthInfo.getWeight());
		response.setBmi(healthInfo.getBmi());
		response.setStandardWeight(healthInfo.getStandardWeight());
		response.setUserStatus(healthInfo.getUserStatus());
		response.setRegDate(healthInfo.getRegDate());

		return response;
	}

	/**
	 * 健康情報Dtoにリクエスト情報をつめる
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	private HealthInfoDto toHealthInfoDto(HealthInfoRequest request) {

		String userId = (String) request.get(HealthInfoRequestKey.USER_ID);
		BigDecimal height = new BigDecimal((String) request.get(HealthInfoRequestKey.HEIGHT));
		BigDecimal weight = new BigDecimal((String) request.get(HealthInfoRequestKey.WEIGHT));

		// メートルに変換する
		BigDecimal centiMeterHeight = CalcUtil.convertMeterFromCentiMeter(height);
		BigDecimal bmi = CalcUtil.calcBmi(centiMeterHeight, weight, 2);
		BigDecimal standardWeight = CalcUtil.calcStandardWeight(centiMeterHeight, 2);

		// 最後に登録した健康情報を取得する
		HealthInfo lastHealthInfo = getLastHealthInfo(userId);
		String userStatus = CodeManager.getInstance().getValue(MainKey.HEALTH_INFO_USER_STATUS, SubKey.EVEN);
		if (Objects.nonNull(lastHealthInfo)) {
			// 初回登録でない場合
			userStatus = getUserStatus(weight, lastHealthInfo.getWeight());
		}

		Date regDate = new Date();

		HealthInfoDto healthInfo = new HealthInfoDto();
		String nextDataId = getNextDataId(lastHealthInfo);
		healthInfo.setDataId(nextDataId);
		healthInfo.setUserId(userId);
		healthInfo.setHeight(height);
		healthInfo.setWeight(weight);
		healthInfo.setBmi(bmi);
		healthInfo.setStandardWeight(standardWeight);
		healthInfo.setUserStatus(userStatus);
		healthInfo.setRegDate(regDate);

		return healthInfo;
	}

	/**
	 * DtoをEntityにつめる
	 * @param dto
	 * @return
	 */
	private HealthInfo toEntity(HealthInfoDto dto) {

		HealthInfo healthInfo = new HealthInfo();
		healthInfo.setDataId(dto.getDataId());
		healthInfo.setUserId(dto.getUserId());
		healthInfo.setHeight(dto.getHeight());
		healthInfo.setWeight(dto.getWeight());
		healthInfo.setBmi(dto.getBmi());
		healthInfo.setStandardWeight(dto.getStandardWeight());
		healthInfo.setUserStatus(dto.getUserStatus());
		healthInfo.setRegDate(dto.getRegDate());

		return healthInfo;
	}

	/**
	 * 次のデータIDを取得する
	 * @param dto
	 * @return
	 */
	private String getNextDataId(HealthInfo healthInfo) {
		return Objects.isNull(healthInfo) ? "1" : String.valueOf(Integer.valueOf(healthInfo.getDataId()) + 1);
	}

	/**
	 * 入力した健康情報.体重と前回入力した健康情報.体重を比較してユーザステータスを返す<br>
	 * @param inputWeight
	 * @param beforeWeight
	 * @return
	 */
	private String getUserStatus(BigDecimal inputWeight, BigDecimal beforeWeight) {

		SubKey subkey = null;
		if (beforeWeight.compareTo(inputWeight) == 0) {
			subkey = SubKey.EVEN;
		} else if (beforeWeight.compareTo(inputWeight) == -1) {
			subkey = SubKey.INCREASE;
		} else {
			subkey = SubKey.DOWN;
		}

		return CodeManager.getInstance().getValue(MainKey.HEALTH_INFO_USER_STATUS, subkey);
	}

	/**
	 * 指定されたユーザIDで最後に登録した健康情報Dtoを返す<br>
	 * @param userId
	 * @return
	 */
	private HealthInfo getLastHealthInfo(String userId) {

		List<HealthInfo> healthInfoList = healthInfoDao.getHealthInfoByUserId(userId);

		if (healthInfoList.size() == 0) {
			return null;
		}
		return healthInfoList.get(healthInfoList.size() - 1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void checkRequest(HealthInfoRequest request) throws HealthInfoException {

		HealthInfoCheck healthInfoCheck = new HealthInfoCheck();
		Account account = accountDao.getAccountByUserId((String) request.get(HealthInfoRequestKey.USER_ID));

		if (Objects.isNull(account)) {
			// アカウント情報が存在しない場合
			return;
		}

		for (Entry<BaseRequestKey, Object> entry : request.getKeyValue()) {
			String key = entry.getKey().getValue();
			String value = (String) entry.getValue();
			// 必須チェックを行う
			healthInfoCheck.checkRequired(key, value);
			// 属性チェックを行う
			healthInfoCheck.checkType(key, value);
			// 0チェックを行う
			healthInfoCheck.checkZero(key, value);
		}
	}
}

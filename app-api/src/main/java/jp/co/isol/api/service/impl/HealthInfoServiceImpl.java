package jp.co.isol.api.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.api.exception.HealthInfoException;
import jp.co.isol.api.request.HealthInfoRequest;
import jp.co.isol.api.request.check.HealthInfoCheck;
import jp.co.isol.api.request.key.HealthInfoRequestKey;
import jp.co.isol.api.response.HealthInfoResponse;
import jp.co.isol.api.service.HealthInfoService;
import jp.co.isol.common.dao.HealthInfoDao;
import jp.co.isol.common.dto.HealthInfoDto;
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HealthInfoResponse execute(HealthInfoRequest request) {

		// リクエスト情報をDtoにつめる
		HealthInfoDto dto = toHealthInfoDto(request);

		// 登録処理を行う
		healthInfoDao.registHealthInfo(dto);

		HealthInfoResponse response = toResponse(dto);

		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HealthInfoResponse toResponse(HealthInfoDto dto) {

		HealthInfoResponse response = new HealthInfoResponse();
		response.setDataId(dto.getDataId());
		response.setUserId(dto.getUserId());
		response.setHeight(dto.getHeight());
		response.setWeight(dto.getWeight());
		response.setBmi(dto.getBmi());
		response.setStandardWeight(dto.getStandardWeight());
		response.setUserStatus(dto.getUserStatus());
		response.setRegDate(dto.getRegDate());

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
		BigDecimal centiMeterHeight = CalcUtil.convertMeterFromCentiMeter(height, 2);
		BigDecimal bmi = CalcUtil.calcBmi(centiMeterHeight, weight, 2);
		BigDecimal standardWeight = CalcUtil.calcStandardWeight(centiMeterHeight, 2);

		// 最後に登録した健康情報を取得する
		HealthInfoDto lastDto = getLastHealthInfoDto(userId);

		String userStatus = getUserStatus(weight, lastDto.getWeight());
		Date regDate = new Date();

		HealthInfoDto dto = new HealthInfoDto();
		Integer nextId = new Integer(lastDto.getDataId()) + 1;
		dto.setDataId(nextId.toString());
		dto.setUserId(userId);
		dto.setHeight(height);
		dto.setWeight(weight);
		dto.setBmi(bmi);
		dto.setStandardWeight(standardWeight);
		dto.setUserStatus(userStatus);
		dto.setRegDate(regDate);

		return dto;
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
	 * @throws ParseException
	 */
	private HealthInfoDto getLastHealthInfoDto(String userId) {

		List<HealthInfoDto> dtoList = healthInfoDao.getHealthInfoByUserId(userId);
		return dtoList.get(dtoList.size() - 1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void checkRequest(HealthInfoRequest request) throws HealthInfoException {

		HealthInfoCheck healthInfoCheck = new HealthInfoCheck();

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

package jp.co.isol.api.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.api.exception.HealthInfoException;
import jp.co.isol.api.log.ApiLoggerFactory;
import jp.co.isol.api.request.check.HealthInfoCheck;
import jp.co.isol.api.request.impl.HealthInfoRequest;
import jp.co.isol.api.request.key.BaseRequestKey;
import jp.co.isol.api.request.key.impl.HealthInfoRequestKey;
import jp.co.isol.api.service.HealthInfoService;
import jp.co.isol.common.dao.HealthInfoDao;
import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.common.manager.CodeManager;
import jp.co.isol.common.manager.MainKey;
import jp.co.isol.common.manager.SubKey;
import jp.co.isol.common.util.CalcUtil;

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
	public HealthInfoDto execute(HealthInfoRequest request) throws ParseException {

		ApiLoggerFactory.getLogger(HealthInfoServiceImpl.class).info(this.getClass(), "executeメソッド実行");

		// リクエスト情報をDtoにつめる
		HealthInfoDto dto = toHealthInfoDto(request);

		// 登録処理を行う
		healthInfoDao.registHealthInfo(dto);

		return dto;
	}

	/**
	 * 健康情報Dtoにリクエスト情報をつめる
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	private HealthInfoDto toHealthInfoDto(HealthInfoRequest request) throws ParseException {

		String userId = (String) request.get(HealthInfoRequestKey.USER_ID);
		BigDecimal height = new BigDecimal((String) request.get(HealthInfoRequestKey.HEIGHT));
		BigDecimal weight = new BigDecimal((String) request.get(HealthInfoRequestKey.WEIGHT));
		BigDecimal bmi = calcBmi(CalcUtil.convertMeterFromCentiMeter(height), weight);
		BigDecimal standardWeight = calcStandardWeight(CalcUtil.convertMeterFromCentiMeter(height));

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
	private HealthInfoDto getLastHealthInfoDto(String userId) throws ParseException {

		List<HealthInfoDto> dtoList = healthInfoDao.getHealthInfoByUserId(userId);
		return dtoList.get(dtoList.size() - 1);
	}

	/**
	 * BMIを計算(小数第2位を四捨五入する)<br>
	 * @param height
	 * @param weight
	 * @return BMIを計算(小数第2位を四捨五入する)
	 */
	private BigDecimal calcBmi(BigDecimal height, BigDecimal weight) {
		return weight.divide(height.multiply(height), 1, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 標準体重を計算(小数第2位を四捨五入する)<br>
	 * @param height
	 * @return 標準体重を計算(小数第2位を四捨五入する)
	 */
	private BigDecimal calcStandardWeight(BigDecimal height) {
		return height.multiply(height).multiply(new BigDecimal(22)).setScale(1, BigDecimal.ROUND_HALF_UP);
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

package jp.co.isol.api.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import jp.co.isol.api.config.ApiConfig;
import jp.co.isol.api.log.ApiLogger;
import jp.co.isol.api.request.impl.HealthInfoRequest;
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

	/**
	 * メイン処理<br>
	 * @param request
	 * @return 健康情報Dto
	 * @throws ParseException
	 */
	@Override
	public HealthInfoDto execute(HealthInfoRequest request) throws ParseException {

		ApiLogger.getInstance().info(this.getClass(), "executeメソッド実行");

		ApplicationContext context = new AnnotationConfigApplicationContext(ApiConfig.class);
		HealthInfoDao dao = context.getBean(HealthInfoDao.class);

		String userId = (String) request.get("userId");
		BigDecimal height = new BigDecimal((String) request.get("height"));
		BigDecimal weight = new BigDecimal((String) request.get("weight"));
		BigDecimal bmi = calcBmi(CalcUtil.convertMeterFromCentiMeter(height), weight);
		BigDecimal standardWeight = calcStandardWeight(CalcUtil.convertMeterFromCentiMeter(height));

		// 最後に登録した健康情報を取得する
		List<HealthInfoDto> dtoList = dao.getHealthInfoByUserId(userId);
		HealthInfoDto lastDto = dtoList.get(dtoList.size() - 1);
		SubKey subkey = null;
		if (lastDto.getWeight().compareTo(weight) == 0) {
			subkey = SubKey.EVEN;
		} else if (lastDto.getWeight().compareTo(weight) == -1) {
			subkey = SubKey.INCREASE;
		} else {
			subkey = SubKey.DOWN;
		}
		String userStatus = CodeManager.getInstance().getValue(MainKey.HEALTH_INFO_USER_STATUS, subkey);
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

		// 登録処理を行う
		dao.registHealthInfo(dto);

		return dto;
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

}

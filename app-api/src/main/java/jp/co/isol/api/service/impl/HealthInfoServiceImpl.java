package jp.co.isol.api.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import jp.co.isol.api.config.ApiConfig;
import jp.co.isol.api.log.ApiLogger;
import jp.co.isol.api.service.HealthInfoService;
import jp.co.isol.common.code.CodeManager;
import jp.co.isol.common.code.MainKey;
import jp.co.isol.common.code.SubKey;
import jp.co.isol.common.dao.HealthInfoDao;
import jp.co.isol.common.dto.HealthInfoDto;
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
	 */
	@Override
	public HealthInfoDto execute(HttpServletRequest request) {

		ApiLogger.getInstance().info(this.getClass(), "executeメソッド実行");

		String userId = request.getParameter("userId");
		BigDecimal height = new BigDecimal(request.getParameter("height"));
		BigDecimal weight = new BigDecimal(request.getParameter("weight"));
		BigDecimal bmi = calcBmi(CalcUtil.convertMeter(height), weight);
		BigDecimal standardWeight = calcStandardWeight(CalcUtil.convertMeter(height));
		String userStatus = CodeManager.getInstance().getValue(MainKey.HEALTH_INFO_USER_STATUS, SubKey.DOWN);
		Date regDate = new Date();

		HealthInfoDto dto = new HealthInfoDto();
		dto.setDataId("001");
		dto.setUserId(userId);
		dto.setHeight(height);
		dto.setWeight(weight);
		dto.setBmi(bmi);
		dto.setStandardWeight(standardWeight);
		dto.setUserStatus(userStatus);
		dto.setRegDate(regDate);

		// 登録処理を行う
		ApplicationContext context = new AnnotationConfigApplicationContext(ApiConfig.class);
		HealthInfoDao dao = context.getBean(HealthInfoDao.class);
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

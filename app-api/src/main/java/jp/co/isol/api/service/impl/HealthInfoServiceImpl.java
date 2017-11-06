package jp.co.isol.api.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import jp.co.isol.api.service.HealthInfoService;

/**
 * @author kou1210hei<br>
 * 健康情報サービス実装クラス<br>
 *
 */
@Service
public class HealthInfoServiceImpl implements HealthInfoService {

	/**
	 * BMIを計算(小数第2位を四捨五入する)<br>
	 * @param height
	 * @param weight
	 * @return BMIを計算(小数第2位を四捨五入する)
	 */
	@Override
	public BigDecimal calcBmi(BigDecimal height, BigDecimal weight) {
		return weight.divide(height.multiply(height), 1, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 標準体重を計算(小数第2位を四捨五入する)<br>
	 * @param height
	 * @return 標準体重を計算(小数第2位を四捨五入する)
	 */
	@Override
	public BigDecimal calcStandardWeight(BigDecimal height) {
		return height.multiply(height).multiply(new BigDecimal(22)).setScale(1, BigDecimal.ROUND_HALF_UP);
	}

}

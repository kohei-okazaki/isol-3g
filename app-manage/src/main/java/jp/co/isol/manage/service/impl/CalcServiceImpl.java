package jp.co.isol.manage.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import jp.co.isol.manage.service.CalcService;


/**
 * @author kou1210hei<br>
 * 体重計算サービス実装クラス
 *
 */
@Service
public class CalcServiceImpl implements CalcService {

	/**
	 * BMIを計算(小数第2位を四捨五入する)
	 * @param height
	 * @param weight
	 * @return BMIを計算(小数第2位を四捨五入する)
	 */
	@Override
	public BigDecimal calcBmi(BigDecimal height, BigDecimal weight) {
		return height.divide(height.multiply(height), 1, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 標準体重を計算(小数第2位を四捨五入する)
	 * @param height
	 * @return 標準体重を計算(小数第2位を四捨五入する)
	 */
	@Override
	public BigDecimal calcStandardWeight(BigDecimal height) {
		return height.multiply(height).multiply(new BigDecimal(22)).setScale(1, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 最後に入力した体重と今の体重の差を計算
	 * @param before 前の体重
	 * @param now 今の体重
	 * @return 体重の差(小数第2位を四捨五入する)
	 */
	@Override
	public BigDecimal calcDiffWeight(BigDecimal before, BigDecimal now) {
		return now.subtract(before).abs().setScale(1, BigDecimal.ROUND_HALF_UP);
	}

}

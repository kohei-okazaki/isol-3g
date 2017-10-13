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
	public double calcBmi(double height, double weight) {

		BigDecimal bmi = new BigDecimal(weight / (height * height));
		return bmi.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 標準体重を計算(小数第2位を四捨五入する)
	 * @param height
	 * @return 標準体重を計算(小数第2位を四捨五入する)
	 */
	@Override
	public double calcStandardWeight(double height) {

		BigDecimal standardWeight = new BigDecimal(height * height * 22);
		return standardWeight.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 最後に入力した体重と今の体重の差を計算
	 * @param before 前の体重
	 * @param now 今の体重
	 * @return 体重の差(小数第2位を四捨五入する)
	 */
	@Override
	public double calcDiffWeight(double before, double now) {

		// 体重差取得
		BigDecimal diff = new BigDecimal(Math.abs(now - before));
		return diff.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}

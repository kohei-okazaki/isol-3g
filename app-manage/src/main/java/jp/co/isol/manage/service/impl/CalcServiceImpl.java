package jp.co.isol.manage.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import jp.co.isol.manage.service.CalcService;


/**
 * 体重計算サービス実装クラス
 *
 */
@Service
public class CalcServiceImpl implements CalcService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal calcBmi(BigDecimal height, BigDecimal weight) {
		return weight.divide(height.multiply(height), 1, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal calcStandardWeight(BigDecimal height) {
		return height.multiply(height).multiply(new BigDecimal(22)).setScale(1, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal calcDiffWeight(BigDecimal before, BigDecimal now) {
		return now.subtract(before).abs().setScale(1, BigDecimal.ROUND_HALF_UP);
	}

}

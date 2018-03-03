package jp.co.isol.manage.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import jp.co.isol.common.util.HealthInfoUtil;
import jp.co.isol.manage.service.CalcService;

/**
 * 計算サービス実装クラス
 *
 */
@Service
public class CalcServiceImpl implements CalcService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal calcBmi(BigDecimal height, BigDecimal weight, int digit) {
		return HealthInfoUtil.calcBmi(height, weight, digit);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal calcStandardWeight(BigDecimal height, int digit) {
		return HealthInfoUtil.calcStandardWeight(height, digit);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal calcDiffWeight(BigDecimal before, BigDecimal now) {
		return now.subtract(before).abs().setScale(1, RoundingMode.HALF_UP);
	}

}

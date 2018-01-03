package jp.co.isol.manage.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import jp.co.isol.common.util.CalcUtil;
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
	public BigDecimal calcBmi(BigDecimal height, BigDecimal weight, int digit) {
		return CalcUtil.calcBmi(height, weight, digit);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal calcStandardWeight(BigDecimal height, int digit) {
		return CalcUtil.calcStandardWeight(height, digit);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal calcDiffWeight(BigDecimal before, BigDecimal now) {
		return now.subtract(before).abs().setScale(1, BigDecimal.ROUND_HALF_UP);
	}

}

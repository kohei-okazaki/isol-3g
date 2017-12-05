package jp.co.isol.manage.file.excel.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 結果照会Excel出力モデルクラス<br>
 *
 */
@Data
@NoArgsConstructor
public class ReferenceExcelModel {

	/** 身長 */
	private BigDecimal height;

	/** 体重 */
	private BigDecimal weight;

	/** BMI */
	private BigDecimal bmi;

	/** 標準体重 */
	private BigDecimal standardWeight;

}

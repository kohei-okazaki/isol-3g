package jp.co.isol.manage.file.excel.model;

import java.math.BigDecimal;

import jp.co.isol.common.file.excel.annotation.ExcelHeader;
import jp.co.isol.common.file.excel.annotation.ExcelModel;
import lombok.Data;

/**
 * 結果照会Excel出力モデルクラス<br>
 *
 */
@Data
@ExcelModel
@ExcelHeader(names = {"身長", "体重", "BMI", "標準体重"})
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

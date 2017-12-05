package jp.co.isol.common.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import jp.co.isol.common.file.excel.annotation.Excel;

/**
 * Excel操作のUtilクラス<br>
 *
 */
public class ExcelUtil {

	/**
	 * プライベートコンストラクタ<br>
	 * インスタンス生成を制限
	 */
	private ExcelUtil() {
	}

	/**
	 * セルを返す<br>
	 * @param sheet
	 * @param row
	 * @param col
	 * @return cell
	 */
	public static Cell getCell(Sheet sheet, int row, int col) {

		// row取得
		Row sheetRow = sheet.getRow(row);
		if (Objects.isNull(sheetRow)) {
			sheetRow = sheet.createRow(row);
		}

		// cell取得
		Cell cell = sheetRow.getCell(col);
		if (Objects.isNull(cell)) {
			cell = sheetRow.createCell(col);
		}
		return cell;
	}

	/**
	 * 指定されたセルにtextを設定する<br>
	 * @param cell
	 * @param text
	 */
	public static void setText(Cell cell, String text) {
		cell.setCellType(CellType.STRING);
		cell.setCellValue(text);
	}

	/**
	 * Excelアノテーションに設定されたシート名を返す。<br>
	 * @param clazz
	 * @return シート名
	 */
	public static String getSheetName(Class<?> clazz) {
		return getExcelClass(clazz).sheetName();
	}

	/**
	 * ヘッダ名を取得する
	 * @param clazz
	 * @return ヘッダー名
	 */
	public static List<String> getHeaderList(Class<?> clazz) {
		return Arrays.asList(getExcelClass(clazz).headerNames());
	}

	/**
	 * 指定されたクラス型のExcelアノテーションを返す<br>
	 * @param clazz
	 * @return
	 */
	public static Excel getExcelClass(Class<?> clazz) {
		return clazz.getAnnotation(Excel.class);
	}


}

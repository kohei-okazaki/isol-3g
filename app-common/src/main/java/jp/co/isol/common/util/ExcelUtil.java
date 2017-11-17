package jp.co.isol.common.util;

import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import jp.co.isol.common.file.excel.Excel;

/**
 * @author kou1210hei<br>
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
		Row sheetRow = sheet.getRow(row);
		if (sheetRow == null) {
			sheetRow = sheet.createRow(row);
		}
		Cell cell = sheetRow.getCell(col);
		if (cell == null) {
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
		Excel excel = getExcelClass(clazz);
		return excel.sheetName();
	}

	/**
	 * ヘッダ名を取得する
	 * @param clazz
	 * @return ヘッダー名
	 */
	public static List<String> getHeaderList(Class<?> clazz) {
		Excel excel = getExcelClass(clazz);
		return Arrays.asList(excel.headerNames());
	}

	/**
	 * 指定されたクラス型のExcelアノテーションを返す<br>
	 * @param clazz
	 * @return
	 */
	private static Excel getExcelClass(Class<?> clazz) {
		return clazz.getAnnotation(Excel.class);
	}


}

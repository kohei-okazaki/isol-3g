package jp.co.isol.common.file.excel.builder;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import jp.co.isol.common.file.excel.annotation.ExcelSheet;
import jp.co.isol.common.other.Charset;

/**
 * Excel出力の基底クラス<br>
 *
 */
public abstract class BaseExcelBuilder extends AbstractXlsxView {

	/** ヘッダー位置 */
	protected final int HEADER_POSITION = 0;

	/**
	 * エクセルに情報を書き込む<br>
	 * @param model
	 * @param workbook
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@Override
	protected void buildExcelDocument(Map<String, Object> model
											, Workbook workbook
											, HttpServletRequest request
											, HttpServletResponse response) throws Exception {

		String fileName = new String("sample.xlsx".getBytes(Charset.MS_932.getName()), "ISO-8859-1");
		response.setHeader("Content-Desposition", "attachment; filename=" + fileName);
		Sheet sheet = workbook.createSheet(getSheetName());

		// ヘッダーを書き込む
		writeHeader(sheet);

		// データを書き込む
		writeData(sheet);
	}

	/**
	 * 継承先の@ExcelSheetからシート名を取得<br>
	 * {@link ExcelSheet}
	 * @return
	 */
	protected abstract String getSheetName();

	/**
	 * ヘッダーを設定する<br>
	 * @param sheet
	 */
	protected abstract void writeHeader(Sheet sheet);

	/**
	 * データを設定する<br>
	 * @param sheet
	 */
	protected abstract void writeData(Sheet sheet);
}

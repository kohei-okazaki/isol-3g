package jp.co.isol.common.excel;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

/**
 * @author kou1210hei<br>
 * Excel出力の基底クラス<br>
 *
 */
public abstract class BaseExcelBuilder extends AbstractXlsxView {

	/**
	 * エクセルに情報を書き込む<br>
	 * @param model
	 * @param workbook
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@Override
	protected abstract void buildExcelDocument(Map<String, Object> model
											, Workbook workbook
											, HttpServletRequest request
											, HttpServletResponse response) throws Exception;


	/**
	 * ヘッダーを設定する<br>
	 * @param sheet
	 * @param cell
	 */
	protected abstract void setHeader(Sheet sheet, Cell cell);
}

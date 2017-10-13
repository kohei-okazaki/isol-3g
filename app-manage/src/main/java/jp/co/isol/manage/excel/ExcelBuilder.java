package jp.co.isol.manage.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import jp.co.isol.common.excel.BaseExcelBuilder;
import jp.co.isol.common.excel.Excel;
import jp.co.isol.common.message.Message;
import jp.co.isol.common.other.Charset;
import jp.co.isol.common.util.ExcelUtil;
import jp.co.isol.manage.form.MenuForm;

/**
 * @author kou1210hei<br>
 * Excel生成クラス
 *
 */
@Excel(sheetName = "ユーザ情報", headerNames = {Message.WEIGHT, Message.HEIGHT, Message.BMI, Message.STANDARDWEIGHT})
public class ExcelBuilder extends BaseExcelBuilder {

	private MenuForm form;

	/**
	 * コンストラクタ<br>
	 * @param form
	 */
	public ExcelBuilder(MenuForm form) {
		this.form = form;
	}

	/**
	 * エクセルファイルを生成する<br>
	 *
	 * @param model
	 * @param workbook
	 * @param req
	 * @param resp
	 * @see org.springframework.web.servlet.view.document.AbstractExcelView#buildExcelDocument(java.util.Map, org.apache.poi.hssf.usermodel.HSSFWorkbook, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		String fileName = new String("sample.xls".getBytes(Charset.MS_932.getName()), "ISO-8859-1");
		resp.setHeader("Content-Desposition", "attachment; filename=" + fileName);

		Cell cell = null;

		Sheet sheet = workbook.createSheet(ExcelUtil.getSheetName(this.getClass()));

		setHeader(sheet, cell);

		cell = ExcelUtil.getCell(sheet, 1, 0);
		ExcelUtil.setText(cell, form.getHeight().toString());
		cell = ExcelUtil.getCell(sheet, 1, 1);
		ExcelUtil.setText(cell, form.getWeight().toString());
		cell = ExcelUtil.getCell(sheet, 1, 2);
		ExcelUtil.setText(cell, form.getBmi().toString());
		cell = ExcelUtil.getCell(sheet, 1, 3);
		ExcelUtil.setText(cell, form.getStandardWeight().toString());

	}

	/**
	 * ヘッダーを設定する<br>
	 * @param sheet
	 * @param cell
	 */
	@Override
	protected void setHeader(Sheet sheet, Cell cell) {
		List<Message> headerNameList = ExcelUtil.getHeaderList(this.getClass());
		for (int i = 0; i < headerNameList.size(); i++) {
			String headerName = headerNameList.get(i).getName();
			cell = ExcelUtil.getCell(sheet, 0, i);
			ExcelUtil.setText(cell, headerName);
		}
	}

}

package jp.co.isol.manage.excel;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
import jp.co.isol.manage.form.HealthInfoInputForm;

/**
 * @author kou1210hei<br>
 * 健康情報入力画面Excel生成クラス<br>
 *
 */
@Excel(sheetName = "健康情報", headerNames = {Message.HEIGHT, Message.WEIGHT, Message.BMI, Message.STANDARDWEIGHT})
public class HealthInfoExcelBuilder extends BaseExcelBuilder {

	/** 健康情報入力フォームクラス */
	private HealthInfoInputForm form;

	/**
	 * コンストラクタ<br>
	 * @param form
	 */
	public HealthInfoExcelBuilder(HealthInfoInputForm form) {
		this.form = form;
	}

	/**
	 * エクセルファイルを生成する<br>
	 *
	 * @param model
	 * @param workbook
	 * @param req
	 * @param resp
	 */
	@Override
	public void buildExcelDocument(Map<String, Object> model
								, Workbook workbook
								, HttpServletRequest req
								, HttpServletResponse resp) throws Exception {

		String fileName = new String("sample.xlsx".getBytes(Charset.MS_932.getName()), "ISO-8859-1");
		resp.setHeader("Content-Desposition", "attachment; filename=" + fileName);

		Sheet sheet = workbook.createSheet(ExcelUtil.getSheetName(this.getClass()));

		// ヘッダーを設定
		setHeader(sheet);

		// データを設定
		setData(sheet);

	}

	/**
	 * ヘッダーを設定する<br>
	 * @param sheet
	 */
	@Override
	protected void setHeader(Sheet sheet) {
		List<Message> headerNameList = ExcelUtil.getHeaderList(this.getClass());
		Stream.iterate(0, i -> ++i).limit(headerNameList.size()).forEach(i -> {
			String headerName = headerNameList.get(i).getName();
			Cell cell = ExcelUtil.getCell(sheet, 0, i);
			ExcelUtil.setText(cell, headerName);
		});
	}

	/**
	 * データを設定する<br>
	 * @param sheet
	 */
	@Override
	protected void setData(Sheet sheet) {
		final int INDEX_POSITION = 1;
		Cell cell = ExcelUtil.getCell(sheet, INDEX_POSITION, 0);
		ExcelUtil.setText(cell, form.getHeight().toString());
		cell = ExcelUtil.getCell(sheet, INDEX_POSITION, 1);
		ExcelUtil.setText(cell, form.getWeight().toString());
		cell = ExcelUtil.getCell(sheet, INDEX_POSITION, 2);
		ExcelUtil.setText(cell, form.getBmi().toString());
		cell = ExcelUtil.getCell(sheet, INDEX_POSITION, 3);
		ExcelUtil.setText(cell, form.getStandardWeight().toString());
	}

}

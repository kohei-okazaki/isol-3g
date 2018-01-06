package jp.co.isol.manage.file.excel.builder;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import jp.co.isol.common.file.excel.annotation.ExcelSheet;
import jp.co.isol.common.file.excel.builder.BaseExcelBuilder;
import jp.co.isol.common.other.Charset;
import jp.co.isol.common.util.ExcelUtil;
import jp.co.isol.manage.file.excel.model.ReferenceExcelModel;

/**
 * 結果照会画面Excel生成クラス<br>
 *
 */
@ExcelSheet("健康情報")
public class ResultReferenceExcelBuiler extends BaseExcelBuilder {

	/** 結果照会Excelモデルクラスリスト */
	private List<ReferenceExcelModel> modelList;

	public ResultReferenceExcelBuiler(List<ReferenceExcelModel> modelList) {
		this.modelList = modelList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void buildExcelDocument(Map<String, Object> model
									, Workbook workbook
									, HttpServletRequest request
									, HttpServletResponse response) throws Exception {

		String fileName = new String("sample.xlsx".getBytes(Charset.MS_932.getName()), "ISO-8859-1");
		response.setHeader("Content-Desposition", "attachment; filename=" + fileName);

		Sheet sheet = workbook.createSheet(ExcelUtil.getSheetName(this.getClass()));

		// ヘッダーを書き込む
		writeHeader(sheet);

		// データを書き込む
		writeData(sheet);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void writeHeader(Sheet sheet) {

		List<String> headerNameList = ExcelUtil.getHeaderList(ReferenceExcelModel.class);

		Stream.iterate(0, i -> ++i).limit(headerNameList.size()).forEach(i -> {
			String headerName = headerNameList.get(i);
			Cell cell = ExcelUtil.getCell(sheet, HEADER_POSITION, i);
			ExcelUtil.setText(cell, headerName);
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void writeData(Sheet sheet) {

		Stream.iterate(0, i -> ++i).limit(this.modelList.size()).forEach(i -> {
			ReferenceExcelModel model = modelList.get(i);
			final int ROW_POSITION = i + 1;
			Cell cell = ExcelUtil.getCell(sheet, ROW_POSITION, 0);
			ExcelUtil.setText(cell, model.getHeight().toString());
			cell = ExcelUtil.getCell(sheet, ROW_POSITION, 1);
			ExcelUtil.setText(cell, model.getWeight().toString());
			cell = ExcelUtil.getCell(sheet, ROW_POSITION, 2);
			ExcelUtil.setText(cell, model.getBmi().toString());
			cell = ExcelUtil.getCell(sheet, ROW_POSITION, 3);
			ExcelUtil.setText(cell, model.getStandardWeight().toString());
		});
	}
}

package jp.co.isol.manage.file.excel;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.common.excel.BaseExcelBuilder;
import jp.co.isol.common.excel.Excel;
import jp.co.isol.common.other.Charset;
import jp.co.isol.common.util.ExcelUtil;

/**
 * 結果照会画面Excel生成クラス<br>
 *
 */
@Excel(sheetName = "健康情報", headerNames = {"身長", "体重", "BMI", "標準体重"})
public class ResultReferenceExcelBuiler extends BaseExcelBuilder {

	/** 購入履歴情報リスト */
	private List<HealthInfoDto> historyList;

	/**
	 * コンストラクタ<br>
	 * @param historyList
	 */
	public ResultReferenceExcelBuiler(List<HealthInfoDto> historyList) {
		this.historyList = historyList;
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
	protected void buildExcelDocument(Map<String, Object> model
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

		List<String> headerNameList = ExcelUtil.getHeaderList(this.getClass());

		Stream.iterate(0, i -> ++i).limit(headerNameList.size()).forEach(i -> {
			String headerName = headerNameList.get(i);
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

		Stream.iterate(0, i -> ++i).limit(this.historyList.size()).forEach(i -> {
			HealthInfoDto dto = historyList.get(i);
			final int ROW_POSITION = i + 1;
			Cell cell = ExcelUtil.getCell(sheet, ROW_POSITION, 0);
			ExcelUtil.setText(cell, dto.getHeight().toString());
			cell = ExcelUtil.getCell(sheet, ROW_POSITION, 1);
			ExcelUtil.setText(cell, dto.getWeight().toString());
			cell = ExcelUtil.getCell(sheet, ROW_POSITION, 2);
			ExcelUtil.setText(cell, dto.getBmi().toString());
			cell = ExcelUtil.getCell(sheet, ROW_POSITION, 3);
			ExcelUtil.setText(cell, dto.getStandardWeight().toString());
		});

	}

}

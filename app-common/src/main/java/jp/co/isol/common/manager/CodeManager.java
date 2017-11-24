package jp.co.isol.common.manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.isol.common.dto.CodeDto;
import jp.co.isol.common.util.StringUtil;

/**
 * 健康管理_コードマネージャクラス<br>
 *
 */
public class CodeManager {

	/** singletonパターン */
	private static CodeManager instance = new CodeManager();
	/** コードエクセルファイル */
	private static final String CODE_EXCEL = "C:\\work\\pleiades\\workspace\\isol-3g\\app-common\\src\\main\\resources\\META-INF\\codeParameter.xlsx";
	/** シート名 */
	private static final String SHEET_NAME = "PARAMETER";

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/**
	 * プライベートコンストラクタ<br>
	 * インスタンスの生成を制限する<br>
	 */
	private CodeManager() {
	}

	/**
	 * CodeManagerインスタンスを取得する<br>
	 * @return
	 */
	public static final CodeManager getInstance() {
		return instance;
	}

	/**
	 * メインキーとサブキーにヒモづくvalueを返す<br>
	 * @param mainKey メインキー
	 * @param subKey サブキー
	 * @return ひもづく値
	 */
	public String getValue(MainKey mainKey, SubKey subKey) {

		if (Objects.isNull(mainKey) || Objects.isNull(subKey)) {
			return "";
		}
		String value = "";
		try {
			Iterator<Row> rowIterator  = getRowIterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (row == null || row.getCell(0) == null) {
					break;
				}
				String cellMainKey = row.getCell(0).getStringCellValue();
				String cellSubKey = row.getCell(1).getStringCellValue();

				if (cellMainKey.equals(mainKey.name()) && cellSubKey.equals(subKey.name())) {
					value = row.getCell(2).getStringCellValue();
				}
			}
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 指定したメインキーに該当するvalueをリストを返す<br>
	 * @param mainKey
	 * @return
	 */
	public List<String> getValues(MainKey mainKey) {

		if (Objects.isNull(mainKey)) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		try {
			Iterator<Row> rowIterator  = getRowIterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				String cellMainKey = row.getCell(0).getStringCellValue();

				if (cellMainKey.equals(mainKey.name())) {
					list.add(row.getCell(2).getStringCellValue());
				}
			}
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * メインキーに該当する値のリストを返す<br>
	 * @param mainKey メインキー
	 * @return
	 */
	public List<CodeDto> getList(MainKey mainKey) {

		if (Objects.isNull(mainKey)) {
			return null;
		}

		List<CodeDto> list = new ArrayList<CodeDto>();
		try {
			Iterator<Row> rowIterator  = getRowIterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				String cellMainKey = row.getCell(0).getStringCellValue();
				String cellSubKey = row.getCell(1).getStringCellValue();

				if (cellMainKey.equals(mainKey.name())) {
					CodeDto codeDto = new CodeDto();
					codeDto.setMainKey(cellMainKey);
					codeDto.setSubKey(cellSubKey);
					codeDto.setValue(row.getCell(2).getStringCellValue());
					list.add(codeDto);
				}
			}
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * コードエクセル内の行をすべてIteratorで返す<br>
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public Iterator<Row> getRowIterator() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Workbook workbook = WorkbookFactory.create(new File(CODE_EXCEL));
		Sheet sheet = workbook.getSheet(SHEET_NAME);
		return sheet.rowIterator();
	}

	/**
	 * 指定された値がメインキー、サブキーから取得される値と一致するか判定する<br>
	 * 一致した場合true, そうでなければfalseを返す<br>
	 * @param mainKey
	 * @param subKey
	 * @param target
	 * @return 判定結果
	 */
	public final boolean isEquals(MainKey mainKey, SubKey subKey, String target) {

		if (StringUtil.isEmpty(target)) {
			return false;
		}

		return target.equals(getValue(mainKey, subKey));

	}

}

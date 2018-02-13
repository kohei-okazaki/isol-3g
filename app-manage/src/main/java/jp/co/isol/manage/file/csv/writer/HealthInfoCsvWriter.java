package jp.co.isol.manage.file.csv.writer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletResponse;

import jp.co.isol.common.file.csv.writer.BaseCsvWriter;
import jp.co.isol.common.manager.CodeManager;
import jp.co.isol.common.manager.MainKey;
import jp.co.isol.common.manager.SubKey;
import jp.co.isol.common.other.DateFormatDefine;
import jp.co.isol.common.util.CsvUtil;
import jp.co.isol.common.util.DateUtil;
import jp.co.isol.common.util.StringUtil;
import jp.co.isol.manage.file.csv.model.HealthInfoCsvModel;

/**
 * 健康情報CSVWriterクラス<br>
 *
 */
public class HealthInfoCsvWriter extends BaseCsvWriter {

	/** 健康情報CSVモデル */
	private HealthInfoCsvModel model;

	/**
	 * デフォルトコンストラクタ<br>
	 */
	public HealthInfoCsvWriter() {
	}

	/**
	 * {@inheritDoc}
	 */
	public HealthInfoCsvWriter(String enclosureChar) {
		super(enclosureChar);
	}

	/**
	 * modelを返す
	 * @return model
	 */
	public HealthInfoCsvModel getModel() {
		return model;
	}

	/**
	 * modelを設定する
	 * @param model
	 */
	public void setModel(HealthInfoCsvModel model) {
		this.model = model;
	}

	/**
	 * {@inheritDoc}
	 */
	public void execute(HttpServletResponse response) throws IOException {

		String fileName = getFileName();
		init(response, fileName);

		try (PrintWriter writer = response.getWriter()) {
			StringJoiner recordJoiner = new StringJoiner(StringUtil.NEW_LINE);
			writeHeader(recordJoiner);
			writeData(recordJoiner);
			writer.print(recordJoiner.toString());
		}
	}

	/**
	 * ヘッダレコードをつめる<br>
	 * @param recordJoiner
	 */
	private void writeHeader(StringJoiner recordJoiner) {

		StringJoiner joiner = new StringJoiner(StringUtil.COMMA);
		CsvUtil.getHeaderList(model.getClass()).stream().forEach(headerName -> write(joiner, headerName));
		recordJoiner.add(joiner.toString());
	}

	/**
	 * データレコードをつめる<br>
	 * @param recordJoiner
	 */
	private void writeData(StringJoiner recordJoiner) {

		// 1項目ごと区切る
		StringJoiner joiner = new StringJoiner(StringUtil.COMMA);

		// ユーザID
		write(joiner, model.getUserId());
		// 身長
		write(joiner, model.getHeight().toString());
		// 体重
		write(joiner, model.getWeight().toString());
		// BMI
		write(joiner, model.getBmi().toString());
		// 標準体重
		write(joiner, model.getStandardWeight().toString());
		// 登録日時
		write(joiner, DateUtil.toString(model.getRegDate(), DateFormatDefine.YYYYMMDD_HHMMSS));

		// 1行書き込む
		recordJoiner.add(joiner.toString());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getFileName() {
		return CodeManager.getInstance().getValue(MainKey.CSV_FILE_NAME, SubKey.HEALTH_INFO);
	}
}

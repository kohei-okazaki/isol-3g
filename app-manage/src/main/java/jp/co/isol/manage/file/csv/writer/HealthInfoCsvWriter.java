package jp.co.isol.manage.file.csv.writer;

import java.util.StringJoiner;

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
public class HealthInfoCsvWriter extends BaseCsvWriter<HealthInfoCsvModel> {

	/**
	 * デフォルトコンストラクタ<br>
	 */
	public HealthInfoCsvWriter() {
	}

	/**
	 * コンストラクタ<br>
	 * @param enclosureChar
	 */
	public HealthInfoCsvWriter(String enclosureChar) {
		super(enclosureChar);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void writeHeader(StringJoiner recordJoiner) {

		StringJoiner joiner = new StringJoiner(StringUtil.COMMA);
		CsvUtil.getHeaderList(HealthInfoCsvModel.class).stream().forEach(headerName -> write(joiner, headerName));
		recordJoiner.add(joiner.toString());

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void writeData(StringJoiner recordJoiner, HealthInfoCsvModel model) {

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

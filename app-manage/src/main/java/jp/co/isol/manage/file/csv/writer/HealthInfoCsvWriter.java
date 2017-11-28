package jp.co.isol.manage.file.csv.writer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletResponse;

import jp.co.isol.common.file.csv.writer.BaseCsvWriter;
import jp.co.isol.common.util.CsvUtil;
import jp.co.isol.common.util.DateUtil;
import jp.co.isol.common.util.StringUtil;
import jp.co.isol.manage.file.csv.model.HealthInfoCsvModel;
import lombok.Getter;
import lombok.Setter;

/**
 * 健康情報CSVを書きこむクラス<br>
 *
 */
public class HealthInfoCsvWriter extends BaseCsvWriter {

	@Setter
	@Getter
	private HealthInfoCsvModel model;

	/**
	 * {@inheritDoc}
	 */
	public void execute(HttpServletResponse response) throws IOException {

		init(response);

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
	 * @param model
	 */
	private void writeHeader(StringJoiner recordJoiner) {

		StringJoiner joiner = new StringJoiner(StringUtil.COMMA);
		CsvUtil.getHeaderList(model.getClass()).stream().forEach(headerName -> joiner.add(headerName));
		recordJoiner.add(joiner.toString());
	}

	/**
	 * データレコードをつめる<br>
	 * @param recordJoiner
	 * @param model
	 */
	private void writeData(StringJoiner recordJoiner) {

		StringJoiner joiner = new StringJoiner(StringUtil.COMMA);
		joiner.add(model.getUserId());
		joiner.add(model.getHeight().toString());
		joiner.add(model.getWeight().toString());
		joiner.add(model.getBmi().toString());
		joiner.add(model.getStandardWeight().toString());
		joiner.add(DateUtil.toString(model.getRegDate(), DateUtil.YYYYMMDD_HHMMSS));

		recordJoiner.add(joiner.toString());
	}
}

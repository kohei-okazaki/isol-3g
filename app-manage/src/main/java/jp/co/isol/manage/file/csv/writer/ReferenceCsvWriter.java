package jp.co.isol.manage.file.csv.writer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletResponse;

import jp.co.isol.common.file.csv.writer.BaseCsvWriter;
import jp.co.isol.common.util.CsvUtil;
import jp.co.isol.common.util.DateUtil;
import jp.co.isol.common.util.StringUtil;
import jp.co.isol.manage.file.csv.model.ReferenceCsvModel;

/**
 * 結果照会CSV書き込みクラス<br>
 *
 */
public class ReferenceCsvWriter extends BaseCsvWriter {

	/** モデルリスト */
	private List<ReferenceCsvModel> modelList;

	/**
	 * デフォルトコンストラクタ<br>
	 */
	public ReferenceCsvWriter() {
	}

	/**
	 * コンストラクタ<br>
	 * @param enclosureChar
	 */
	public ReferenceCsvWriter(String enclosureChar) {
		super(enclosureChar);
	}

	/**
	 * modelListを返す
	 * @return modelList
	 */
	public List<ReferenceCsvModel> getModelList() {
		return modelList;
	}

	/**
	 * modelListを設定する
	 * @param modelList
	 */
	public void setModelList(List<ReferenceCsvModel> modelList) {
		this.modelList = modelList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(HttpServletResponse response) throws IOException {

		String fileName = "\"referenceResult.csv\"";
		init(response, fileName);
		try (PrintWriter writer = response.getWriter()) {
			StringJoiner recordJoiner = new StringJoiner(StringUtil.NEW_LINE);
			writeHeader(recordJoiner);
			modelList.stream().forEach(model -> writeData(recordJoiner, model));
			writer.print(recordJoiner.toString());
		}
	}

	/**
	 * ヘッダレコードをつめる<br>
	 * @param recordJoiner
	 */
	private void writeHeader(StringJoiner recordJoiner) {

		StringJoiner joiner = new StringJoiner(StringUtil.COMMA);
		CsvUtil.getHeaderList(ReferenceCsvModel.class).stream().forEach(headerName -> write(joiner, headerName));
		recordJoiner.add(joiner.toString());
	}

	/**
	 * データレコードをつめる<br>
	 * @param recordJoiner
	 * @param model
	 */
	private void writeData(StringJoiner recordJoiner, ReferenceCsvModel model) {

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
		write(joiner, DateUtil.toString(model.getRegDate(), DateUtil.YYYYMMDD_HHMMSS));

		// 1行書き込む
		recordJoiner.add(joiner.toString());
	}
}

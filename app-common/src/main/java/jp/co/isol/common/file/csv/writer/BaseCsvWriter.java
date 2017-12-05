package jp.co.isol.common.file.csv.writer;

import java.io.IOException;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.MimeTypeUtils;

import jp.co.isol.common.other.Charset;
import jp.co.isol.common.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * CSV書き込み基底クラス<br>
 *
 */
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseCsvWriter {

	/** 囲い文字 */
	protected String enclosureChar = StringUtil.EMPTY;

	/**
	 * メイン処理を実施<br>
	 * 継承先でそれぞれ実装<br>
	 * @param response
	 * @throws IOException
	 */
	protected abstract void execute(HttpServletResponse response) throws IOException;

	/**
	 * 初期処理<br>
	 * @param response
	 */
	protected void init(HttpServletResponse response) {

		response.setContentType(MimeTypeUtils.APPLICATION_OCTET_STREAM_VALUE + ";charset=" + Charset.UTF_8.toString().toLowerCase());
		response.setHeader("Content-Disposition", "attachment; filename=\"HealthInfo.csv\"");

	}

	/**
	 * 指定されたデータの書き込み処理を行う<br>
	 * @param joiner
	 * @param data 書き込みたいデータ
	 */
	protected void write(StringJoiner joiner, String data) {
		joiner.add(enclosureChar + data + enclosureChar);
	}

}

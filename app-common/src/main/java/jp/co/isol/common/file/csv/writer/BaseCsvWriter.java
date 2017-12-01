package jp.co.isol.common.file.csv.writer;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.MimeTypeUtils;

import jp.co.isol.common.other.Charset;

/**
 * CSV書き込み基底クラス<br>
 *
 */
public abstract class BaseCsvWriter {

	/**
	 * メイン処理を実施
	 * @param response
	 * @throws IOException
	 */
	protected abstract void execute(HttpServletResponse response) throws IOException;

	/**
	 * 初期処理
	 * @param response
	 */
	protected void init(HttpServletResponse response) {

		response.setContentType(MimeTypeUtils.APPLICATION_OCTET_STREAM_VALUE + ";charset=" + Charset.UTF_8.toString().toLowerCase());
		response.setHeader("Content-Disposition", "attachment; filename=\"HealthInfo.csv\"");

	}

}

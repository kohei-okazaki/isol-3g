package jp.co.isol.manage.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.common.util.CsvUtil;
import jp.co.isol.common.util.DateUtil;
import jp.co.isol.common.util.StringUtil;
import jp.co.isol.manage.file.csv.HealthInfoCsvModel;
import jp.co.isol.manage.service.CsvDownloadService;
import jp.co.isol.manage.service.HealthInfoSearchService;
import jp.co.isol.manage.web.config.ManageConfig;
import jp.co.isol.manage.web.session.ManageSessionKey;
import jp.co.isol.manage.web.session.ManageSessionManager;

/**
 * 健康情報CSVダウンロードサービス実装クラス<br>
 *
 */
@Service("healthInfoCsv")
public class HealthInfoCsvDownloadServiceImpl implements CsvDownloadService {

	/** 健康情報検索サービス */
	@Autowired
	private HealthInfoSearchService healthInfoSearchService;

	/**
	 * {@inheritDoc}
	 *
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {

		ManageSessionManager sessionManager;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			sessionManager = context.getBean(ManageSessionManager.class);
		}

		// 最後に登録した健康情報を検索
		String userId = sessionManager.getAttribute(request.getSession(), ManageSessionKey.USER_ID);
		List<HealthInfoDto> dtoList = healthInfoSearchService.findHealthInfoByUserId(userId);
		HealthInfoDto dto = dtoList.get(dtoList.size() - 1);
		HealthInfoCsvModel model = toModel(dto);

		// 文字コードと出力するCSVファイル名を設定
		response.setContentType(MimeTypeUtils.APPLICATION_OCTET_STREAM_VALUE + ";charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=\"HealthInfo.csv\"");

		try (PrintWriter writer = response.getWriter()) {
			StringJoiner recordJoiner = new StringJoiner("\r\n");
			writeHeader(recordJoiner, model);
			writeData(recordJoiner, model);
			writer.print(recordJoiner.toString());
		}

	}

	/**
	 * ヘッダレコードをつめる<br>
	 * @param recordJoiner
	 * @param model
	 */
	private void writeHeader(StringJoiner recordJoiner, HealthInfoCsvModel model) {

		StringJoiner joiner = new StringJoiner(StringUtil.COMMA);
		CsvUtil.getHeaderList(model.getClass()).stream().forEach(headerName -> joiner.add(headerName));
		recordJoiner.add(joiner.toString());
	}

	/**
	 * データレコードをつめる<br>
	 * @param recordJoiner
	 * @param model
	 */
	private void writeData(StringJoiner recordJoiner, HealthInfoCsvModel model) {

		StringJoiner joiner = new StringJoiner(StringUtil.COMMA);
		joiner.add(model.getUserId());
		joiner.add(model.getHeight().toString());
		joiner.add(model.getWeight().toString());
		joiner.add(model.getBmi().toString());
		joiner.add(model.getStandardWeight().toString());
		joiner.add(DateUtil.toString(model.getRegDate(), DateUtil.YYYYMMDD_HHMMSS));

		recordJoiner.add(joiner.toString());
	}

	/**
	 * CSVモデルにDtoをつめる
	 * @param dto
	 * @return model
	 */
	private HealthInfoCsvModel toModel(HealthInfoDto dto) {

		HealthInfoCsvModel model = new HealthInfoCsvModel();
		model.setUserId(dto.getUserId());
		model.setHeight(dto.getHeight());
		model.setWeight(dto.getWeight());
		model.setBmi(dto.getBmi());
		model.setStandardWeight(dto.getStandardWeight());
		model.setRegDate(dto.getRegDate());

		return model;
	}

}

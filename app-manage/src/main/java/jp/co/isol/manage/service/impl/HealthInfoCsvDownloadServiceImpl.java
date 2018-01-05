package jp.co.isol.manage.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.common.util.CsvUtil;
import jp.co.isol.manage.config.ManageConfig;
import jp.co.isol.manage.file.csv.model.HealthInfoCsvModel;
import jp.co.isol.manage.file.csv.writer.HealthInfoCsvWriter;
import jp.co.isol.manage.service.CsvDownloadService;
import jp.co.isol.manage.service.HealthInfoSearchService;
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
		List<HealthInfoDto> dtoList = this.healthInfoSearchService.findHealthInfoByUserId(userId);
		HealthInfoDto dto = dtoList.get(dtoList.size() - 1);
		HealthInfoCsvModel model = toModel(dto);

		// CSVに書き込む
		HealthInfoCsvWriter writer = new HealthInfoCsvWriter(CsvUtil.DOBBLE_QUOTE);
		writer.setModel(model);
		writer.execute(response);

	}

	/**
	 * CSVモデルにDtoに変換する<br>
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

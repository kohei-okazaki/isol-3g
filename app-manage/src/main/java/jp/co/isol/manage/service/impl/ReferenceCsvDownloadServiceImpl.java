package jp.co.isol.manage.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.manage.file.csv.model.ReferenceCsvModel;
import jp.co.isol.manage.file.csv.writer.ReferenceCsvWriter;
import jp.co.isol.manage.service.CsvDownloadService;
import jp.co.isol.manage.service.HealthInfoSearchService;
import jp.co.isol.manage.web.config.ManageConfig;
import jp.co.isol.manage.web.session.ManageSessionKey;
import jp.co.isol.manage.web.session.ManageSessionManager;

/**
 * 結果照会画面CSVダウンロードサービスクラス実装クラス<br>
 *
 */
@Service(value = "referenceCsv")
public class ReferenceCsvDownloadServiceImpl implements CsvDownloadService {

	/** 健康情報検索サービス */
	@Autowired
	private HealthInfoSearchService healthInfoSearchService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {

		ManageSessionManager sessionManager;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			sessionManager = context.getBean(ManageSessionManager.class);
		}

		// セッションからユーザIDを取得
		String userId = sessionManager.getAttribute(request.getSession(), ManageSessionKey.USER_ID);
		List<HealthInfoDto> dtoList = healthInfoSearchService.findHealthInfoByUserId(userId);
		List<ReferenceCsvModel> modelList = toModelList(dtoList);

		// CSVに書き込む
		ReferenceCsvWriter writer = new ReferenceCsvWriter();
		writer.setModelList(modelList);
		writer.execute(response);
	}

	/**
	 * 結果照会CSVモデルリストに変換する
	 * @param dtoList
	 * @return modelList
	 */
	private List<ReferenceCsvModel> toModelList(List<HealthInfoDto> dtoList) {

		List<ReferenceCsvModel> modelList = new ArrayList<ReferenceCsvModel>();
		for (HealthInfoDto dto : dtoList) {
			ReferenceCsvModel model = new ReferenceCsvModel();
			model.setUserId(dto.getUserId());
			model.setHeight(dto.getHeight());
			model.setWeight(dto.getWeight());
			model.setBmi(dto.getBmi());
			model.setStandardWeight(dto.getStandardWeight());
			model.setRegDate(dto.getRegDate());
			modelList.add(model);
		}
		return modelList;
	}

}

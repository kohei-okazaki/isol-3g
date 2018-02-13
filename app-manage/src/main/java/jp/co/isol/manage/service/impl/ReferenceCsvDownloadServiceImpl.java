package jp.co.isol.manage.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import jp.co.isol.common.entity.Account;
import jp.co.isol.common.entity.HealthInfo;
import jp.co.isol.common.manager.CodeManager;
import jp.co.isol.common.manager.MainKey;
import jp.co.isol.common.manager.SubKey;
import jp.co.isol.common.util.CsvUtil;
import jp.co.isol.manage.config.ManageConfig;
import jp.co.isol.manage.file.csv.model.ReferenceCsvModel;
import jp.co.isol.manage.file.csv.writer.ReferenceCsvWriter;
import jp.co.isol.manage.service.AccountSearchService;
import jp.co.isol.manage.service.CsvDownloadService;
import jp.co.isol.manage.service.HealthInfoSearchService;
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
	/** アカウント検索サービス */
	@Autowired
	private AccountSearchService accountSearchService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ManageSessionManager sessionManager;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			sessionManager = context.getBean(ManageSessionManager.class);
		}

		// セッションからユーザIDを取得
		String userId = sessionManager.getAttribute(request.getSession(), ManageSessionKey.USER_ID);
		List<HealthInfo> healthInfoList = this.healthInfoSearchService.findHealthInfoByUserId(userId);
		List<ReferenceCsvModel> modelList = toModelList(healthInfoList);

		Account account = accountSearchService.findAccountByUserId(userId);
		boolean enclosureFlag = CodeManager.getInstance().isEquals(MainKey.FLAG, SubKey.TRUE, account.getFileEnclosureCharFlag());

		// CSVに書き込む
		ReferenceCsvWriter writer = enclosureFlag ? new ReferenceCsvWriter(CsvUtil.DOBBLE_QUOTE) : new ReferenceCsvWriter();
		writer.setModelList(modelList);
		writer.execute(response);
	}

	/**
	 * 結果照会CSVモデルリストに変換する
	 * @param healthInfoList
	 * @return modelList
	 */
	private List<ReferenceCsvModel> toModelList(List<HealthInfo> healthInfoList) {

		List<ReferenceCsvModel> modelList = new ArrayList<ReferenceCsvModel>();
		for (HealthInfo healthInfo : healthInfoList) {
			ReferenceCsvModel model = new ReferenceCsvModel();
			model.setUserId(healthInfo.getUserId());
			model.setHeight(healthInfo.getHeight());
			model.setWeight(healthInfo.getWeight());
			model.setBmi(healthInfo.getBmi());
			model.setStandardWeight(healthInfo.getStandardWeight());
			model.setRegDate(healthInfo.getRegDate());
			modelList.add(model);
		}
		return modelList;
	}

}

package jp.co.isol.web.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import jp.co.isol.common.entity.Account;
import jp.co.isol.common.entity.HealthInfo;
import jp.co.isol.common.file.csv.writer.BaseCsvWriter;
import jp.co.isol.common.util.CsvUtil;
import jp.co.isol.common.util.StringUtil;
import jp.co.isol.web.config.ManageConfig;
import jp.co.isol.web.file.csv.model.HealthInfoCsvModel;
import jp.co.isol.web.file.csv.writer.HealthInfoCsvWriter;
import jp.co.isol.web.service.AccountSearchService;
import jp.co.isol.web.service.CsvDownloadService;
import jp.co.isol.web.service.HealthInfoSearchService;
import jp.co.isol.web.web.session.ManageSessionKey;
import jp.co.isol.web.web.session.ManageSessionManager;

/**
 * 健康情報CSVダウンロードサービス実装クラス<br>
 *
 */
@Service("healthInfoCsv")
public class HealthInfoCsvDownloadServiceImpl implements CsvDownloadService {

	/** 健康情報検索サービス */
	@Autowired
	private HealthInfoSearchService healthInfoSearchService;
	/** アカウント検索サービス */
	@Autowired
	private AccountSearchService accountSearchService;

	/**
	 * {@inheritDoc}
	 *
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ManageSessionManager sessionManager;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			sessionManager = context.getBean(ManageSessionManager.class);
		}

		// 最後に登録した健康情報を検索
		String userId = (String) sessionManager.getAttribute(request.getSession(), ManageSessionKey.USER_ID);
		List<HealthInfo> healthInfoList = this.healthInfoSearchService.findHealthInfoByUserId(userId);
		HealthInfo healthInfo = healthInfoList.get(healthInfoList.size() - 1);

		// CSV出力モデルリストに変換する
		List<HealthInfoCsvModel> modelList = toModelList(healthInfo);

		// ファイル囲い文字利用フラグを取得
		Account account = accountSearchService.findAccountByUserId(userId);
		boolean enclosureFlag = StringUtil.isTrue(account.getFileEnclosureCharFlag());

		// CSVに書き込む
		BaseCsvWriter<HealthInfoCsvModel> writer = enclosureFlag ? new HealthInfoCsvWriter(CsvUtil.DOBBLE_QUOTE) : new HealthInfoCsvWriter();

		writer.setModelList(modelList);
		writer.execute(response);

	}

	/**
	 * CSVモデルリストに変換する<br>
	 * @param healthInfo
	 * @return modelList
	 */
	private List<HealthInfoCsvModel> toModelList(HealthInfo healthInfo) {

		List<HealthInfoCsvModel> modelList = new ArrayList<HealthInfoCsvModel>();
		HealthInfoCsvModel model = new HealthInfoCsvModel();
		BeanUtils.copyProperties(healthInfo, model);
		modelList.add(model);

		return modelList;
	}

}

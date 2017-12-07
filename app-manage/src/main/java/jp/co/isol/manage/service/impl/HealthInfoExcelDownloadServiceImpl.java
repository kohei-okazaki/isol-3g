package jp.co.isol.manage.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import jp.co.isol.manage.file.excel.builder.HealthInfoExcelBuilder;
import jp.co.isol.manage.file.excel.model.HealthInfoExcelModel;
import jp.co.isol.manage.form.HealthInfoForm;
import jp.co.isol.manage.service.ExcelDownloadService;

/**
 * 健康情報エクエルダウンロードサービス実装クラス
 *
 */
@Service(value = "healthInfoExcel")
public class HealthInfoExcelDownloadServiceImpl implements ExcelDownloadService<HealthInfoForm> {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/**
	 * {@inheritDoc}
	 */
	@Override
	public View execute(HealthInfoForm form) {

		LOG.info(this.getClass() + " start");

		HealthInfoExcelModel model = toModel(form);

		return new HealthInfoExcelBuilder(model);
	}

	/**
	 * 健康情報フォームをモデルに変換する<br>
	 * @param form
	 * @return model
	 */
	private HealthInfoExcelModel toModel(HealthInfoForm form) {
		HealthInfoExcelModel model = new HealthInfoExcelModel();
		model.setHeight(form.getHeight());
		model.setWeight(form.getWeight());
		model.setBmi(form.getBmi());
		model.setStandardWeight(form.getStandardWeight());
		return model;
	}

}

package jp.co.isol.web.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import jp.co.isol.web.file.excel.builder.HealthInfoExcelBuilder;
import jp.co.isol.web.file.excel.model.HealthInfoExcelModel;
import jp.co.isol.web.form.HealthInfoForm;
import jp.co.isol.web.service.ExcelDownloadService;

/**
 * 健康情報Excelダウンロードサービス実装クラス
 *
 */
@Service(value = "healthInfoExcel")
public class HealthInfoExcelDownloadServiceImpl implements ExcelDownloadService<HealthInfoForm> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public View execute(HealthInfoForm form) {

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
		BeanUtils.copyProperties(form, model);
		return model;

	}

}

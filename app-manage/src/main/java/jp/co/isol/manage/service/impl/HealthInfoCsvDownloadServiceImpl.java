package jp.co.isol.manage.service.impl;

import org.springframework.stereotype.Service;

import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.manage.csv.HealthInfoCsvModel;
import jp.co.isol.manage.service.CsvDownloadService;

/**
 * 健康情報CSVダウンロードサービス実装クラス<br>
 *
 */
@Service
public class HealthInfoCsvDownloadServiceImpl implements CsvDownloadService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HealthInfoCsvModel toModel(HealthInfoDto dto) {
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

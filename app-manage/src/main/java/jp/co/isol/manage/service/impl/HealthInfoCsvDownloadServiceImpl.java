package jp.co.isol.manage.service.impl;

import java.text.ParseException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.manage.file.csv.HealthInfoCsvModel;
import jp.co.isol.manage.service.CsvDownloadService;

/**
 * 健康情報CSVダウンロードサービス実装クラス<br>
 *
 */
@Service("healthInfoCsv")
public class HealthInfoCsvDownloadServiceImpl implements CsvDownloadService<HealthInfoDto> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String execute(HealthInfoDto healthInfoDto) throws JsonProcessingException, ParseException {

		HealthInfoCsvModel model = toModel(healthInfoDto);

		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(HealthInfoCsvModel.class).withHeader();

		return mapper.writer(schema).writeValueAsString(model);

	}

	/**
	 * CSVモデルにDtoをつめる
	 * @param userId
	 * @param form
	 * @return
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

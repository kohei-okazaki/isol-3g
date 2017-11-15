package jp.co.isol.manage.service;

import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.manage.csv.HealthInfoCsvModel;

/**
 * CSVダウンロードサービスインターフェイス<br>
 *
 */
public interface CsvDownloadService {

	/**
	 * CSVモデルにDtoをつめる
	 * @param userId
	 * @param form
	 * @return
	 */
	public HealthInfoCsvModel toModel(HealthInfoDto dto);

}

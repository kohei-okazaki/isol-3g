package jp.co.isol.manage.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.manage.file.excel.builder.ResultReferenceExcelBuiler;
import jp.co.isol.manage.file.excel.model.ReferenceExcelModel;
import jp.co.isol.manage.service.ExcelDownloadService;

/**
 * 結果照会画面Excelダウンロードサービス実装クラス
 *
 */
@Service(value = "referenceExcel")
public class ReferenceExcelDownloadServiceImpl implements ExcelDownloadService<List<HealthInfoDto>> {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/**
	 * {@inheritDoc}
	 */
	@Override
	public View execute(List<HealthInfoDto> historyList) {

		LOG.info(this.getClass() + " start");

		List<ReferenceExcelModel> modelList = toModel(historyList);

		return new ResultReferenceExcelBuiler(modelList);
	}

	/**
	 * 健康情報履歴リストをモデルリストに変換する<br>
	 * @param historyList 健康情報リスト履歴リスト
	 * @return modelList
	 */
	private List<ReferenceExcelModel> toModel(List<HealthInfoDto> historyList) {

		List<ReferenceExcelModel> modelList = new ArrayList<ReferenceExcelModel>();
		Stream.iterate(0, i -> ++i).limit(historyList.size()).forEach(i -> {
			ReferenceExcelModel model = new ReferenceExcelModel();
			HealthInfoDto dto = historyList.get(i);
			model.setHeight(dto.getHeight());
			model.setWeight(dto.getWeight());
			model.setBmi(dto.getBmi());
			model.setStandardWeight(dto.getStandardWeight());
			modelList.add(model);
		});

		return modelList;
	}

}

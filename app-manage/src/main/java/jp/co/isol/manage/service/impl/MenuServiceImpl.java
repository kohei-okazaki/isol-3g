package jp.co.isol.manage.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.common.message.MessageManager;
import jp.co.isol.common.util.CalcUtil;
import jp.co.isol.manage.form.HealthInfoInputForm;
import jp.co.isol.manage.service.CalcService;
import jp.co.isol.manage.service.MenuService;

/**
 * メニュー画面のサービス実装クラス
 *
 */
@Service
public class MenuServiceImpl implements MenuService {

	/** 計算サービス */
	@Autowired
	private CalcService calcService;

	/**
	 * 入力した体重と最後に入力した体重との差を表示する<br>
	 * @param form
	 * @return 体重差のメッセージ
	 */
	@Override
	public String getDiffMessage(HealthInfoInputForm form, HealthInfoDto dto) {

		MessageManager manager = MessageManager.getInstance();
		if (form.getWeight().compareTo(dto.getWeight()) == 0) {
			// 変化なしの場合
			return manager.getValue("even");
		} else if (form.getWeight().compareTo(dto.getWeight()) == 1) {
			// 増加した場合
			return manager.getValue("increase");
		} else {
			// 減少した場合
			return manager.getValue("down");
		}
	}

	/**
	 * 最後に入力した体重とフォームから体重差を返却
	 * @param form
	 * @param dto
	 * @return 体重差
	 */
	@Override
	public BigDecimal getDiffWeight(HealthInfoInputForm form, HealthInfoDto dto) {
		return calcService.calcDiffWeight(dto.getWeight(), form.getWeight());
	}

	/**
	 * 入力情報を計算し、Dtoにつめる<br>
	 * @return
	 */
	@Override
	public HealthInfoDto convertUserInfo(HealthInfoInputForm form, String userId) {

		HealthInfoDto dto = new HealthInfoDto();
		dto.setUserId(userId);
		dto.setHeight(form.getHeight());
		dto.setWeight(form.getWeight());
		dto.setBmi(calcService.calcBmi(CalcUtil.convertMeterFromCentiMeter(form.getHeight()), form.getWeight()));
		dto.setStandardWeight(calcService.calcStandardWeight(CalcUtil.convertMeterFromCentiMeter(form.getHeight())));
		dto.setRegDate(new Date());
		return dto;
	}

}

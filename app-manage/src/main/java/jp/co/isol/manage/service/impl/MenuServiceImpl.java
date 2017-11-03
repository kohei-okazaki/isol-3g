package jp.co.isol.manage.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.common.message.Message;
import jp.co.isol.common.util.CalcUtil;
import jp.co.isol.manage.dto.HealthInfoDto;
import jp.co.isol.manage.form.HealthInfoInputForm;
import jp.co.isol.manage.service.CalcService;
import jp.co.isol.manage.service.MenuService;

/**
 * @author kou1210hei<br>
 * メニュー画面のサービス実装クラス
 *
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private CalcService calcService;

	/**
	 * 入力した体重と最後に入力した体重との差を表示する<br>
	 * @param form
	 * @return 体重差のメッセージ
	 */
	@Override
	public Message getDiffMessage(HealthInfoInputForm form, HealthInfoDto dto) {
		if (form.getWeight().compareTo(dto.getWeight()) == 0) {
			// 変化なしの場合
			return Message.EQUAL;
		} else if (form.getWeight().compareTo(dto.getWeight()) == 1) {
			// 増加した場合
			return Message.UP;
		} else {
			// 現象した場合
			return Message.DOWN;
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
		dto.setBmi(calcService.calcBmi(CalcUtil.convertMeter(form.getHeight()), form.getWeight()));
		dto.setStandardWeight(calcService.calcStandardWeight(CalcUtil.convertMeter(form.getHeight())));
		dto.setRecordDate(new Date());
		return dto;
	}

}

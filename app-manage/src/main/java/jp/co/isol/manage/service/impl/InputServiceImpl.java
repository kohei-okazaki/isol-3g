package jp.co.isol.manage.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.common.message.Message;
import jp.co.isol.common.util.CalcUtil;
import jp.co.isol.manage.dto.UserInfoDto;
import jp.co.isol.manage.form.UserInfoInputForm;
import jp.co.isol.manage.service.CalcService;
import jp.co.isol.manage.service.InputService;

/**
 * @author kou1210hei<br>
 * 入力画面サービス実装クラス
 *
 */
@Service
public class InputServiceImpl implements InputService {


	@Autowired
	private CalcService calcService;

	/**
	 * 入力情報のチェック
	 * @param form
	 * @return 判定結果
	 */
	@Override
	public boolean hasError(UserInfoInputForm form) {

		if (hasNull(form.getWeight(), form.getHeight())) {
			return true;
		} else if (form.getWeight().doubleValue() == 0 || form.getHeight().doubleValue() == 0) {
			return true;
		} else if (hasContainMinus(form.getWeight(), form.getHeight())) {
			return true;
		}
		return false;
	}

	@Override
	public UserInfoDto convertUserInfo(UserInfoInputForm form, String userId) {

		UserInfoDto dto = new UserInfoDto();
		dto.setUserId(userId);
		dto.setHeight(form.getHeight());
		dto.setWeight(form.getWeight());
		dto.setBmi(calcService.calcBmi(CalcUtil.convertMeter(form.getHeight()), form.getWeight()));
		dto.setStandardWeight(calcService.calcStandardWeight(CalcUtil.convertMeter(form.getHeight())));
		dto.setRecordDate(new Date());
		return dto;
	}

	/**
	 * 入力した体重と最後に入力した体重との差を表示する<br>
	 * @param form
	 * @return 体重差のメッセージ
	 */
	@Override
	public Message getDiffMessage(UserInfoInputForm form, UserInfoDto dto) {
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
	public BigDecimal getDiffWeight(UserInfoInputForm form, UserInfoDto dto) {
		return calcService.calcDiffWeight(dto.getWeight(), form.getWeight());
	}
}

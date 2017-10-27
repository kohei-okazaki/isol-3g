package jp.co.isol.manage.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.common.message.Message;
import jp.co.isol.manage.dto.UserInfoDto;
import jp.co.isol.manage.form.MenuForm;
import jp.co.isol.manage.service.CalcService;
import jp.co.isol.manage.service.MenuService;
import jp.co.isol.manage.service.UserInfoSearchService;

/**
 * @author kou1210hei<br>
 * メニュー画面のサービス実装クラス
 *
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private CalcService calcService;
	@Autowired
	private UserInfoSearchService userInfoSearchService;

	/**
	 * 入力した体重と最後に入力した体重との差を表示する<br>
	 * @param form
	 * @return 体重差のメッセージ
	 */
	@Override
	public String getDiffMessage(MenuForm form) {

		double formWeight = form.getWeight().doubleValue();
		UserInfoDto dto = userInfoSearchService.findUserInfoEntity("1");
		double dbWeight = dto.getWeight().doubleValue();
		return formWeight < dbWeight ? Message.DOWN.getName() : Message.UP.getName();

	}

	/**
	 * フォームから体重差を返却
	 * @param form
	 * @return 体重差
	 */
	@Override
	public BigDecimal getDiffWeight(MenuForm form) {

		double nowWeight = form.getWeight().doubleValue();
		UserInfoDto dto = userInfoSearchService.findUserInfoEntity("1");
		double beforeWeight = dto.getWeight().doubleValue();
		return calcService.calcDiffWeight(dto.getWeight(), form.getWeight());

	}

	@Override
	public UserInfoDto convertUserInfo(MenuForm form, String userId) {

		UserInfoDto dto = new UserInfoDto();
		dto.setUserId(userId);
		dto.setHeight(form.getHeight());
		dto.setWeight(form.getWeight());
		dto.setBmi(calcService.calcBmi(form.getHeight(), form.getWeight()));
		dto.setStandardWeight(calcService.calcStandardWeight(form.getHeight()));
		dto.setRecordDate(new Date());
		return dto;
	}

}

package jp.co.isol.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.common.message.Message;
import jp.co.isol.common.util.CalcUtil;
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
	 * フォームから標準体重を返却<br>
	 * @param form
	 * @return 標準体重
	 */
	@Override
	public double getStandardWeight(MenuForm form) {

		// 入力情報の身長がセンチメートルなので単位とdouble型に変換
		double height = CalcUtil.convertMeter(form.getHeight()).doubleValue();
		return calcService.calcStandardWeight(height);

	}

	/**
	 * フォームからBMIを返却<br>
	 * @param form
	 * @return BMI
	 */
	@Override
	public double getBmi(MenuForm form) {

		// 入力情報の身長がセンチメートルなので単位とdouble型に変換
		double height = CalcUtil.convertMeter(form.getHeight()).doubleValue();
		double weight = form.getWeight().doubleValue();
		return calcService.calcBmi(height, weight);

	}

	/**
	 * フォームから体重差を返却
	 * @param form
	 * @return 体重差
	 */
	@Override
	public double getDiffWeight(MenuForm form) {

		double nowWeight = form.getWeight().doubleValue();
		UserInfoDto dto = userInfoSearchService.findUserInfoEntity("1");
		double beforeWeight = dto.getWeight().doubleValue();
		return calcService.calcDiffWeight(beforeWeight, nowWeight);

	}

}

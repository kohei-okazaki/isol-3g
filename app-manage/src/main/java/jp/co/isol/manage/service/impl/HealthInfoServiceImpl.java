package jp.co.isol.manage.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.common.entity.HealthInfo;
import jp.co.isol.common.manager.CodeManager;
import jp.co.isol.common.manager.MainKey;
import jp.co.isol.common.manager.SubKey;
import jp.co.isol.common.util.CalcUtil;
import jp.co.isol.manage.form.HealthInfoForm;
import jp.co.isol.manage.service.CalcService;
import jp.co.isol.manage.service.HealthInfoService;

/**
 * 健康情報_入力画面サービス実装クラス
 *
 */
@Service
public class HealthInfoServiceImpl implements HealthInfoService {

	/** 計算サービス */
	@Autowired
	private CalcService calcService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HealthInfo convertHealthInfo(HealthInfoForm form, String userId, HealthInfo lastHealthInfo) {

		HealthInfo healthInfo = new HealthInfo();
		healthInfo.setDataId(Objects.isNull(lastHealthInfo) ? "" : lastHealthInfo.getDataId());
		healthInfo.setUserId(userId);
		healthInfo.setHeight(form.getHeight());
		healthInfo.setWeight(form.getWeight());
		healthInfo.setBmi(this.calcService.calcBmi(CalcUtil.convertMeterFromCentiMeter(form.getHeight()), form.getWeight(), 2));
		healthInfo.setStandardWeight(this.calcService.calcStandardWeight(CalcUtil.convertMeterFromCentiMeter(form.getHeight()), 2));

		String userStatus = null;
		if (Objects.isNull(lastHealthInfo)) {
			userStatus = CodeManager.getInstance().getValue(MainKey.HEALTH_INFO_USER_STATUS, SubKey.EVEN);
		} else {
			userStatus = getUserStatus(form.getWeight(), lastHealthInfo.getWeight());
		}

		healthInfo.setUserStatus(userStatus);
		healthInfo.setRegDate(new Date());
		return healthInfo;
	}

	/**
	 * 入力した健康情報.体重と前回入力した健康情報.体重を比較してユーザステータスを返す<br>
	 * @param inputWeight
	 * @param beforeWeight
	 * @return
	 */
	private String getUserStatus(BigDecimal inputWeight, BigDecimal beforeWeight) {

		SubKey subkey = null;
		if (beforeWeight.compareTo(inputWeight) == 0) {
			subkey = SubKey.EVEN;
		} else if (beforeWeight.compareTo(inputWeight) == -1) {
			subkey = SubKey.INCREASE;
		} else {
			subkey = SubKey.DOWN;
		}

		return CodeManager.getInstance().getValue(MainKey.HEALTH_INFO_USER_STATUS, subkey);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDiffMessage(HealthInfoForm form, HealthInfo healthInfo) {

		CodeManager manager = CodeManager.getInstance();
		SubKey subkey;
		if (form.getWeight().compareTo(healthInfo.getWeight()) == 0) {
			// 変化なしの場合
			subkey = SubKey.EVEN_MESSAGE;
		} else if (form.getWeight().compareTo(healthInfo.getWeight()) == 1) {
			// 増加した場合
			subkey = SubKey.INCREASE_MESSAGE;
		} else {
			// 減少した場合
			subkey = SubKey.DOWN_MESSAGE;
		}
		return manager.getValue(MainKey.HEALTH_INFO_USER_STATUS, subkey);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getDiffWeight(HealthInfoForm form, HealthInfo healthInfo) {
		return this.calcService.calcDiffWeight(healthInfo.getWeight(), form.getWeight());
	}

}

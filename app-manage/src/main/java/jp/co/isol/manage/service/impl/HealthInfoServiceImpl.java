package jp.co.isol.manage.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.common.entity.HealthInfo;
import jp.co.isol.common.manager.CodeManager;
import jp.co.isol.common.manager.MainKey;
import jp.co.isol.common.manager.MessageManager;
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
	public HealthInfoDto convertHealthInfoDto(HealthInfoForm form, String userId) {

		HealthInfoDto dto = new HealthInfoDto();
		dto.setUserId(userId);
		dto.setHeight(form.getHeight());
		dto.setWeight(form.getWeight());
		dto.setBmi(this.calcService.calcBmi(CalcUtil.convertMeterFromCentiMeter(form.getHeight()), form.getWeight(), 2));
		dto.setUserStatus(CodeManager.getInstance().getValue(MainKey.HEALTH_INFO_USER_STATUS, SubKey.DOWN));
		dto.setStandardWeight(this.calcService.calcStandardWeight(CalcUtil.convertMeterFromCentiMeter(form.getHeight()), 2));
		dto.setRegDate(new Date());

		return dto;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDiffMessage(HealthInfoForm form, HealthInfo healthInfo) {

		MessageManager manager = MessageManager.getInstance();
		if (form.getWeight().compareTo(healthInfo.getWeight()) == 0) {
			// 変化なしの場合
			return manager.getValue("even");
		} else if (form.getWeight().compareTo(healthInfo.getWeight()) == 1) {
			// 増加した場合
			return manager.getValue("increase");
		} else {
			// 減少した場合
			return manager.getValue("down");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getDiffWeight(HealthInfoForm form, HealthInfo healthInfo) {
		return this.calcService.calcDiffWeight(healthInfo.getWeight(), form.getWeight());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HealthInfo convertHealthInfo(HealthInfoDto dto) {

		HealthInfo healthInfo = new HealthInfo();
		healthInfo.setDataId(dto.getDataId());
		healthInfo.setUserId(dto.getUserId());
		healthInfo.setHeight(dto.getHeight());
		healthInfo.setWeight(dto.getWeight());
		healthInfo.setBmi(dto.getBmi());
		healthInfo.setStandardWeight(dto.getStandardWeight());
		healthInfo.setUserStatus(dto.getUserStatus());
		healthInfo.setRegDate(dto.getRegDate());
		return healthInfo;
	}
}

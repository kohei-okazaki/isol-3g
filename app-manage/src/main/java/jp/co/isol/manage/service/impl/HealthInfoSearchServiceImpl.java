package jp.co.isol.manage.service.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.common.dao.HealthInfoDao;
import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.manage.service.HealthInfoSearchService;

/**
 * 健康情報Daoクラスを呼び出す実装クラス
 */
@Service
public class HealthInfoSearchServiceImpl implements HealthInfoSearchService {

	/** 健康情報Dao */
	@Autowired
	private HealthInfoDao healthInfoDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<HealthInfoDto> findHealthInfoByUserId(String userId) throws ParseException {
		return healthInfoDao.getHealthInfoByUserId(userId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HealthInfoDto findHealthInfoByDataId(String dataId) throws ParseException {
		return healthInfoDao.getHealthInfoByDataId(dataId);
	}

}

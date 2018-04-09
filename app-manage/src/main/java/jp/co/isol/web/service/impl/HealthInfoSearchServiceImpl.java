package jp.co.isol.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.common.dao.HealthInfoDao;
import jp.co.isol.common.entity.HealthInfo;
import jp.co.isol.web.service.HealthInfoSearchService;

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
	public List<HealthInfo> findHealthInfoByUserId(String userId) {
		return this.healthInfoDao.getHealthInfoByUserId(userId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HealthInfo findHealthInfoByDataId(String dataId) {
		return this.healthInfoDao.getHealthInfoByDataId(dataId);
	}

}

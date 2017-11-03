package jp.co.isol.manage.service.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.manage.dao.HealthInfoDao;
import jp.co.isol.manage.dto.HealthInfoDto;
import jp.co.isol.manage.service.UserInfoSearchService;

/**
 * @author kou1210hei<br>
 * Daoクラスを呼び出す実装クラス
 */
@Service
public class UserInfoSearchServiceImpl implements UserInfoSearchService {

	@Autowired
	private HealthInfoDao userInfoDao;

	/**
	 * 全ユーザ情報を取得する
	 * @return 全ユーザ情報
	 * @throws ParseException
	 */
	@Override
	public List<HealthInfoDto> findHealthInfoByUserId(String userId) throws ParseException {
		return userInfoDao.getHealthInfoByUserId(userId);
	}

	/**
	 * 指定されたデータIDからユーザ情報を取得する
	 * @param id
	 * @return ログインユーザ情報
	 * @throws ParseException
	 */
	@Override
	public HealthInfoDto findUserInfoByDataId(String dataId) throws ParseException {
		return userInfoDao.getUserInfoByDataId(dataId);
	}

}

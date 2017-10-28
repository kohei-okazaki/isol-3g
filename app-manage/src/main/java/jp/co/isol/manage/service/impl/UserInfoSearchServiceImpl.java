package jp.co.isol.manage.service.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.manage.dao.UserInfoDao;
import jp.co.isol.manage.dto.UserInfoDto;
import jp.co.isol.manage.service.UserInfoSearchService;

/**
 * @author kou1210hei<br>
 * Daoクラスを呼び出す実装クラス
 */
@Service
public class UserInfoSearchServiceImpl implements UserInfoSearchService {

	@Autowired
	private UserInfoDao userInfoDao;

	/**
	 * 全ユーザ情報を取得する
	 * @return 全ユーザ情報
	 * @throws ParseException
	 */
	@Override
	public List<UserInfoDto> findUserAllDataByUserId(String userId) throws ParseException {
		return userInfoDao.getUserInfoByUserId(userId);
	}

	/**
	 * 指定されたデータIDからユーザ情報を取得する
	 * @param id
	 * @return ログインユーザ情報
	 * @throws ParseException
	 */
	@Override
	public UserInfoDto findUserInfoByDataId(String dataId) throws ParseException {
		return userInfoDao.getUserInfoByDataId(dataId);
	}

}

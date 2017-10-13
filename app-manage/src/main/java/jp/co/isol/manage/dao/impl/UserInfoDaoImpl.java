package jp.co.isol.manage.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.isol.manage.dao.UserInfoDao;
import jp.co.isol.manage.dto.UserInfoDto;
import jp.co.isol.manage.form.MenuForm;

/**
 * @author kou1210hei<br>
 * ユーザ情報のDaoクラス
 *
 */
@Repository
public class UserInfoDaoImpl implements UserInfoDao {

	/**
	 * 全ユーザ情報を検索
	 * @return result
	 */
	@Override
	public List<UserInfoDto> getUserAllData() {

		List<UserInfoDto> dtoList = new ArrayList<UserInfoDto>();
		int maxCount = 15;
		for (int i = 0; i < maxCount; i++) {
			UserInfoDto mocEntity = new UserInfoDto();
			mocEntity.setHeight(new BigDecimal(170.2).setScale(1, BigDecimal.ROUND_HALF_UP));
			mocEntity.setWeight(new BigDecimal(61.3).setScale(1, BigDecimal.ROUND_HALF_UP));
			mocEntity.setBmi(new BigDecimal(16).setScale(1, BigDecimal.ROUND_HALF_UP));
			mocEntity.setStandardWeight(new BigDecimal(58.6).setScale(1, BigDecimal.ROUND_HALF_UP));
			if (i % 3 == 0) {
				mocEntity.setHeight(new BigDecimal(170.1).setScale(1, BigDecimal.ROUND_HALF_UP));
				mocEntity.setWeight(new BigDecimal(59.4).setScale(1, BigDecimal.ROUND_HALF_UP));
				mocEntity.setBmi(new BigDecimal(15).setScale(1, BigDecimal.ROUND_HALF_UP));
				mocEntity.setStandardWeight(new BigDecimal(61.0).setScale(1, BigDecimal.ROUND_HALF_UP));
			} else if (i == 7) {
				mocEntity.setHeight(new BigDecimal(170.4).setScale(1, BigDecimal.ROUND_HALF_UP));
				mocEntity.setWeight(new BigDecimal(63.5).setScale(1, BigDecimal.ROUND_HALF_UP));
				mocEntity.setBmi(new BigDecimal(12).setScale(1, BigDecimal.ROUND_HALF_UP));
				mocEntity.setStandardWeight(new BigDecimal(64.2).setScale(1, BigDecimal.ROUND_HALF_UP));
			}
			dtoList.add(mocEntity);
		}
		return dtoList;
	}

	/**
	 * IDで指定されたレコードを返す
	 * @param id
	 * @return レコード
	 */
	@Override
	public UserInfoDto getUserInfoById(String id) {
		UserInfoDto dto = new UserInfoDto();
		dto.setId(id);
		dto.setHeight(new BigDecimal(170.2).setScale(1, BigDecimal.ROUND_HALF_UP));
		dto.setWeight(new BigDecimal(61.3).setScale(1, BigDecimal.ROUND_HALF_UP));
		dto.setBmi(new BigDecimal(16).setScale(1, BigDecimal.ROUND_HALF_UP));
		dto.setStandardWeight(new BigDecimal(58.6).setScale(1, BigDecimal.ROUND_HALF_UP));
		return dto;
	}

	/**
	 * ユーザ情報を登録する<br>
	 * @param menuForm
	 */
	@Override
	public void registUserUnfo(MenuForm menuForm) {
		// TODO 登録処理を追加すること
	}

}

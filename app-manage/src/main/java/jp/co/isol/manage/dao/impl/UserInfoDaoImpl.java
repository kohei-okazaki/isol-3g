package jp.co.isol.manage.dao.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.isol.common.util.DateUtil;
import jp.co.isol.manage.dao.UserInfoDao;
import jp.co.isol.manage.dto.UserInfoDto;

/**
 * @author kou1210hei<br>
 * ユーザ情報のDaoクラス
 *
 */
@Repository
public class UserInfoDaoImpl implements UserInfoDao {

	/**
	 * 指定したユーザIDのユーザ情報を全検索
	 * @return result
	 * @throws ParseException
	 */
	@Override
	public List<UserInfoDto> getUserInfoByUserId(String userId) throws ParseException {

		// FIXME
		List<UserInfoDto> dtoList = new ArrayList<UserInfoDto>();
		int maxCount = 13;
		for (int i = 0; i < maxCount; i++) {
			UserInfoDto dto = new UserInfoDto();
			dto.setDataId(String.valueOf(i));
			dto.setUserId(userId);
			if (i % 3 == 0) {
				dto.setHeight(new BigDecimal(170.1).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setWeight(new BigDecimal(59.4).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setBmi(new BigDecimal(15).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setStandardWeight(new BigDecimal(61.0).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setRecordDate(DateUtil.formatDate("2017/03/02 01:23:45"));
			} else if (i == 7) {
				dto.setHeight(new BigDecimal(170.4).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setWeight(new BigDecimal(63.5).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setBmi(new BigDecimal(12).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setStandardWeight(new BigDecimal(64.2).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setRecordDate(DateUtil.formatDate("2017/10/12 12:23:45"));
			} else {

			}
			dtoList.add(dto);
		}
		return dtoList;
	}

	/**
	 * IDで指定されたレコードを返す
	 * @param id
	 * @return レコード
	 * @throws ParseException
	 */
	@Override
	public UserInfoDto getUserInfoByDataId(String dateId) throws ParseException {

		// FIXME
		UserInfoDto dto = new UserInfoDto();
		dto.setDataId(dateId);
		dto.setHeight(new BigDecimal(170.2).setScale(1, BigDecimal.ROUND_HALF_UP));
		dto.setWeight(new BigDecimal(61.3).setScale(1, BigDecimal.ROUND_HALF_UP));
		dto.setBmi(new BigDecimal(16).setScale(1, BigDecimal.ROUND_HALF_UP));
		dto.setStandardWeight(new BigDecimal(58.6).setScale(1, BigDecimal.ROUND_HALF_UP));
		dto.setRecordDate(DateUtil.formatDate("2017/10/12 12:23:45"));
		return dto;
	}

	/**
	 * ユーザ情報を登録する<br>
	 * @param menuForm
	 */
	@Override
	public void registUserUnfo(UserInfoDto dto) {
		// TODO 登録処理を追加すること
	}

}

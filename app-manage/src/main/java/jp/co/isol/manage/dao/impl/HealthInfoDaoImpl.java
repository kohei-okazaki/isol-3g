package jp.co.isol.manage.dao.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.isol.common.code.CodeManager;
import jp.co.isol.common.code.MainKey;
import jp.co.isol.common.code.SubKey;
import jp.co.isol.common.util.DateUtil;
import jp.co.isol.manage.dao.HealthInfoDao;
import jp.co.isol.manage.dto.HealthInfoDto;

/**
 * @author kou1210hei<br>
 * ユーザ情報のDaoクラス
 *
 */
@Repository
public class HealthInfoDaoImpl implements HealthInfoDao {

	/**
	 * 指定したユーザIDのユーザ情報を全検索
	 * @param userId
	 * @return result
	 * @throws ParseException
	 */
	@Override
	public List<HealthInfoDto> getHealthInfoByUserId(String userId) throws ParseException {

		// FIXME
		List<HealthInfoDto> dtoList = new ArrayList<HealthInfoDto>();
		int maxCount = 13;
		for (int i = 0; i < maxCount; i++) {
			HealthInfoDto dto = new HealthInfoDto();
			dto.setDataId(String.valueOf(i));
			dto.setUserId(userId);
			if (i % 3 == 0) {
				dto.setHeight(new BigDecimal(176.8).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setWeight(new BigDecimal(64.9).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setBmi(new BigDecimal(15.7).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setStandardWeight(new BigDecimal(61.0).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setUserStatus(CodeManager.getInstance().getValue(MainKey.HEALTH_INFO_USER_STATUS, SubKey.DOWN));
				dto.setRecordDate(DateUtil.formatDate("2017/03/02 01:23:45"));
			} else if (i == 7) {
				dto.setHeight(new BigDecimal(176.4).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setWeight(new BigDecimal(63.5).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setBmi(new BigDecimal(18.7).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setStandardWeight(new BigDecimal(64.2).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setUserStatus(CodeManager.getInstance().getValue(MainKey.HEALTH_INFO_USER_STATUS, SubKey.DOWN));
				dto.setRecordDate(DateUtil.formatDate("2017/10/12 12:23:45"));
			} else {
				dto.setHeight(new BigDecimal(176.5).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setWeight(new BigDecimal(63.5).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setBmi(new BigDecimal(18.9).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setStandardWeight(new BigDecimal(64.2).setScale(1, BigDecimal.ROUND_HALF_UP));
				dto.setUserStatus(CodeManager.getInstance().getValue(MainKey.HEALTH_INFO_USER_STATUS, SubKey.DOWN));
				dto.setRecordDate(DateUtil.formatDate("2017/10/15 15:45:45"));
			}
			dtoList.add(dto);
		}
		return dtoList;
	}

	/**
	 * 指定されたデータIDに対応するレコードを返す
	 * @param dateId
	 * @return レコード
	 * @throws ParseException
	 */
	@Override
	public HealthInfoDto getHealthInfoByDataId(String dateId) throws ParseException {

		// FIXME
		HealthInfoDto dto = new HealthInfoDto();
		dto.setDataId(dateId);
		dto.setHeight(new BigDecimal(170.2).setScale(1, BigDecimal.ROUND_HALF_UP));
		dto.setWeight(new BigDecimal(61.3).setScale(1, BigDecimal.ROUND_HALF_UP));
		dto.setBmi(new BigDecimal(16).setScale(1, BigDecimal.ROUND_HALF_UP));
		dto.setStandardWeight(new BigDecimal(58.6).setScale(1, BigDecimal.ROUND_HALF_UP));
		dto.setUserStatus(CodeManager.getInstance().getValue(MainKey.HEALTH_INFO_USER_STATUS, SubKey.DOWN));
		dto.setRecordDate(DateUtil.formatDate("2017/10/12 12:23:45"));
		return dto;
	}

	/**
	 * ユーザ情報を登録する<br>
	 * @param dto
	 */
	@Override
	public void registHealthInfo(HealthInfoDto dto) {
		// TODO 登録処理を追加すること
	}

}

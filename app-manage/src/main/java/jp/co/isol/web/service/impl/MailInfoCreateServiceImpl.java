package jp.co.isol.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isol.common.dao.MailInfoDao;
import jp.co.isol.common.entity.MailInfo;
import jp.co.isol.web.service.MailInfoCreateService;

/**
 * メール情報作成サービスインターフェース実装クラス<br>
 *
 */
@Service
public class MailInfoCreateServiceImpl implements MailInfoCreateService {

	/** メール情報Dao */
	@Autowired
	private MailInfoDao mailInfoDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void create(MailInfo mailInfo) {
		mailInfoDao.registMailInfo(mailInfo);
	}

}

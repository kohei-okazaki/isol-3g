package jp.co.isol.manage.service.impl;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import jp.co.isol.common.dao.AccountDao;
import jp.co.isol.common.dao.MailInfoDao;
import jp.co.isol.common.dto.AccountDto;
import jp.co.isol.common.dto.MailInfoDto;
import jp.co.isol.manage.config.ManageConfig;
import jp.co.isol.manage.form.AccountSettingForm;
import jp.co.isol.manage.log.ManageLogger;
import jp.co.isol.manage.service.AccountSettingService;

/**
 * アカウント設定サービス実装クラス<br>
 *
 */
@Service
public class AccountSettingServiceImpl implements AccountSettingService {

	/** アカウント情報Dao */
	@Autowired
	private AccountDao accountDao;
	/** メール情報Dao */
	@Autowired
	private MailInfoDao mailInfoDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(AccountSettingForm form) {

		// アカウント情報を更新する
		updateAccount(form);

		// メール情報を更新する
		updateMainInfo(form);
	}

	/**
	 * {@inheritDoc}
	 */
	private void updateAccount(AccountSettingForm form) {

		AccountDto accountDto = new AccountDto();
		accountDto.setUserId(form.getUserId());
		accountDto.setPassword(form.getPassword());
		accountDto.setFileEnclosureCharFlag(form.getFileEnclosureCharFlag());
		accountDto.setRemarks(form.getRemarks());
		accountDto.setUpdateDate(new Date());
		accountDao.updateAccount(accountDto);
	}

	/**
	 * {@inheritDoc}
	 */
	private void updateMainInfo(AccountSettingForm form) {

		MailInfoDto mailInfoDto = new MailInfoDto();
		mailInfoDto.setUserId(form.getUserId());
		mailInfoDto.setMailAddress(form.getMailAddress());
		mailInfoDto.setMailPassword(form.getMailPassword());
		mailInfoDao.updateMailInfo(mailInfoDto);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAccount(AccountSettingForm form) {
		accountDao.deleteAccount(form.getUserId());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean invalidForm(AccountSettingForm form) {

		ManageLogger logger;

		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
		}

		Class<AccountSettingForm> clazz = AccountSettingForm.class;
		List<Field> fieldList = Arrays.asList(clazz.getDeclaredFields());
		Object value = null;
		try {
			for (Field field : fieldList) {
				PropertyDescriptor prop = new PropertyDescriptor(field.getName(), clazz);
				value = prop.getReadMethod().invoke(form, clazz);
				if (Objects.isNull(value)) {
					return true;
				}
			}
		} catch (IntrospectionException e) {
			logger.error(this.getClass(), "プロパティの読み込みに失敗しました");
		} catch (IllegalAccessException e) {
			logger.error(this.getClass(), "不正なアクセスが行われました");
		} catch (IllegalArgumentException e) {
			logger.error(this.getClass(), value + "引数が不正です");
		} catch (InvocationTargetException e) {
			logger.error(this.getClass(), "呼び出したメソッドがエラーを出力しました");
		}
		return false;
	}

}

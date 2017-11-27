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
import jp.co.isol.common.dto.AccountDto;
import jp.co.isol.manage.form.AccountSettingForm;
import jp.co.isol.manage.log.ManageLogger;
import jp.co.isol.manage.service.AccountSettingService;
import jp.co.isol.manage.web.config.ManageConfig;

/**
 * アカウント設定サービス実装クラス<br>
 *
 */
@Service
public class AccountSettingServiceImpl implements AccountSettingService {

	/** アカウント情報Dao */
	@Autowired
	private AccountDao accountDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void changePassword(AccountSettingForm form) {

		AccountDto accountDto = new AccountDto();
		accountDto.setUserId(form.getUserId());
		accountDto.setPassword(form.getPassword());
		accountDto.setUpdateDate(new Date());
		accountDao.updateAccount(accountDto);
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

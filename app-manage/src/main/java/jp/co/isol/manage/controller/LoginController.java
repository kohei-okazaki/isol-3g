package jp.co.isol.manage.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.isol.manage.log.ManageLogger;
import jp.co.isol.manage.view.View;
import jp.co.isol.manage.web.config.ManageConfig;
import jp.co.isol.manage.web.session.ManageSessionKey;
import jp.co.isol.manage.web.session.ManageSessionManager;

/**
 * 健康管理_ログイン画面コントローラクラス
 *
 */
@Controller
@RequestMapping("/login.html")
public class LoginController {

	/**
	 * ログイン画面
	 * @param model
	 * @param request
	 * @return ログイン画面
	 */
	@GetMapping
	public String login(Model model, HttpServletRequest request) {
		try {
			test();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		ManageLogger logger;
		ManageSessionManager sessionManager;
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ManageConfig.class)) {
			logger = context.getBean(ManageLogger.class);
			sessionManager = context.getBean(ManageSessionManager.class);
		}

		sessionManager.removeKey(request.getSession(), ManageSessionKey.USER_ID);
		logger.info(this.getClass(), "# login start");

		return View.LOGIN.getName();
	}

	private void test() throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {
		String targetPath = "C:\\work\\pleiades\\workspace\\isol-3g\\app-manage\\src\\main\\resources\\META-INF\\data.xlsx";

		Workbook workbook = WorkbookFactory.create(new File(targetPath));

		Sheet sheet = workbook.getSheet("code");

		Iterator<Row> iteRow = sheet.rowIterator();

		while (iteRow.hasNext()) {
			Row row = iteRow.next();

			Iterator<Cell> iteCell = row.cellIterator();

			while (iteCell.hasNext()) {
				Cell cell = iteCell.next();

				System.out.println(cell.getStringCellValue());
			}
		}


	}
}

package jp.co.isol.common.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.dao.DuplicateKeyException;

import jp.co.isol.common.dao.MailInfoDao;
import jp.co.isol.common.entity.MailInfo;
import jp.co.isol.common.other.DateFormatDefine;
import jp.co.isol.common.util.DateUtil;

/**
 * メール情報のDaoクラス
 *
 */
public class MailInfoDaoImpl implements MailInfoDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MailInfo getMailInfoByUserId(String userId) {

		MailInfo mailInfo = new MailInfo();

		try (Workbook workbook = WorkbookFactory.create(new File(RESOURCES))) {

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> iteRow = sheet.rowIterator();
			while (iteRow.hasNext()) {

				// 1行取得
				Row row = iteRow.next();

				// ヘッダーの場合、次のレコードに進む
				if (row.getRowNum() == HEADER_POSITION) continue;

				if (userId.equals(row.getCell(0).getStringCellValue())) {
					mailInfo.setUserId(row.getCell(0).getStringCellValue());
					mailInfo.setMailAddress(row.getCell(1).getStringCellValue());
					mailInfo.setMailPassword(row.getCell(2).getStringCellValue());
					mailInfo.setUpdateDate(DateUtil.formatDate(row.getCell(3).getStringCellValue()));
					mailInfo.setRegDate(DateUtil.formatDate(row.getCell(4).getStringCellValue()));
				}
			}
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		MailInfo mailInfo = new MailInfo();
//		mailInfo.setUserId(userId);
//		mailInfo.setMailAddress("test-001@test.jp");
//		mailInfo.setMailPassword("password");
//		mailInfo.setRegDate(new Date());
		return mailInfo;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateMailInfo(MailInfo mailInfo) {
		// TODO 更新処理を追加すること

		try (FileInputStream in = new FileInputStream(RESOURCES);
				Workbook workbook = WorkbookFactory.create(in);
				FileOutputStream fos = new FileOutputStream(RESOURCES)) {

			Sheet sheet = workbook.getSheet(SHEET);

			Iterator<Row> iteRow = sheet.rowIterator();
			while (iteRow.hasNext()) {

				// 1行取得
				Row row = iteRow.next();
				if (mailInfo.getUserId().equals(row.getCell(0).getStringCellValue())) {
					// ユーザIDをキーにEntityを取得
					row.getCell(0).setCellValue(mailInfo.getUserId());
					row.getCell(1).setCellValue(mailInfo.getMailAddress());
					row.getCell(2).setCellValue(mailInfo.getMailPassword());
					row.getCell(3).setCellValue(DateUtil.toString(new Date(), DateFormatDefine.YYYYMMDD_HHMMSS));
					row.getCell(4).setCellValue(DateUtil.toString(mailInfo.getRegDate(), DateFormatDefine.YYYYMMDD_HHMMSS));

				}
			}

			fos.flush();
			workbook.write(fos);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registMailInfo(MailInfo mailInfo) throws DuplicateKeyException {
		// TODO 登録処理を追加すること

		try (FileInputStream in = new FileInputStream(RESOURCES);
				Workbook workbook = WorkbookFactory.create(in);
				FileOutputStream fos = new FileOutputStream(RESOURCES)) {
			Sheet sheet = workbook.getSheet(SHEET);

			Row newRow = sheet.createRow(sheet.getLastRowNum() + 1);

			newRow.createCell(0).setCellValue(mailInfo.getUserId());
			newRow.createCell(1).setCellValue(mailInfo.getMailAddress());
			newRow.createCell(2).setCellValue(mailInfo.getMailPassword());
			newRow.createCell(3).setCellValue(DateUtil.toString(new Date(), DateFormatDefine.YYYYMMDD_HHMMSS));
			newRow.createCell(4).setCellValue(DateUtil.toString(new Date(), DateFormatDefine.YYYYMMDD_HHMMSS));

			fos.flush();
			workbook.write(fos);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package jp.co.isol.common.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import jp.co.isol.common.dao.AccountDao;
import jp.co.isol.common.dto.AccountDto;
import jp.co.isol.common.other.DateFormatDefine;
import jp.co.isol.common.util.DateUtil;

/**
 * アカウント情報のDaoクラス
 *
 */
public class AccountDaoImpl implements AccountDao {

	private static final String RESOURCES = "C:\\work\\data.xlsx";
	private static final String SHEET = "ACCOUNT";
	private static final int HEADER_POSITION = 0;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AccountDto getAccountByUserId(String userId) {

		AccountDto dto = new AccountDto();

		try (Workbook workbook = WorkbookFactory.create(new File(RESOURCES))) {
			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> iteRow = sheet.rowIterator();
			while (iteRow.hasNext()) {

				// 1行取得
				Row row = iteRow.next();
				if (row.getRowNum() == HEADER_POSITION) {
					// ヘッダーの場合、次のレコードに進む
					continue;
				}
				if (userId.equals(row.getCell(0).getStringCellValue())) {
					dto.setUserId(row.getCell(0).getStringCellValue());
					dto.setPassword(row.getCell(1).getStringCellValue());
					dto.setInvalidFlag(row.getCell(2).getStringCellValue());
					dto.setPasswordExpire(DateUtil.formatDate(row.getCell(3).getStringCellValue()));
					dto.setRemarks(row.getCell(4).getStringCellValue());
					dto.setFileEnclosureCharFlag(row.getCell(5).getStringCellValue());
					dto.setUpdateDate(DateUtil.formatDate(row.getCell(6).getStringCellValue()));
					dto.setRegDate(DateUtil.formatDate(row.getCell(7).getStringCellValue()));
				}
			}
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		AccountDto dto = new AccountDto();
//		dto.setUserId(userId);
//		dto.setPassword("password");
//		dto.setInvalidFlag("0");
//		dto.setPasswordExpire(new Date());
//		dto.setRemarks("ここは備考です。");
//		dto.setFileEnclosureCharFlag("1");
		return dto;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registAccount(AccountDto accountDto) throws DuplicateKeyException {
		// TODO 登録処理を追加すること

		try (FileInputStream in = new FileInputStream(RESOURCES);
				Workbook workbook = WorkbookFactory.create(in)) {
			Sheet sheet = workbook.getSheet(SHEET);
			Row newRow = sheet.createRow(sheet.getLastRowNum() + 1);
			newRow.createCell(0).setCellValue(accountDto.getUserId());
			newRow.createCell(1).setCellValue(accountDto.getPassword());
			newRow.createCell(2).setCellValue(accountDto.getInvalidFlag());
			newRow.createCell(3).setCellValue(DateUtil.toString(accountDto.getPasswordExpire(), DateFormatDefine.YYYYMMDD_HHMMSS));
			newRow.createCell(4).setCellValue(accountDto.getRemarks());
			newRow.createCell(5).setCellValue(accountDto.getFileEnclosureCharFlag());
			newRow.createCell(6).setCellValue(DateUtil.toString(new Date(), DateFormatDefine.YYYYMMDD_HHMMSS));
			newRow.createCell(7).setCellValue(DateUtil.toString(new Date(), DateFormatDefine.YYYYMMDD_HHMMSS));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateAccount(AccountDto accountDto) {
		// TODO 更新処理を追加すること
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAccount(String userId) {
		// TODO 削除処理を追加すること
	}

}

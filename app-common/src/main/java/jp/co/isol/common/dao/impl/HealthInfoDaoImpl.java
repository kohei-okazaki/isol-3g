package jp.co.isol.common.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.dao.DuplicateKeyException;

import jp.co.isol.common.dao.HealthInfoDao;
import jp.co.isol.common.dto.HealthInfoDto;
import jp.co.isol.common.util.DateUtil;

/**
 * 健康情報のDaoクラス
 *
 */
public class HealthInfoDaoImpl implements HealthInfoDao {

//	private static final String RESOURCES = "C:\\work\\pleiades\\workspace\\isol-3g\\app-common\\src\\main\\resources\\META-INF\\data.xlsx";
	private static final String RESOURCES = "C:\\work\\data.xlsx";
	private static final String SHEET = "HEALTH_INFO";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<HealthInfoDto> getHealthInfoByUserId(String userId) {

		String RESOURCES = "C:\\work\\data.xlsx";
		String SHEET = "HEALTH_INFO";
		List<HealthInfoDto> dtoList = new ArrayList<HealthInfoDto>();
		try (Workbook workbook = WorkbookFactory.create(new File(RESOURCES))) {
			Sheet sheet = workbook.getSheet(SHEET);

			Iterator<Row> iteRow = sheet.rowIterator();
			while (iteRow.hasNext()) {
				HealthInfoDto healthInfoDto = new HealthInfoDto();
				Row row = iteRow.next();
				if (row.getRowNum() == 0) {
					// ヘッダーの場合は次のレコードに進む
					continue;
				}
				if (userId.equals(row.getCell(1).getStringCellValue())) {
					healthInfoDto.setDataId(row.getCell(0).getStringCellValue());								// データID
					healthInfoDto.setUserId(row.getCell(1).getStringCellValue());								// ユーザID
					healthInfoDto.setHeight(new BigDecimal(row.getCell(2).getStringCellValue()));				// 身長
					healthInfoDto.setWeight(new BigDecimal(row.getCell(3).getStringCellValue()));				// 体重
					healthInfoDto.setBmi(new BigDecimal(row.getCell(4).getStringCellValue()));					// BMI
					healthInfoDto.setStandardWeight(new BigDecimal(row.getCell(5).getStringCellValue()));		// 標準体重
					healthInfoDto.setUserStatus(row.getCell(6).getStringCellValue());							// ユーザステータス
					healthInfoDto.setRegDate(DateUtil.formatDate(row.getCell(7).getStringCellValue()));			// 登録日時
					dtoList.add(healthInfoDto);
				}
			}
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}

		// FIXME
//		List<HealthInfoDto> dtoList = new ArrayList<HealthInfoDto>();
//		int maxCount = 13;
//		for (int i = 0; i < maxCount; i++) {
//			HealthInfoDto dto = new HealthInfoDto();
//			dto.setDataId(String.valueOf(i));
//			dto.setUserId(userId);
//			if (i % 3 == 0) {
//				dto.setHeight(new BigDecimal(176.8).setScale(1, RoundingMode.HALF_UP));
//				dto.setWeight(new BigDecimal(64.9).setScale(1, RoundingMode.HALF_UP));
//				dto.setBmi(new BigDecimal(15.7).setScale(1, RoundingMode.HALF_UP));
//				dto.setStandardWeight(new BigDecimal(61.0).setScale(1, RoundingMode.HALF_UP));
//				dto.setUserStatus(CodeManager.getInstance().getValue(MainKey.HEALTH_INFO_USER_STATUS, SubKey.DOWN));
//				dto.setRegDate(DateUtil.formatDate("2017/03/02 01:23:45"));
//			} else if (i == 7) {
//				dto.setHeight(new BigDecimal(176.4).setScale(1, RoundingMode.HALF_UP));
//				dto.setWeight(new BigDecimal(63.5).setScale(1, RoundingMode.HALF_UP));
//				dto.setBmi(new BigDecimal(18.7).setScale(1, RoundingMode.HALF_UP));
//				dto.setStandardWeight(new BigDecimal(64.2).setScale(1, RoundingMode.HALF_UP));
//				dto.setUserStatus(CodeManager.getInstance().getValue(MainKey.HEALTH_INFO_USER_STATUS, SubKey.DOWN));
//				dto.setRegDate(DateUtil.formatDate("2017/10/12 12:23:45"));
//			} else {
//				dto.setHeight(new BigDecimal(176.5).setScale(1, RoundingMode.HALF_UP));
//				dto.setWeight(new BigDecimal(63.5).setScale(1, RoundingMode.HALF_UP));
//				dto.setBmi(new BigDecimal(18.9).setScale(1, RoundingMode.HALF_UP));
//				dto.setStandardWeight(new BigDecimal(64.2).setScale(1, RoundingMode.HALF_UP));
//				dto.setUserStatus(CodeManager.getInstance().getValue(MainKey.HEALTH_INFO_USER_STATUS, SubKey.DOWN));
//				dto.setRegDate(DateUtil.formatDate("2017/10/15 15:45:45"));
//			}
//			dtoList.add(dto);
//		}
		return dtoList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HealthInfoDto getHealthInfoByDataId(String dateId) {

		HealthInfoDto healthInfoDto = new HealthInfoDto();
		try {
			Workbook workbook = WorkbookFactory.create(new File(RESOURCES));
			Sheet sheet = workbook.getSheet(SHEET);

			Iterator<Row> iteRow = sheet.rowIterator();
			while (iteRow.hasNext()) {
				Row row = iteRow.next();
				if (row.getRowNum() == 0) {
					// ヘッダーの場合は次のレコードに進む
					continue;
				}
				if (dateId.equals(row.getCell(0).getStringCellValue())) {
					healthInfoDto.setDataId(row.getCell(0).getStringCellValue());								// データID
					healthInfoDto.setUserId(row.getCell(1).getStringCellValue());								// ユーザID
					healthInfoDto.setHeight(new BigDecimal(row.getCell(2).getStringCellValue()));				// 身長
					healthInfoDto.setWeight(new BigDecimal(row.getCell(3).getStringCellValue()));				// 体重
					healthInfoDto.setBmi(new BigDecimal(row.getCell(4).getStringCellValue()));					// BMI
					healthInfoDto.setStandardWeight(new BigDecimal(row.getCell(5).getStringCellValue()));		// 標準体重
					healthInfoDto.setUserStatus(row.getCell(6).getStringCellValue());							// ユーザステータス
					healthInfoDto.setRegDate(DateUtil.formatDate(row.getCell(7).getStringCellValue()));			// 登録日時
				}
			}
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// FIXME
//		HealthInfoDto healthInfoDto = new HealthInfoDto();
//		healthInfoDto.setDataId(dateId);
//		healthInfoDto.setHeight(new BigDecimal(171.2).setScale(1, RoundingMode.HALF_UP));
//		healthInfoDto.setWeight(new BigDecimal(61.3).setScale(1, RoundingMode.HALF_UP));
//		healthInfoDto.setBmi(new BigDecimal(16).setScale(1, RoundingMode.HALF_UP));
//		healthInfoDto.setStandardWeight(new BigDecimal(58.6).setScale(1, RoundingMode.HALF_UP));
//		healthInfoDto.setUserStatus(CodeManager.getInstance().getValue(MainKey.HEALTH_INFO_USER_STATUS, SubKey.DOWN));
//		healthInfoDto.setRegDate(DateUtil.formatDate("2017/10/12 12:23:45"));
		return healthInfoDto;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registHealthInfo(HealthInfoDto dto) throws DuplicateKeyException {

		// TODO 登録処理を追加すること
		try (FileInputStream in = new FileInputStream(RESOURCES)) {
			Workbook workbook = WorkbookFactory.create(in);
			Sheet sheet = workbook.getSheet(SHEET);

			Row newRow = sheet.createRow(sheet.getLastRowNum() + 1);

			newRow.createCell(0).setCellValue(String.valueOf(sheet.getLastRowNum()));						// データID
			newRow.createCell(1).setCellValue(dto.getUserId());												// ユーザID
			newRow.createCell(2).setCellValue(dto.getHeight().toString());									// 身長
			newRow.createCell(3).setCellValue(dto.getWeight().toString());									// 体重
			newRow.createCell(4).setCellValue(dto.getBmi().toString());										// BMI
			newRow.createCell(5).setCellValue(dto.getStandardWeight().toString());							// 標準体重
			newRow.createCell(6).setCellValue(dto.getUserStatus());											// ユーザステータス
			newRow.createCell(7).setCellValue(DateUtil.toString(new Date(), DateUtil.YYYYMMDD_HHMMSS));		// 登録日時

			try (FileOutputStream fos = new FileOutputStream(RESOURCES)) {

				fos.flush();
				workbook.write(fos);
			} finally {
				if (Objects.nonNull(workbook)) {
					workbook.close();
				}
			}
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

}

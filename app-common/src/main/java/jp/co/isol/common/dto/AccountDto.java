package jp.co.isol.common.dto;

import java.util.Date;

/**
 * アカウントのDto
 *
 */
public class AccountDto {

	/** ユーザID */
	private String userId;

	/** パスワード */
	private String password;

	/** 削除フラグ */
	private String deleteFlag;

	/** パスワード有効期限 */
	private Date passwordExpire;

	/** 備考 */
	private String remarks;

	/** 囲い文字利用フラグ */
	private String fileEnclosureCharFlag;

	/** 更新日時 */
	private Date updateDate;

	/** 登録日時 */
	private Date regDate;

	/**
	 * userIdを返す
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * userIdを設定する
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * passwordを返す
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * passwordを設定する
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * deleteFlagを返す
	 * @return deleteFlag
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * deleteFlagを設定する
	 * @param deleteFlag
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * passwordExpireを返す
	 * @return passwordExpire
	 */
	public Date getPasswordExpire() {
		return passwordExpire;
	}

	/**
	 * passwordExpireを設定する
	 * @param passwordExpire
	 */
	public void setPasswordExpire(Date passwordExpire) {
		this.passwordExpire = passwordExpire;
	}

	/**
	 * remarksを返す
	 * @return remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * remarksを設定する
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * fileEnclosureCharFlagを返す
	 * @return fileEnclosureCharFlag
	 */
	public String getFileEnclosureCharFlag() {
		return fileEnclosureCharFlag;
	}

	/**
	 * fileEnclosureCharFlagを設定する
	 * @param fileEnclosureCharFlag
	 */
	public void setFileEnclosureCharFlag(String fileEnclosureCharFlag) {
		this.fileEnclosureCharFlag = fileEnclosureCharFlag;
	}

	/**
	 * updateDateを返す
	 * @return updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * updateDateを設定する
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * regDateを返す
	 * @return regDate
	 */
	public Date getRegDate() {
		return regDate;
	}

	/**
	 * regDateを設定する
	 * @param regDate
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

}

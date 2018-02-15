package jp.co.isol.common.dto;

/**
 * 定数クラスのDto
 *
 */
public class CodeDto {

	private String mainKey;

	private String subKey;

	private String value;

	/**
	 * mainKeyを返す
	 * @return mainKey
	 */
	public String getMainKey() {
		return mainKey;
	}

	/**
	 * mainKeyを設定する
	 * @param mainKey
	 */
	public void setMainKey(String mainKey) {
		this.mainKey = mainKey;
	}

	/**
	 * subKeyを返す
	 * @return subKey
	 */
	public String getSubKey() {
		return subKey;
	}

	/**
	 * subKeyを設定する
	 * @param subKey
	 */
	public void setSubKey(String subKey) {
		this.subKey = subKey;
	}

	/**
	 * valueを返す
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * valueを設定する
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

}

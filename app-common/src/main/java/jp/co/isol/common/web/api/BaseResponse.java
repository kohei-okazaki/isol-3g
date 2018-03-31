package jp.co.isol.common.web.api;

/**
 * APIの基底レスポンスクラス<br>
 *
 */
public abstract class BaseResponse {

	/** 結果 */
	private int result;

	/**
	 * resultを返す
	 * @return result
	 */
	public int getResult() {
		return result;
	}

	/**
	 * resultを設定する
	 * @param result
	 */
	public void setResult(int result) {
		this.result = result;
	}

	/**
	 * 正常系の時の結果をセットする<br>
	 */
	protected void setSuccessResult() {
		this.result = 0;
	}

	/**
	 * 異常系の時の結果をセットする<br>
	 */
	protected void setErrorResult() {
		this.result = 1;
	}

}

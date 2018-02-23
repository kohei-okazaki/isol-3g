package jp.co.isol.common.other;

/**
 * HTTPメソッドの定義<br>
 *
 */
public enum HttpMethod {

	GET,
	POST;

	public static boolean isGet(String httpMethod) {
		return GET.toString().equals(httpMethod);
	}

	public static boolean isPost(String httpMethod) {
		return POST.toString().equals(httpMethod);
	}
}

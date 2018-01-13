package jp.co.isol.api.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import jp.co.isol.common.web.api.BaseResponse;

/**
 * APIAspectクラス<br>
 * 開始ログ、終了ログを定義する<br>
 */
@Aspect
@Component
public class ApiAspect {

	/**
	 * 開始ログ出力する<br>
	 * @param joinpoint
	 */
	@Before("execution(* *..*ServiceImpl.execute(..))*")
	public void outStartServiceLog(JoinPoint joinpoint) {
		System.out.println("■■■■■■■■■■■■■■■■■サービスクラス開始■■■■■■■■■■■■■■■" + joinpoint.toString());
	}

	/**
	 * 終了ログ出力する<br>
	 * @param joinpoint
	 */
	@After("execution(* *..*ServiceImpl.execute(..))*")
	public void outEndServiceLog(JoinPoint joinpoint) {
		System.out.println("■■■■■■■■■■■■■■■サービスクラス終了■■■■■■■■■■■■■■■" + joinpoint.toString());
	}

	/**
	 * サービスクラス#execute実行ログを出力
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* *..*ServiceImpl.execute(..))*")
	public Object outMethodLog(ProceedingJoinPoint pjp) throws Throwable {

		try {
			Object response = pjp.proceed();
			System.out.println("メソッド正常終了:" + pjp.getSignature() + " 戻り値:" + ((BaseResponse) response).toString());
			return response;

		} catch (Exception e) {

			System.out.println("メソッド異常終了:" + pjp.getSignature());
			e.printStackTrace();
			throw e;
		}
	}
}

package jp.co.isol.manage.aspect;

import java.util.Objects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 管理画面Aspectクラス<br>
 *
 */
@Aspect
@Component
public class ManageAspect {

	/**
	 * 開始ログ出力する<br>
	 * @param joinpoint
	 */
	@Before("execution(* *..*ServiceImpl.*(..))*")
	public void startServiceLog(JoinPoint joinpoint) {
		System.out.println("■■■■■■■■■■■■■■■開始■■■■■■■■■■■■■■■" + joinpoint.toString());
	}

	/**
	 * 終了ログ出力する<br>
	 * @param joinpoint
	 */
	@After("execution(* *..*ServiceImpl.*(..))*")
	public void endServiceLog(JoinPoint joinpoint) {
		System.out.println("■■■■■■■■■■■■■■■終了■■■■■■■■■■■■■■■" + joinpoint.toString());
	}

	/**
	 * サービスクラスのメソッド実行ログを出力
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* *..*ServiceImpl.*(..))*")
	public Object outMethodLog(ProceedingJoinPoint pjp) throws Throwable {

		try {
			Object result = pjp.proceed();
			if (Objects.isNull(result)) {
				System.out.println("メソッド正常終了:" + pjp.getSignature());
			} else {
				System.out.println("メソッド正常終了:" + pjp.getSignature() + " 戻り値:" + result.toString());
			}

			return result;

		} catch (Exception e) {

			System.out.println("メソッド異常終了:" + pjp.getSignature());
			e.printStackTrace();
			throw e;
		}
	}
}

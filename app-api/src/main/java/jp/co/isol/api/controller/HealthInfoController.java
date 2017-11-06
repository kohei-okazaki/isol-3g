package jp.co.isol.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.isol.api.service.HealthInfoService;

/**
 * @author kou1210hei<br>
 * 健康情報APIコントローラ<br>
 *
 */
@RestController
@RequestMapping("/healthInfo")
public class HealthInfoController {

	@Autowired
	private HealthInfoService healthInfoService;

	@GetMapping
	public void get(HttpServletRequest request) {
		String name = request.getParameter("name");
		String message = "###get()";

		healthInfoService.execute();
		System.out.println(message);
	}

	@PostMapping
	public void post(HttpServletRequest request) {
		String message = "###post()";
		System.out.println(message);
	}
}

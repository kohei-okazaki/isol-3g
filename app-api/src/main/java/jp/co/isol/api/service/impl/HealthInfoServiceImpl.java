package jp.co.isol.api.service.impl;

import org.springframework.stereotype.Service;

import jp.co.isol.api.service.HealthInfoService;

@Service
public class HealthInfoServiceImpl implements HealthInfoService {

	@Override
	public void execute() {
		System.out.println("HealthInfoServiceImpl ---> execute()");
	}

}

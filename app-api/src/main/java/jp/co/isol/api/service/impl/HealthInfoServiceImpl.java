package jp.co.isol.api.service.impl;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.isol.api.service.HealthInfoService;

@Service
public class HealthInfoServiceImpl implements HealthInfoService {

	@Override
	public void execute() {
		System.out.println("HealthInfoServiceImpl ---> execute()");

		ObjectMapper mapper = new ObjectMapper();
	}

}

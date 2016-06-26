package com.suning.arttrain.service;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.suning.arttrain.common.exception.ParamsValidatorException;
import com.suning.arttrain.param.CasUserCreateParam;

@JsonRpcService("CasUserService.json")
public interface CasUserService {

	//boolean findCasUserNameExists(String userName);

	/**
	 * 保存用户信息
	 * 
	 * @param param
	 * @throws ParamsValidatorException
	 */
	void saveCasUser(CasUserCreateParam param) throws Exception;

}

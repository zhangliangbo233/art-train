package com.suning.arttrain.service;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.suning.arttrain.param.CasUserCreateParam;

@JsonRpcService("CasUserService.json")
public interface CasUserService {

	//boolean findCasUserNameExists(String userName);

	/**
	 * 保存用户信息
	 * 
	 * @param param
	 * @throws
	 */
	void saveCasUser(CasUserCreateParam param);

}

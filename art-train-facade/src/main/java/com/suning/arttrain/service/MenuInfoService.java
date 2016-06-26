package com.suning.arttrain.service;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.suning.arttrain.persistent.MenuInfo;

import java.util.List;

@JsonRpcService("/MenuInfoService.json")
public interface MenuInfoService {

	public List<MenuInfo> listMenuInfos(Long id);

}

package com.suning.arttrain.repository;

import com.suning.arttrain.persistent.MenuInfo;

import java.util.List;

@MyBatisRepository("menuInfoRepository")
public interface MenuInfoRepository {

	public List<MenuInfo> listMenuInfos(Long id);

}

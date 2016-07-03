package com.suning.arttrain.service;

import com.suning.arttrain.persistent.MenuInfo;
import com.suning.arttrain.repository.MenuInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuInfoService")
public class MenuInfoServiceImpl implements MenuInfoService {


    @Autowired
	private MenuInfoRepository menuInfoRepository;

    @Override
    public List<MenuInfo> listMenuInfos(Long id) {
        return menuInfoRepository.listMenuInfos(id);
    }
}

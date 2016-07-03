package com.suning.arttrain.service;

import java.util.Date;

import com.suning.arttrain.exception.ParamValidateException;
import com.suning.arttrain.util.OvalUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.suning.arttrain.common.util.DateUtil;
import com.suning.arttrain.param.CasUserCreateParam;
import com.suning.arttrain.persistent.CasUser;
import com.suning.arttrain.repository.CasUserRepository;

@Service("casUserService")
public class CasUserServiceImpl implements CasUserService {

	@Autowired
	private CasUserRepository casUserRepository;

	@Autowired
	private Md5PasswordEncoder md5Encoder;

	@Override
	public void saveCasUser(CasUserCreateParam param){
		// 校验参数合法性
		OvalUtil.validate(param);

		int countRegisted = casUserRepository.countByUserName(param
				.getUserName());
		if (countRegisted > 0) {
			throw new ParamValidateException("用户已经注册");
		}

		CasUser casUser = new CasUser();
		BeanUtils.copyProperties(param, casUser);
		Date now = DateUtil.now();
		casUser.setCreateTime(now);
        casUser.setEnabled(1);
		casUser.setPassword(md5Encoder.encodePassword(param.getPassword(),
				param.getUserName()));

		casUserRepository.save(casUser);
	}

}

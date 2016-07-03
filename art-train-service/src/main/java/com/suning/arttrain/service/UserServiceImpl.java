package com.suning.arttrain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suning.arttrain.dto.UserDto;
import com.suning.arttrain.dto.UserRoleDto;
import com.suning.arttrain.param.UserDetailParam;
import com.suning.arttrain.repository.UserRepository;
import com.suning.arttrain.repository.UserRoleRepository;

@Service
public class UserServiceImpl implements UserService {
	
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserRoleRepository userRoleRepository;

	@Override
	public UserDto loginByUsername(UserDetailParam param) {
		String userName = param.getUserName();
		UserDto userDto = userRepository.loadUserByUserName(userName);
		/*
		 * if(null == userDto){ User user = new User();
		 * user.setUserName(userName); user.setLatestTime(DateUtil.now());
		 * user.setEnabled(UserStatusEnum.ENABLED.code);
		 * 
		 * long userId = userRepository.save(user);
		 * 
		 * UserRole userRole = new UserRole(userId, userName,
		 * UserRoleEnum.ROLE_USER.msg); userRoleRepository.save(userRole);
		 * 
		 * BeanUtils.copyProperties(user, userDto); }
		 */
		return userDto;
	}

	@Override
	public List<UserRoleDto> listRolesByUsername(UserDetailParam param) {
		return userRoleRepository.listRolesByUsername(param.getUserName());
	}
}

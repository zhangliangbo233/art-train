package com.suning.arttrain.repository;

import com.suning.arttrain.dto.UserDto;

@MyBatisRepository
public interface UserRepository {

	UserDto loadUserByUserName(String userName);

}

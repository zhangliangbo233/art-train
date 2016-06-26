package com.suning.arttrain.repository;

import java.util.List;

import com.suning.arttrain.dto.UserRoleDto;
import com.suning.arttrain.persistent.UserRole;

/**
 * 
 * @author zhanglb
 * 
 */
@MyBatisRepository
public interface UserRoleRepository {

	long save(UserRole userRole);

	long saveBatch(List<UserRole> userRoles);

	List<UserRoleDto> listRolesByUsername(String userName);

}

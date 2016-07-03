package com.suning.arttrain.repository;

import org.springframework.data.repository.query.Param;

import com.suning.arttrain.persistent.CasUser;

/**
 * 
 * @author zhanglb
 * 
 */
@MyBatisRepository("casUserRepository")
public interface CasUserRepository {

	void save(CasUser casUser);

	int countByUserName(@Param("userName") String userName);

	CasUser findCasUserByUsername(@Param("userName") String userName);

	void updateCasUserPassword(@Param("useName") String userName,
			@Param("encodePassword") String encodePassword);

}

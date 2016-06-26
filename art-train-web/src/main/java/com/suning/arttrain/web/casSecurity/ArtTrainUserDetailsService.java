package com.suning.arttrain.web.casSecurity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.suning.arttrain.common.util.JsonRpcClientUtil;
import com.suning.arttrain.common.util.ServiceTypeEnum;
import com.suning.arttrain.dto.UserDto;
import com.suning.arttrain.dto.UserRoleDto;
import com.suning.arttrain.param.UserDetailParam;
import com.suning.arttrain.service.UserService;

@SuppressWarnings("all")
public class ArtTrainUserDetailsService implements UserDetailsService,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6434670800259687392L;

	private final static Logger logger = LoggerFactory
			.getLogger(ArtTrainUserDetailsService.class);

	@Autowired
	private JsonRpcClientUtil jsonRpcClientUtil;

	public ArtTrainUserDetailsService() {
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserDto user = null;
		List<UserRoleDto> roles;
		List<GrantedAuthority> authorities = null;

		try {
			UserDetailParam param = new UserDetailParam();
			param.setUserName(username);
			user = (UserDto) jsonRpcClientUtil.doService(UserService.class,
					"loginByUsername", param);

			if (null == user) {
				throw new Exception("用户不存在");
			}

			if (user.getEnabled() != 1) {
				throw new DisabledException("您的账号已经被冻结");
			}

			roles = (List<UserRoleDto>) jsonRpcClientUtil.doService(
					UserService.class, "listRolesByUsername", param);

			authorities = new ArrayList<GrantedAuthority>();

			for (UserRoleDto ur : roles) {
				//authorities.add(new GrantedAuthorityImpl(ur.getRoleName()));
			}
		} catch (Throwable e) {
			logger.error(e.getMessage(), e);
		}

		return new ArtTrainUserDetail(user.getUserId(), user.getUserName(),
				user.getEnabled() == 1, authorities);
	}
}

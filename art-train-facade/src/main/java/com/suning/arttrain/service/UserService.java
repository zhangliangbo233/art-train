package com.suning.arttrain.service;

import java.util.List;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.suning.arttrain.common.exception.ParamsValidatorException;
import com.suning.arttrain.dto.UserDto;
import com.suning.arttrain.dto.UserRoleDto;
import com.suning.arttrain.param.UserDetailParam;

@JsonRpcService(value = "/UserService.json")
public interface UserService
{
    /**
     * 保存用户信息
     * 
     * @param param
     * @throws ParamsValidatorException
     */
    //void saveUser(UserCreateParam param) throws ParamsValidatorException, UcException;

    UserDto loginByUsername(UserDetailParam param);

    List<UserRoleDto> listRolesByUsername(UserDetailParam param);

}

package com.suning.arttrain.common.util;

import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import com.suning.arttrain.common.exception.ParamsValidatorException;

/**
 * 参数校验
 * 
 * @author zhanglb
 * 
 */
public class OvalUtil {

	public static void validate(Object cmd) throws ParamsValidatorException {
		Validator validator = new Validator();
		List<ConstraintViolation> violations = validator.validate(cmd);
		if (null != violations && violations.size() > 0) {
			throw new ParamsValidatorException(violations.get(0).getMessage());
		}
	}

}

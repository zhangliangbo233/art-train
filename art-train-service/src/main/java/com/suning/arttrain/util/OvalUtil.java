package com.suning.arttrain.util;

import com.suning.arttrain.exception.ParamValidateException;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import java.util.List;

/**
 * 参数校验
 * 
 * @author zhanglb
 * 
 */
public class OvalUtil {

	public static void validate(Object param) throws ParamValidateException {
		Validator validator = new Validator();
		List<ConstraintViolation> violations = validator.validate(param);
		if (null != violations && violations.size() > 0) {
			throw new ParamValidateException(violations.get(0).getMessage());
		}
	}

}

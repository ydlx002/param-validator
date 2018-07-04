package io.github.ydlx.constraints;

import io.github.ydlx.annotation.NotNull;
import io.github.ydlx.constant.ResultCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 校验器
 * @Package io.github.ydlx.constraints
 * @Author lizhenhua
 * @Date 2018/6/21 15:13
 */
public class NotNullValidator extends BaseValidator implements ConstraintValidator<NotNull,Object> {

    public void initialize(NotNull notNull) {

    }

    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(null == o){
            this.setResultCodeWithMsg(constraintValidatorContext, ResultCode.RESULT_CODE_0001);
            return false;
        }
        return true;
    }

}

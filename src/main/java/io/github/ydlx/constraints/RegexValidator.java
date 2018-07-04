package io.github.ydlx.constraints;

import io.github.ydlx.annotation.Regex;
import io.github.ydlx.annotation.StringLength;
import io.github.ydlx.constant.ResultCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 校验器
 * @Package io.github.ydlx.constraints
 * @Author lizhenhua
 * @Date 2018/6/21 15:13
 */
public class RegexValidator extends BaseValidator implements ConstraintValidator<Regex,Object> {

    private String regex;

    public void initialize(Regex regex) {
        this.regex = regex.value();
    }

    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if(null != value && value instanceof String){
            if(!Pattern.matches(regex, String.valueOf(value))){
                this.setResultCodeWithMsg(constraintValidatorContext, ResultCode.RESULT_CODE_0004);
                return false;
            }
        }
        return true;
    }

}

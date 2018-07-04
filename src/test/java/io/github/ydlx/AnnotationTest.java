package io.github.ydlx;

import io.github.ydlx.constant.VerifyResult;
import io.github.ydlx.validation.ParamValidator;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @Package io.github.ydlx
 * @Author lizhenhua
 * @Date 2018/6/21 16:16
 */
public class AnnotationTest {

    @Test
    public  void testValidation() {
        Student xiaoming = getBean();
        this.validate(xiaoming);
    }

    private  Student getBean() {
        Student bean = new Student();
        bean.setName(null);
        bean.setAddress("北京");
        bean.setBirthday(new Date());
        bean.setFriendName(null);
        bean.setWeight(new BigDecimal(30));
        bean.setEmail("xiaogangfan163.com");
        bean.setSpellName("XIAOGANGFAN");
        return bean;
    }

    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public  <T> void validate(T t) {
        Validator validator = factory.getValidator();
        ParamValidator validator1 = new ParamValidator(validator);

        VerifyResult result = validator1.validate(t);

        System.out.println(result.toString());
    }
}

package io.github.ydlx.validation;

import io.github.ydlx.annotation.EnumType;
import io.github.ydlx.annotation.NotEmpty;
import io.github.ydlx.annotation.StringLength;
import io.github.ydlx.constant.VerifyResult;
import org.junit.Test;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

/**
 * @Package io.github.ydlx.validation
 * @Author lizhenhua
 * @Date 2018/7/2 10:00
 */
public class ParamValidatorTest {


    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public  <T> void validate(T t) {
        ParamValidator validator = new ParamValidator(factory.getValidator());
        VerifyResult result = validator.validate(t);
        System.out.println(result);
    }

    @Test
    public void validate() throws Exception {
        Request request = new Request();
        request.setId(1);
        request.setStreamNo("4");
        request.setTest("test1");
        this.validate(request);
    }


    class Request{

        /**id*/
        @NotEmpty
        private Integer id;
        
        /**name*/
        @NotEmpty
        @StringLength(min = 2, max = 8)
        private String streamNo;

        /**test*/
        @EnumType(enums = {"test1","test2"})
        private String test;



        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getStreamNo() {
            return streamNo;
        }

        public void setStreamNo(String streamNo) {
            this.streamNo = streamNo;
        }

        public String getTest() {
            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }
    }


}
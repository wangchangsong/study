package com.wcs.start.start;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StartApplicationTests {

    @Test
    public void contextLoads() throws NoSuchMethodException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        ExecutableValidator validator = factory.getValidator().forExecutables();

        Method method = this.getClass().getMethod("validMethod", Integer.class, String.class, String.class);

        Object[] params = new Object[]{100, "", "test"};
        Set<ConstraintViolation<StartApplicationTests>> constraintViolationSet =
                validator.validateParameters(this, method, params);

        System.out.println("非法参数校验结果条数: " + constraintViolationSet.size());
        constraintViolationSet.forEach(cons -> {
            System.out.println("非法消息: " + cons.getMessage());
        });

        params = new Object[]{10, "build-test", "test"};
        constraintViolationSet =
                validator.validateParameters(this, method, params);

        System.out.println("合法参数校验结果条数: " + constraintViolationSet.size());

    }

    public void validMethod(@NotNull @Range(min = 0, max = 18)Integer age, @NotBlank String build, String test){}

}

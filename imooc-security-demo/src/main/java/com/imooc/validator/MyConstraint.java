package com.imooc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @类名: MyConstraint<br />
 * @包名：com.imooc.validator<br/>
 * @作者：kevin<br/>
 * @时间：2019/9/1 23:08<br/>
 * @版本：1.0<br/>
 * @描述：@Target指定注解可以用在哪些地方，@Retention指定注解可以运行在哪种环境中<br/>
 */
@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {MyConstraintValidator.class})
public @interface MyConstraint {

    String message();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

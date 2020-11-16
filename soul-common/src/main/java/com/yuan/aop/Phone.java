package com.yuan.aop;


import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.Length;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 验证手机号，空和正确的手机号都能验证通过<br/>
 * 正确的手机号由11位数字组成，第一位为1
 * 第二位为 3、4、5、7、8
 */

//多个验证注解之间的逻辑关系-->这里使用“or”，满足任意即可【核心】
@ConstraintComposition(CompositionType.OR)
//正則
@Pattern(regexp = "1[3|4|5|6|7|8][0-9]\\d{8}")
//不可以为空
@Null
//使用Hiberante提供的字符串长度校验规则，在这里，表示惨参数字符串的长度必须：最短0，最长0（就是空字符串）
@Length(min = 0, max = 0)
//使用该注解的元素应被javadoc或类似工具文档化
@Documented
//来限定自定义注解的方法
@Constraint(validatedBy = {})
//支持注解的程序元素的种类(注解该用于什么地方)-->方法,参数,注解类型声明,域声明,构造器声明, 局部变量声明,包声明,类，接口,
@Target({METHOD, PARAMETER, ANNOTATION_TYPE, FIELD, CONSTRUCTOR, LOCAL_VARIABLE, PACKAGE, TYPE})
//保留时间的长短，需要在什么级别保存该注解信息-->运行时期
@Retention(RUNTIME)
@ReportAsSingleViolation
public @interface Phone {
    String message() default "手机号校验错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
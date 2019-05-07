package cn.navyd.annotation.leetcode;

import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表示该问题不熟练，未掌握。该注解不是必须的，未注解problem的默认为该注解
 * @see Problem
 * @author navyd
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(TYPE)
public @interface Unskilled {

}

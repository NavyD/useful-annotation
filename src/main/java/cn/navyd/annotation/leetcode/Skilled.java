package cn.navyd.annotation.leetcode;

import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表示该问题已掌握
 * @see Problem
 * @author navyd
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(TYPE)
public @interface Skilled {

}

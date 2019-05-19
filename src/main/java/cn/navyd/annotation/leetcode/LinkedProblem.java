package cn.navyd.annotation.leetcode;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 表示当前包中应该存在的problems，但是已经被解决并放到其他包中的problems
 * <p>如sort包存在并已解决insertSortList problem，但是该问题又存在linked list包中，
 * 所以只能在linked list包上注解LinkedProblems关联的problem。
 * <p>如果链接到多个包，应该使用多个注解分离，每个包一个
 * @author navyd
 *
 */
@Repeatable(LinkedProblems.class)
@Documented
@Retention(RUNTIME)
@Target(ElementType.PACKAGE)
public @interface LinkedProblem {
  Class<?>[] problems() default {};
}

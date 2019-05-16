package cn.navyd.annotation.leetcode;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 表示指定solution是其他的solution衍生而来。一般表示某个解法的变体。
 * <p>被注解的solution将不会被统计为一个单独的解法
 * @author navyd
 *
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface DerivedFrom {
  Class<?>[] value();
}

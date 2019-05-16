package cn.navyd.annotation.leetcode;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表示指定solution是最优的。该注解不是必须的，默认通过solution判断。
 * @author navyd
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Optimal {

  /**
   * 表示最优的是时间 还是空间，或两者都是。默认时间 空间 都是最优的
   * @return
   */
  Type[] value() default {Type.TIME, Type.SPACE};
  
  public static enum Type {
    SPACE, 
    TIME;
  }
}

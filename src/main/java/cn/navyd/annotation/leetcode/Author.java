package cn.navyd.annotation.leetcode;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 表示一个leetcode solution的作者。允许一个solution存在多个作者
 * @author navyd
 *
 */
@Repeatable(Authors.class)
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface Author {
  String name();
  
  /**
   * 是否是重要的作者
   * @return
   */
  boolean significant() default false;
  
  /**
   * 引用参考
   * @return
   */
  String[] referenceUrls() default "";
  
  String[] comments() default "";
}

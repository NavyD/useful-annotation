package cn.navyd.annotation.leetcode;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表示一个solution的提交结果
 * @author navyd
 *
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Submissions.class)
public @interface Submission {
  /**
   * 解决方案提供的时间。格式：{@linkplain java.time.format.DateTimeFormatter#ISO_LOCAL_DATE yyyy-MM-dd}
   * @return
   */
  String date();
  
  Status status() default Status.ACCEPTED;
  
  /**
   * 运行时间。单位 ms。默认值表示未定义
   * @return
   */
  int runtime() default -1;
  
  /**
   * 运行时间击败率
   * @return
   */
  double runtimeBeatRate() default -1;
  
  /**
   * 使用内存。单位 MB。默认值表示未定义
   * @return
   */
  double memory() default -1;
  
  /**
   * 内存击败比率
   * @return
   */
  double memoryBeatRate() default -1;
  
  /**
   * 提交结果页面url。
   * <p>注意：该功能是关联用户的，需要leetcode 用户登录
   * @return
   */
  String url();
  
  public static enum Status {
    WRONG,
    ACCEPTED,
    ;
  }
}
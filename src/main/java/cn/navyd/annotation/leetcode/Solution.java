package cn.navyd.annotation.leetcode;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import cn.navyd.annotation.leetcode.Problem.Tag;

/**
 * 表示是一个算法的解决方案
 * <p>规则
 * <ol>
 * <li>仅能被定义在class上，并且该class必须 实现 或 主动指定 被注解{@link Problem}的接口或抽象类
 * <li>当status=Accpted时其他类型字段才有效
 * <li>如果该类被定义在class命名空间中，则应该推荐命名SolutionBy[$Tag]
 * <li>
 * </ol>
 * @see Problem
 * @author navyd
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Solution {
  
  /**
   * 该解法所用的具体方法类型，如sort,heap。类似于{@link Problem#tags()}，只是属于solution特有的tag，如不指定则使用{@link Problem#tags()}
   * <p>可以使用非标准的{@link Tag}
   * @return
   */
  Tag[] tags() default Tag.NONE;
  
  /**
   * 时间复杂度。默认值表示未定义
   * @return
   */
  Complexity timeComplexity();
  
  /**
   * 空间复杂度。默认值表示未定义
   * @return
   */
  Complexity spaceComplexity();
  
  /**
   * 参考的url地址
   * @see {@link Author}
   * @return
   */
  @Deprecated
  String[] referenceUrls() default "";
  
  /**
   * @see {@link Author}
   * 提交的作者名称
   * @return
   */
  @Deprecated
  String author() default "";

  /**
   * 表示该solution解决的问题class定义。默认从注解class中提取super class 或 super interface的class
   * @return
   */
  @Deprecated
  Class<?> problem() default Object.class;
  
  /**
   * 表示该solution的状态。如已通过，错误，正在做
   * @return
   */
  @Deprecated
  Status status() default Status.ACCEPTED;
  
  /**
   * @deprecated {@link Submission#runtime()} 
   * 运行时间。单位 ms。默认值表示未定义
   * @return
   */
  @Deprecated
  int runtime() default -1;
  
  /**
   * 运行时间击败率
   * @return
   */
  @Deprecated
  double runtimeBeatRate() default -1;
  
  /**
   * 使用内存。单位 MB。默认值表示未定义
   * @return
   */
  @Deprecated
  double memory() default -1;
  
  /**
   * 内存击败比率
   * @return
   */
  @Deprecated
  double memoryBeatRate() default -1;
  
  /**
   * 解决方案提供的时间。格式：{@linkplain java.time.format.DateTimeFormatter#ISO_LOCAL_DATE yyyy-MM-dd}
   * <p>允许提供该方案多次被使用的时间，表示对应几刷的时间。
   * <p>时间应该是递增的
   * @return
   */
  @Deprecated
  String[] dates() default "";
  
  /**
   * 提交结果页面url。
   * <p>注意：该功能是关联用户的，需要leetcode 用户登录
   * @return
   */
  @Deprecated
  String submissionUrl() default "";

  @Deprecated
  public static enum Status {
    /**
     * 表示未完成，不是标准的leetcode status
     */
    TODO,
    WRONG,
    ACCEPTED;
  }
  
  /**
   * 定义了一些复杂度描述，{@code 1< K < N}
   * @author navyd
   *
   */
  public static enum Complexity {
    O_1("O(1)", 1),
    O_LOG_K("O(log K)", 5),
    O_LOG_N("O(log N)", 10),
    O_K("O(K)", 15),
    O_N("O(N)", 20),
    O_K_LOG_N("O(K log N)", 21),
    O_N_LOG_K("O(N log K)", 25),
    O_N_LOG_N("O(N log N)", 30),
    O_N_K("O(N * K)", 35),
    O_N_POW_2("O(N^2)", 40),
    ;
    private final String description;
    private final int sequencer;
    
    private Complexity(String description, int sequencer) {
      this.sequencer = sequencer;
      this.description = description;
    }
    
    public String getDescription() {
      return description;
    }
    
    public int getSequencer() {
      return sequencer;
    }
  }
}

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
  Complexity timeComplexity() default Complexity.NONE;
  
  /**
   * 空间复杂度。默认值表示未定义
   * @return
   */
  Complexity spaceComplexity() default Complexity.NONE;
  
  /**
   * 定义了一些复杂度描述，{@code 1< K < N}
   * @author navyd
   *
   */
  public static enum Complexity {
    NONE("none", -1),
    O_1("O(1)", 1),
    O_LOG_K("O(log K)", 5),
    O_LOG_N("O(log N)", 10),
    O_K("O(K)", 15),
    O_N("O(N)", 20),
    O_K_LOG_N("O(K log N)", 21),
    O_N_LOG_K("O(N log K)", 25),
    O_N_LOG_N("O(N log N)", 30),
    O_N_K("O(N * K)", 35),
    O_K_N_LOG_N("O(KN log N)", 36),
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

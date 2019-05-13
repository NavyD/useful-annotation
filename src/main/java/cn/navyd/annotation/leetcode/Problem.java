package cn.navyd.annotation.leetcode;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表示这是一个算法问题定义class
 * <p>规则
 * <ol>
 * <li>仅能被定义在interface
 * </ol>
 * @see Solution
 * @author navyd
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Problem {
  /**
   * @see #title()
   * @return
   */
  @Deprecated
  String value() default "";
  
  /**
   * 问题的标题，默认为class的名称
   * @return
   */
  String title() default "";
  
  /**
   * 问题的链接url
   * @return
   */
  String url();
  
  /**
   * 标签。匹配leetcode的tag
   * @return
   */
  Tag[] tags();
  
  /**
   * 问题的编号。
   * @return
   */
  short number();
  
  /**
   * 问题的难度
   * @return
   */
  Difficulty difficulty();
  
  /**
   * 该问题解决的次数，即几刷，默认为1刷
   * @return
   */
  byte resolvedTimes() default 1;
  
  /**
   * 表示problem和solution关联的标签。
   * <p>该enum定义了标准的leetcode标签和扩展的tag
   * @author navyd
   *
   */
  public static enum Tag {
    NONE(null),
    SORT(null),
    SORT_BUCKET(SORT),
    HEAP(null),
    ;
    
    private final Tag parent;
    
    Tag(Tag parent) {
      this.parent = parent;
    }
    
    public Tag getParent() {
      return parent;
    }
    
    /**
     * 如果是标准的leetcode tag则返回true
     * @return
     */
    public boolean isStandard() {
      return parent == null && this != Tag.NONE;
    }
  }
  
  public static enum Difficulty {
    EASY,
    MEDIUM,
    HARD,
    ;
  }
}

package xyz.vimtool.chapter19.section11;

/**
 * 
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-28
 */
public interface Competitor <T extends Competitor> {

    Outcome compete(T competitor);
}

package xyz.vimtool.chapter6.section1;

/**
 * 整数序列
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/10
 */
public class Range {


    /**
     * 生成顺序数组
     *
     * @param n 数组尺寸
     * @return int[]
     */
    public static int[] range(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        return result;
    }

    /**
     * 生成顺序数组
     *
     * @param start 数组起始值
     * @param end   数组结束值
     * @return int[]
     */
    public static int[] range(int start, int end) {
        int sz = end - start;
        int[] result = new int[sz];
        for(int i = 0; i < sz; i++) {
            result[i] = start + i;
        }
        return result;
    }

    /**
     * 生成顺序数组
     *
     * @param start 数组起始值
     * @param end   数组结束值
     * @param step  数组步调
     * @return int[]
     */
    public static int[] range(int start, int end, int step) {
        int sz = (end - start) / step;
        int[] result = new int[sz];

        for(int i = 0; i < sz; i++) {
            result[i] = start + (i * step);
        }
        return result;
    }
}

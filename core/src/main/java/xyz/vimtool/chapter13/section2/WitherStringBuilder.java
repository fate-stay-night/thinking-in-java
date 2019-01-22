package xyz.vimtool.chapter13.section2;

/**
 * 编译器优化程度比较
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class WitherStringBuilder {

    public String implicit(String[] fields) {
        String result = "";
        for (int i = 0; i < fields.length; i++) {
            result += fields[i];
        }
        return result;
    }

    public String explicit(String[] fields) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            result.append(fields[i]);
        }
        return result.toString();
    }
}

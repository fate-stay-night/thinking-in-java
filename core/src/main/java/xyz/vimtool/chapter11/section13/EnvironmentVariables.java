package xyz.vimtool.chapter11.section13;

import java.util.Map;

/**
 * 操作系统环境变量
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-15
 */
public class EnvironmentVariables {

    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

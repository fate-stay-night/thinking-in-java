package xyz.vimtool.chapter19.section10;

import java.text.DateFormat;
import java.util.Date;

/**
 * enum实现常量相关的方法
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-27
 */
public enum ConstantSpecificMethod {

    DATE_TIME {
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },

    PATH {
        String getInfo() {
            return System.getenv("PATH");
        }
    },

    VERSION {
      String getInfo() {
          return System.getProperty("java.version");
      }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values()) {
            System.out.println(csm.getInfo());
        }
    }
}

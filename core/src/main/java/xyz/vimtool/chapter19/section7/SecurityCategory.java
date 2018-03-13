package xyz.vimtool.chapter19.section7;

import xyz.vimtool.chapter19.section6.Enums;

/**
 * 枚举嵌套
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-26
 */
public enum SecurityCategory {

    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);

    Security[] values;

    SecurityCategory(Class<? extends Security> kind) {
        values = kind.getEnumConstants();
    }

    interface Security {
        enum Stock implements Security {
            SHORT, LONG, MARGIN;
        }

        enum Bond implements Security {
            MUNICIPAL, JUNK;
        }
    }

    public Security randomSelection() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory securityCategory = Enums.random(SecurityCategory.class);
            System.out.println(securityCategory + ": " + securityCategory.randomSelection());
        }
    }
}

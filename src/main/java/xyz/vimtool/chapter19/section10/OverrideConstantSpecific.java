package xyz.vimtool.chapter19.section10;

/**
 * 覆盖常量相关的方法
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-27
 */
public enum OverrideConstantSpecific {

    NUT,
    BOLT,
    WASHER {
        void f() {
            System.out.println("Overridden method");
        }
    };

    void f() {
        System.out.println("default behavior");
    }

    public static void main(String[] args) {
        for (OverrideConstantSpecific ocs : values()) {
            System.out.print(ocs + ": ");
            ocs.f();
        }
    }
}

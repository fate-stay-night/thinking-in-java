package xyz.vimtool.chapter19.section2;

/**
 * 向enum中添加新方法
 * enum可以看做是一个常规类
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-9
 */
public enum OzWitch {

    //instances must be defined first, before methods
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");

    private String description;

    //Constructor must be package or private access
    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch ozWitch : values()) {
            System.out.println(ozWitch + ": " + ozWitch.getDescription());
        }
    }
}

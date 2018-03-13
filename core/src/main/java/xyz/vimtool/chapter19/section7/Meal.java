package xyz.vimtool.chapter19.section7;

/**
 * 随机枚举
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-26
 */
public class Meal {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }

            System.out.println("----------");
        }
    }
}

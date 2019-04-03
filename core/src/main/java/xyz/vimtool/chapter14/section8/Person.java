package xyz.vimtool.chapter14.section8;

/**
 * 对象(单例)
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-03-29
 */
public class Person {

    public final String first;

    public final String last;

    public final String address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person: " + first + " " + last + " " + address;
    }

    public static class NullPerson extends Person implements Null {

        private NullPerson() {
            super("None", "None", "None");
        }

        @Override
        public String toString() {
            return "NullPerson";
        }
    }

    public static final Person NULL = new NullPerson();
}
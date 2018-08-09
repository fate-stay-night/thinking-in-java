package xyz.vimtool.chapter5.section5;

/**
 * finalize()可能的使用方式
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/9
 */
public class TerminationCondition {

    public static void main(String[] args) {
        Book book = new Book(true);
        book.checkIn();

        new Book(true);

        // 强制调用垃圾回收
        System.gc();
    }
}

class Book {
    boolean checkedOut = false;

    Book(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if (checkedOut) {
            System.out.println("Error: checked out");
        }
    }
}
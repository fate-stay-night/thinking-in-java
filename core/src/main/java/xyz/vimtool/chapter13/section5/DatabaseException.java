package xyz.vimtool.chapter13.section5;

/**
 * String.format()
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-22
 */
public class DatabaseException extends Exception {

    public DatabaseException(int transactionId, int queryId, String message) {
        super(String.format("(t%d, q%d) %s", transactionId, queryId, message));
    }

    public static void main(String[] args) {
        try {
            throw new DatabaseException(3, 7, "Write failed");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
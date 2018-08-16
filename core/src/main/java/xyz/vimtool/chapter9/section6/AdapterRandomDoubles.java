package xyz.vimtool.chapter9.section6;

import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * 再次使用适配器模式
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @since   jdk1.8
 * @date    2018/8/16
 */
public class AdapterRandomDoubles extends RandomDoubles implements Readable {

    private int count;

    public AdapterRandomDoubles(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) {
        if (count-- == 0) {
            return -1;
        }

        String result = Double.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new AdapterRandomDoubles(7));
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}

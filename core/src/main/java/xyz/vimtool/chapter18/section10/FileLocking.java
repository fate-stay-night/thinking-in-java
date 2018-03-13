package xyz.vimtool.chapter18.section10;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * 文件加锁
 *
 * @author zhangzheng
 * @version 1.0
 * @date 2018-2-7
 * @since jdk1.8
 */
public class FileLocking {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("temp.tmp")) {
            FileLock fl = fos.getChannel().tryLock();
            if (fl != null) {
                System.out.println("Locked File");
                if (fl.isShared()) {
                    System.out.println("共享锁");
                } else {
                    System.out.println("独占锁");
                }
                System.out.println("Released Lock");
                TimeUnit.MICROSECONDS.sleep(100);
                fl.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

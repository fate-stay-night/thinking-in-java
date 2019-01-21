package xyz.vimtool.chapter12.section10;

/**
 * 清理类
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-21
 */
public class Cleanup {

    public static void main(String[] args) {
        try {
            InputFile in = new InputFile("core/src/main/java/xyz/vimtool/chapter12/section10/Cleanup.java");
            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null) {}
            } catch (Exception e) {
                System.out.println("Caught Exception in main");
                e.printStackTrace(System.out);
            } finally {
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println("InputFile construction failed");
        }
    }
}

package xyz.vimtool.chapter18.section7;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 文件读写工具
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2018-11-30
 */
public class TextFile extends ArrayList<String> {

    public static String read(String fileName) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    builder.append(s);
                    builder.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return builder.toString();
    }

    public static void write(String fileName, String text) {
        try (PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile())) {
            out.print(text);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) {
            remove(0);
        }
    }

    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try (PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile())) {
            for (String item : this) {
                out.print(item);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String file = read("core/src/main/java/xyz/vimtool/chapter18/section7/TextFile.java");
        write("test.txt", file);

        TextFile text = new TextFile("test.txt");
        text.write("test2.txt");

        TreeSet<String> words = new TreeSet<>(new TextFile("core/src/main/java/xyz/vimtool/chapter18/section7/TextFile.java", "\\W+"));
        System.out.println(words.headSet("a"));
    }
}

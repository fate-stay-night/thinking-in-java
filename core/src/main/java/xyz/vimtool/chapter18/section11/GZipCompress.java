package xyz.vimtool.chapter18.section11;

import java.io.*;
import java.util.zip.*;

/**
 * gzip,zip压缩文件的读写
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-8
 */
public class GZipCompress {

    public static void main(String[] args) throws Exception {
//        if (args.length == 0) {
//            System.out.println("Usage: \nGZipCompress file\n \tUses GZip compression to compress the file to test.gz");
//            System.exit(1);
//        }
//        gzip(args[0]);
//        zip(args[0]);
        gzip("test");
        zip("test");
    }

    public static void gzip(String filename) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
        System.out.println("Writing file");
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
        in.close();
        out.close();

        System.out.println("Reading file");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
        String s;
        while ((s = in2.readLine()) != null) {
            System.out.println(s);
        }
        in2.close();
    }

    public static void zip(String filename) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(filename));

        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream("test.zip"));
        //添加压缩实体
        zipOut.putNextEntry(new ZipEntry(filename));
        BufferedOutputStream out = new BufferedOutputStream(zipOut);
        System.out.println("Writing file");
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
        in.close();
        out.close();

        System.out.println("Reading file");
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream("test.zip"));
        //获取压缩实体
        zipIn.getNextEntry();
        BufferedReader in2 = new BufferedReader(new InputStreamReader(zipIn));
        String s;
        while ((s = in2.readLine()) != null) {
            System.out.println(s);
        }
        in2.close();
    }
}

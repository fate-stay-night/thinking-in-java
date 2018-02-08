package xyz.vimtool.chapter18.section11;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * zip压缩
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-8
 */
public class ZipCompress {

    public static void main(String[] args) throws Exception {
        FileOutputStream f = new FileOutputStream("test.zip");
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        zos.setComment("A test of java zipping");
        BufferedReader in = new BufferedReader(new FileReader("test"));
        zos.putNextEntry(new ZipEntry("test"));
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
        in.close();
        out.close();

        FileInputStream fi = new FileInputStream("test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);
        ZipEntry ze;
        while ((ze = in2.getNextEntry()) != null) {
            int x;
            while ((x = bis.read()) != -1) {
                System.out.println(x);
            }
        }
        bis.close();


        ZipFile zf = new ZipFile("test.zip");
        Enumeration e = zf.entries();
        while (e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry) e.nextElement();
            System.out.println("Extracting: " + ze2);
            BufferedInputStream bi = new BufferedInputStream(zf.getInputStream(ze2));
            int count;
            while ((count = bi.read()) != -1) {
                System.out.println(count);
            }
            bi.close();
        }
        zf.close();
    }
}

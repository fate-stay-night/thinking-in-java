package xyz.vimtool.chapter18.section1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 目录类
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-7
 */
public final class Directory {
    public static  File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<>();

        public List<File> dirs = new ArrayList<>();

        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return "TreeInfo{" +
                    "files=" + files +
                    ", dirs=" + dirs +
                    '}';
        }
    }

    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo treeInfo = new TreeInfo();

        File[] files = startDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    treeInfo.dirs.add(file);
                    treeInfo.addAll(recurseDirs(file, regex));
                } else {
                    if (file.getName().matches(regex)) {
                        treeInfo.files.add(file);
                    }
                }
            }
        }
        return treeInfo;
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println(walk("/home/xiao"));
        } else {
            for (String arg : args) {
                System.out.println(walk(arg));
            }
        }
    }
}

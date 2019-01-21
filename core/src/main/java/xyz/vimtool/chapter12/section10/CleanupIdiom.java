package xyz.vimtool.chapter12.section10;

/**
 * 
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-01-21
 */
public class CleanupIdiom {

    public static void main(String[] args) {
        NeedsCleanup nc1 = new NeedsCleanup();
        try {
            // ...
        } finally {
            nc1.dispose();
        }

        NeedsCleanup nc2 = new NeedsCleanup();
        NeedsCleanup nc3 = new NeedsCleanup();
        try {
            // ...
        } finally {
            nc3.dispose();
            nc2.dispose();
        }

        try {
            NeedsCleanup nc4 = new NeedsCleanup2();
            try {
                NeedsCleanup nc5 = new NeedsCleanup2();
                try {
                    // ...
                } finally {
                    nc5.dispose();
                }
            } catch (ConstructionException e) {
                System.out.println(e);
            } finally {
                nc4.dispose();
            }
        } catch (ConstructionException e) {
            System.out.println(e);
        }
    }
}

class NeedsCleanup {

    private static long counter = 1;

    private final long id = counter++;

    public void dispose() {
        System.out.println("NeedsCleanup " + id + " disposed");
    }
}

class ConstructionException extends Exception {}

class NeedsCleanup2 extends NeedsCleanup {

    public NeedsCleanup2() throws ConstructionException {}
}
package xyz.vimtool.chapter18.section14;

import java.util.prefs.Preferences;

/**
 * 优先序列化
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-8
 */
public class PreferencesDemo {

    public static void main(String[] args) throws Exception {
        Preferences preferences = Preferences.userNodeForPackage(PreferencesDemo.class);
        preferences.put("Location", "Oz");
        preferences.put("Footwear", "Ruby Slipper");
        preferences.putInt("Companions", 4);
        preferences.putBoolean("Are there witches?", true);

        int usageCount = preferences.getInt("UsageCount", 0);
        usageCount++;
        preferences.putInt("UsageCount", usageCount);
        for (String key : preferences.keys()) {
            System.out.println(key + ": " + preferences.get(key, null));
        }

        //must always provide a default value
        System.out.println("How many companions does Dorothy have?" + preferences.getInt("Companions", 0));
    }
}

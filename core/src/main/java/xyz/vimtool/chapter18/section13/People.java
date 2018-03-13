package xyz.vimtool.chapter18.section13;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Elements;

import java.util.ArrayList;

/**
 * xml反序列化
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-8
 */
public class People extends ArrayList<Person> {

    public People(String fileName) throws Exception {
        Document document = new Builder().build(fileName);

        Elements elements = document.getRootElement().getChildElements();
        for (int i = 0; i < elements.size(); i++) {
            add(new Person(elements.get(i)));
        }
    }

    public static void main(String[] args) throws Exception {
        People people = new People("People.xml");
        System.out.println(people);
    }
}

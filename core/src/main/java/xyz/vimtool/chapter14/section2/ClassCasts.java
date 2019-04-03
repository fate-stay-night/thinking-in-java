package xyz.vimtool.chapter14.section2;

/**
 * 类型转换新语法
 *
 * @author  zhangzheng
 * @version 1.0.0
 * @date    2019-03-29
 */
public class ClassCasts {

    public static void main(String[] args) {
        Building building = new House();
        Class<House> houseClass = House.class;

        House house = houseClass.cast(building);
        House house2 = (House) building;
    }
}

class Building {}

class House extends Building {}
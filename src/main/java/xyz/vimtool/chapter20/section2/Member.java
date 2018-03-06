package xyz.vimtool.chapter20.section2;

/**
 * 简单Bean定义，对应数据库表
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-3-5
 */

@DBTable(name = "MEMBER") //对应数据库表名
public class Member {

    @SQLString(30)
    String firstName;

    @SQLString(50)
    String lastName;

    @SQLInteger
    Integer age;

    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;

    static int memberCount;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    @Override
    public String toString() {
        return handle;
    }
}

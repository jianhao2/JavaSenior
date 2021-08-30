package com.cafuc.exer1;

/**

 *
 * @author jh
 * @create 2021-08-25 17:03
 */
public class UserDaoTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1001",new User(1001,34,"jay"));
        dao.save("1001",new User(1002,50,"zxy"));
        dao.save("1001",new User(1003,40,"wlh"));
    }


}

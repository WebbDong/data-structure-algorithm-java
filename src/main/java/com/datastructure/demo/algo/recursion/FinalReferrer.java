package com.datastructure.demo.algo.recursion;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * 用户 A 推荐用户 B 来注册，用户 B 又推荐了用户 C 来注册。
 * 我们可以说，用户 C 的“最终推荐人”为用户 A，用户 B 的“最终推荐人”也为用户 A，
 * 而用户 A 没有“最终推荐人”。给定一个用户 ID，如何查找这个用户的“最终推荐人”？
 * @Author: Webb Dong
 * @CreateDate: 2019/03/14 15:30
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/03/14 15:30
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class FinalReferrer {

    private final static List<User> USER_LIST = new ArrayList<>();

    static {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Jone");
        user1.setAge(33);
        user1.setEmail("test1@qq.com");
        USER_LIST.add(user1);

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Jack");
        user2.setAge(33);
        user2.setEmail("test2@qq.com");
        user2.setReferrerId(1L);
        USER_LIST.add(user2);

        User user3 = new User();
        user3.setId(3L);
        user3.setName("Tom");
        user3.setAge(33);
        user3.setEmail("test3@qq.com");
        user3.setReferrerId(2L);
        USER_LIST.add(user3);

        User user4 = new User();
        user4.setId(4L);
        user4.setName("Sandy");
        user4.setAge(33);
        user4.setEmail("test4@qq.com");
        user4.setReferrerId(3L);
        USER_LIST.add(user4);

        User user5 = new User();
        user5.setId(5L);
        user5.setName("Billie");
        user5.setAge(33);
        user5.setEmail("test5@qq.com");
        user5.setReferrerId(4L);
        USER_LIST.add(user5);

        User user6 = new User();
        user6.setId(6L);
        user6.setName("Webb");
        user6.setAge(18);
        user6.setEmail("test6@qq.com");
        user6.setReferrerId(5L);
        USER_LIST.add(user6);
    }

    public static void main(String[] args) {
        System.out.println("最终推荐人是:" + findFinalReferrer(1L));
    }

    /**
     * 寻找最终推荐人
     * @return
     */
    private static Long findFinalReferrer(Long id) {
        Long referrerId = selectReferrerId(id);
        if (referrerId == null) {
            return id;
        }
        return findFinalReferrer(referrerId);
    }

    /**
     * 获取推荐人
     * @param id
     * @return
     */
    private static Long selectReferrerId(Long id) {
        for (int i = 0, length = USER_LIST.size(); i < length; i++) {
            User user = USER_LIST.get(i);
            if (user.getId().equals(id)) {
                return user.getReferrerId();
            }
        }
        return null;
    }

    @Data
    private static class User {

        private Long id;

        private String name;

        private Integer age;

        private String email;

        private Long referrerId;

    }

}

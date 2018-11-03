package proxy.jdk.impl;

import proxy.jdk.Person;

/**
 * Created by zoypong on 2018/9/13.
 */
public class Girl implements Person {
    private String name = "Rose";

    @Override
    public void findLove() {
        System.out.println("我的名字是：" + this.name + " 我找对象的要求是：");
        System.out.println("高富帅");
    }
}

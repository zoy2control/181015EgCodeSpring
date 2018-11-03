package proxy.jdk.impl;

import proxy.jdk.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 *     ·代理者需要实现 C·InvocationHandler(代理者)，必须重写 invoke()方法
 * </p>
 * Created by zoypong on 2018/9/13.
 */
public class MeiPo implements InvocationHandler {
    // ·被代理对象的引用。临时保存。这里用到多态
    private Person target;

    public Person getTarget() {
        return target;
    }

    // ·第一步：获取 被代理人的个人资料。对外，返回值是Object
    public Object getInstance(Person target) {
        this.target = target;
        // ·获取 被代理者的类
        Class<? extends Person> clazz = target.getClass();
        System.out.println("被代理对象的class是：" + clazz);

        // ·将真正对象 target给 代理类Proxy进行封装，并返回 Object代理对象
        // ·根据 类，新建 代理对象的实例
        // ·这里用到 C·Proxy·CF·newProxyInstance()
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),this);
    }

    /**
     * ·第二步：封装 代理者方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // ·在 被代理者要求的前后加上 代理者自己的东西
        System.out.println("我是媒婆：需要帮你找个异性");
        System.out.println("开始进行海选");
        System.out.println("-----------------");
        // ·被代理者自己的要求
        this.target.findLove();
        System.out.println("-----------------");
        System.out.println("海选成功，如果满意，开始办理婚事");
        return null;
    }
}

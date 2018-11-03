package proxy.jdk;
import proxy.jdk.impl.Girl;
import proxy.jdk.impl.MeiPo;

/**
 * Created by zoypong on 2018/9/13.
 */
public class TestFindLove {
    public static void main(String[] args) {

        // ·1、没有代理模式
        // ·孤独的女孩自己找对象
        System.out.println("办法1：");
        System.out.println("我自己找对象，没有经过代理");
        new Girl().findLove();
        System.out.println("-----------------------");



        // ·2、媒婆代理
        System.out.println("办法2：");
        MeiPo meiPo = new MeiPo();
        Person obj = (Person) meiPo.getInstance(new Girl());// ·Object强转为 Person
        System.out.println("我是从媒婆那里介绍过来的");
        obj.findLove();// ·区别 obj.findLove()与 this.target.findLove()的不同
        System.out.println("-----------------------");


        // ·3、检验上面 obj是被封装的对象， target才是真正的代理类
        // ·以上 代理对象obj与 .getInstance()里面的 target是不同的类
        // ·target是 真正的被代理对象的类，而 obj是 被代理者target经过封装的
        // ·检验如下：
        System.out.println("区别 真正代理类和 封装类：");
        System.out.println("封装的：   " + obj.getClass());
        System.out.println("真正代理类 target：  " +  meiPo.getTarget().getClass());
    }
}

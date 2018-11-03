package proxy.jdk;


import org.junit.jupiter.api.Test;
import proxy.jdk.impl.Girl;

/**
 * Created by zoypong on 2018/10/15.
 */
class TestFindLoveTest {

    @Test
    public void testNoProxy() {
        // ·1、没有代理模式
        // ·孤独的女孩自己找对象
        System.out.println("办法1：");
        System.out.println("我自己找对象，没有经过代理");
        new Girl().findLove();
        System.out.println("-----------------------");
    }

}
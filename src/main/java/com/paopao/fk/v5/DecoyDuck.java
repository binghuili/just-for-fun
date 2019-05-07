package com.paopao.fk.v5;


import com.paopao.fk.v5.impl.FlyNoWay;
import com.paopao.fk.v5.impl.MuteQuack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: luhailiang
 * @date: 2018/5/14
 * @version: 1.0
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class DecoyDuck extends Duck {

    public DecoyDuck() {
        quackBehavior = new MuteQuack();
        flyBehavior = new FlyNoWay();
    }

    public void display() {
        System.out.println("木头鸭");
    }

}
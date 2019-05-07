package com.paopao.fk.v5;


import com.paopao.fk.v5.impl.FlyNoWay;
import com.paopao.fk.v5.impl.Squeak;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: luhailiang
 * @date: 2018/5/14
 * @version: 1.0
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class RubberDuck extends Duck {

    public RubberDuck() {
        quackBehavior = new Squeak();
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("橡皮鸭");
    }

}
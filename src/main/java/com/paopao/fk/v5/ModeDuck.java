package com.paopao.fk.v5;


import com.paopao.fk.v5.impl.MuteQuack;
import com.paopao.fk.v5.impl.FlyNoWay;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: luhailiang
 * @date: 2018/5/14
 * @version: 1.0
 * To change this template use File | Settings | File Templates.
 * Description: 模型鸭
 */
public class ModeDuck extends Duck {

    public ModeDuck() {
        quackBehavior = new MuteQuack();
        flyBehavior = new FlyNoWay();
    }

    public void display() {
        System.out.println("模型鸭");
    }

}
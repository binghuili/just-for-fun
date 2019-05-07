package com.paopao.fk.v3.impl;


import com.paopao.fk.v3.Duck;
import com.paopao.fk.v3.Flyable;
import com.paopao.fk.v3.Quackable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: luhailiang
 * @date: 2018/5/14
 * @version: 1.0
 * To change this template use File | Settings | File Templates.
 * Description: 绿头鸭
 */
public class GreenheadDuck extends Duck implements Flyable, Quackable {

    // 绿头鸭
    public void display() {
        System.out.println("绿头鸭");
    }

    public void fly() {
        System.out.println("飞");
    }

    public void quack() {
        System.out.println("呱呱叫");
    }
}
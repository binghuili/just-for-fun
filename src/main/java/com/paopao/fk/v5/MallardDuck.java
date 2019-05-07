package com.paopao.fk.v5;


import com.paopao.fk.v5.impl.FLyWithWings;
import com.paopao.fk.v5.impl.Quack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: luhailiang
 * @date: 2018/5/14
 * @version: 1.0
 * To change this template use File | Settings | File Templates.
 * Description: 绿头鸭
 */
public class MallardDuck extends Duck {

    public MallardDuck () {
        quackBehavior = new Quack();
        flyBehavior = new FLyWithWings();
    }

    // 绿头鸭
    public void display() {
        System.out.println("绿头鸭");
    }
}
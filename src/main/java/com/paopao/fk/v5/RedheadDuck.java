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
 * Description:
 */
public class RedheadDuck extends Duck {


    public RedheadDuck () {
        quackBehavior = new Quack();
        flyBehavior = new FLyWithWings();
    }

    // 绿头鸭
    public void display() {
        System.out.println("红头鸭");
    }
}
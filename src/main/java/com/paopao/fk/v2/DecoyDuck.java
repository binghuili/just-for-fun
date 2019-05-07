package com.paopao.fk.v2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: luhailiang
 * @date: 2018/5/14
 * @version: 1.0
 * To change this template use File | Settings | File Templates.
 * Description: 木头的假鸭，不会飞也不会叫
 */
public class DecoyDuck extends Duck {

    @Override
    public void display() {
        System.out.println("诱饵鸭");
    }

    @Override
    public void quack() {
    }

    @Override
    public void fly() {
    }
}
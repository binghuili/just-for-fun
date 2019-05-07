package com.paopao.fk.v2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: luhailiang
 * @date: 2018/5/14
 * @version: 1.0
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public abstract class Duck {

    // 呱呱叫
    public void quack() {
        System.out.println("呱呱叫");
    }

    // 游泳
    public void swim() {
        System.out.println("游泳");
    }

    public abstract void display();

    // 飞
    public void fly() {
        System.out.println("飞");
    }
}
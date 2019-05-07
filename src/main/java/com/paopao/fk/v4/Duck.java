package com.paopao.fk.v4;

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

    QuackBehavior quackBehavior;

    FlyBehavior flyBehavior;

    // 游泳
    public void swim() {
        System.out.println("游泳");
    }

    public abstract void display();

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }



}
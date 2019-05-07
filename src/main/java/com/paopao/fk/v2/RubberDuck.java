package com.paopao.fk.v2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: luhailiang
 * @date: 2018/5/14
 * @version: 1.0
 * To change this template use File | Settings | File Templates.
 * Description: 橡皮鸭，不会飞但会叫
 */
public class RubberDuck extends Duck {

    @Override
    public void display() {
        System.out.println("橡皮鸭");
    }

    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }

    @Override
    public void fly() {
    }
}
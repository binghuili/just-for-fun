package com.paopao.fk.v3.impl;


import com.paopao.fk.v3.Duck;
import com.paopao.fk.v3.Quackable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: luhailiang
 * @date: 2018/5/14
 * @version: 1.0
 * To change this template use File | Settings | File Templates.
 * Description: 橡皮鸭，不会飞但会叫
 */
public class RubberDuck extends Duck implements Quackable {

    @Override
    public void display() {
        System.out.println("橡皮鸭");
    }

    public void quack() {
        System.out.println("吱吱叫");
    }

}
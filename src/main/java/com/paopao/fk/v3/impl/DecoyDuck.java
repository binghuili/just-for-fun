package com.paopao.fk.v3.impl;


import com.paopao.fk.v3.Duck;

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

}
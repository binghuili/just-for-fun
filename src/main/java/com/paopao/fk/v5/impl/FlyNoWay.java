package com.paopao.fk.v5.impl;


import com.paopao.fk.v5.FlyBehavior;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: luhailiang
 * @date: 2018/5/14
 * @version: 1.0
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class FlyNoWay implements FlyBehavior {

    public void fly() {
        System.out.println("不飞");
    }
}
package com.paopao.fk.v4.impl;


import com.paopao.fk.v4.QuackBehavior;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: luhailiang
 * @date: 2018/5/14
 * @version: 1.0
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MuteQuack implements QuackBehavior {

    public void quack() {
        System.out.println("不叫");
    }
}
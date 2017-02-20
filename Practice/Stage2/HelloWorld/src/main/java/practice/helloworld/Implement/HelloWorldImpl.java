/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.helloworld.Implement;

import practice.helloworld.Interface.SayHello;

/**
 *
 * @author Владимир
 */
public class HelloWorldImpl implements SayHello{
    @Override
    public void greeting(){
        System.out.println("Hello OSGi World!");
    }
}

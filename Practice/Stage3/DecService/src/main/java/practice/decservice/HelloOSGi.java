/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.decservice;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

/**
 *
 * @author Владимир
 */
@Component (name="helloosgi")
@Service
public class HelloOSGi implements SayHello{
    @Override
    public void greeting(){
        System.out.println("Hello OSGi world!");
    }
}

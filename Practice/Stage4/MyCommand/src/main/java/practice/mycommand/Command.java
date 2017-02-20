/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.mycommand;

import org.osgi.framework.BundleContext;

/**
 *
 * @author Владимир
 */
public class Command {
    public BundleContext bundleContext;
    public Command(BundleContext bundleContext){
        this.bundleContext = bundleContext;
    }
    public void hello(String var){
        System.out.println("Hello, " + var +"!");
    }
}

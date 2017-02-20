/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.lentaparser;

import org.osgi.framework.BundleContext;

/**
 *
 * @author Владимир
 */
public class Exec implements iStats {
    private BundleContext bundleContext;
    private Parser parser;
    @Override
    public void  stats(){
        System.out.println("There is no such source!" + "\n" +"Available sources:" + "\n" + "1) https://lenta.ru/rss" + "\n" + "2) https://aif.ru/rss");
    }
    @Override
    public void stats(String address){
        if (address.compareTo("https://lenta.ru/rss") == 0)
            new Lenta().stats();
        else if (address.compareTo("https://aif.ru/rss") == 0)
            new AIF().stats();
        else
            this.stats();
    }
    public Exec(BundleContext context, Parser parser){
        bundleContext = context;
        this.parser = parser;
    }
}

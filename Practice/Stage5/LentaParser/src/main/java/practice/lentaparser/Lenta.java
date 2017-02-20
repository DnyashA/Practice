/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.lentaparser;

/**
 *
 * @author Владимир
 */
public class Lenta implements iStats{
    @Override
    public void stats(){
        new Parser().parse("https://lenta.ru/rss");
    }
    @Override
    public void stats(String address){};
}

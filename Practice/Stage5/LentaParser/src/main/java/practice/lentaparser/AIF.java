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
public class AIF implements iStats{
    @Override
    public void stats(){
        new Parser().parse("http://www.aif.ru/rss/news.php");
    }
    @Override
    public void stats(String address){};
}

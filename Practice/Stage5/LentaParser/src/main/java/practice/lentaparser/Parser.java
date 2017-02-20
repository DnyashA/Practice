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
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.osgi.framework.BundleContext;

import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class Parser {
    private BundleContext bundleContext;
    private static HashMap<String, Integer> map;
    static final String[] PREPOSITION = {"в", "с", "у", "о", "к", "от", "до", "на", "по", "со", "из", "над", "под", "при", "про", "без", "ради", "близ", "перед", "около", "через", "вдоль",
            "после", "кроме", "сквозь", "вроде", "вследствие", "благодаря", "вопреки", "согласно", "навстречу", "и", "из-за", "за", "а", "об"};
    public static void parse(String address){
        String nextCommand = address;

                String command[] = nextCommand.split(" ");
                String urlCommand[] = new String[command.length];
                boolean showDesc = Boolean
                        .parseBoolean(command[command.length - 1]);

                System.arraycopy(command, 0, urlCommand, 0, command.length);


                for (int i = 0; i < urlCommand.length; i++) {
                    try {
                        printRSS(new URL(urlCommand[i]), showDesc);
                        System.out.println("------------------------------------------------------------------");

                    } catch (MalformedURLException e) {
                        if (urlCommand[i].equalsIgnoreCase("true") || urlCommand[i].equalsIgnoreCase("false") ) {

                        }else{
                            System.out.println("The Url " + urlCommand[i]
                                    + " is Not Valid ");
                            System.out.println("------------------------------------------------------------------");
                        }
                    }

                }
    }
    public static void sort(HashMap<String, Integer> map)
    {
        ArrayList list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i));
        }
    }
    public static void printRSS(URL url, boolean showDescription) {

        HttpURLConnection httpConnection = null;
        try {

            httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.connect();

            InputStream inputStream = httpConnection.getInputStream();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(inputStream);
            String[] words;
            map = new HashMap();
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();
            NodeList RSSItems = root.getElementsByTagName("item");


            for (int i = 0; i < RSSItems.getLength(); i++) {

                Element item = (Element) RSSItems.item(i).getChildNodes();

                try {
                    String itemTitle = item.getElementsByTagName("title")
                            .item(0).getTextContent();
                    //System.out.println(itemTitle);
                    words = itemTitle.toLowerCase().split("[ ,;:.!?()\\s]+");
                    for (String word : words){
                        Integer count = map.get(word);
                        if(!Arrays.asList(PREPOSITION).contains(word)) {
                            map.put(word, count == null ? 1 : count + 1);
                        }
                    }
                } catch (NullPointerException e) {
                    System.out.println("Item Title       : No Title");
                    String itemDesc = item.getElementsByTagName("description")
                            .item(0).getTextContent();
                    System.out.println("Item Description : " + itemDesc);
                }
            }

            sort(map);

            httpConnection.disconnect();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ParserConfigurationException ex) {
            System.out.println(ex.getMessage());
        } catch (SAXException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public Parser(BundleContext bundleContext){
        this.bundleContext = bundleContext;
    }
    public Parser(){};

}
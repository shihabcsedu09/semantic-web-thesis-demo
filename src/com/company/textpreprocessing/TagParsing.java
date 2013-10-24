package com.company.textpreprocessing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 10/19/13
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class TagParsing {
    public static ArrayList<String> tagParsing(String url, String tag) {
        List<String> parsedString = new ArrayList<String>();
        try {
            File input= new File(url);
            Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
            //   doc = Jsoup.connect(url).timeout(0).get();
            Elements elem = doc.select(tag);
            // System.out.println("Tag : " + tag + "  Content : " + elem.text());
             parsedString.add(elem.text());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return (ArrayList<String>) parsedString;
    }
}

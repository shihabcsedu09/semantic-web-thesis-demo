package com.company;

import com.company.domain.TagEntity;
import com.company.domain.UniqueKeyWordEntity;
import com.company.domain.WordEntity;
import com.company.textpreprocessing.KeywordGeneration;
import com.company.textpreprocessing.POSTagging;
import com.company.textpreprocessing.StopWordRemoval;
import com.company.textpreprocessing.TagParsing;
import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.ArticleExtractor;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import util.DBConnect;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException, BoilerpipeProcessingException {
       // String url = url = "http://www.thedailystar.net/beta2/news/who-to-head-it-is-main-hurdle/";
        String url = "./webpages/1.html";
        for (WordEntity wordEntity : KeywordGeneration.generateKeywords(url)) {
            System.out.println("Keyword name : " + wordEntity.getKeywordName() + " Keyword Weight : " + wordEntity.getKeywordValue());
        }
    }


}





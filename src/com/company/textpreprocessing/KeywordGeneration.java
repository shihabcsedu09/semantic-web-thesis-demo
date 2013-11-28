package com.company.textpreprocessing;

import com.company.domain.TagEntity;
import com.company.domain.UniqueKeyWordEntity;
import com.company.domain.WordEntity;

import java.io.IOException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 10/22/13
 * Time: 10:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class KeywordGeneration {
    public static ArrayList<WordEntity> generateKeywords(String url) throws IOException {
        List<TagEntity> tags = new ArrayList<TagEntity>();
        tags.add(new TagEntity("title", "15"));
        tags.add(new TagEntity("h6", "9"));
        tags.add(new TagEntity("h5", "8"));
        tags.add(new TagEntity("h4", "7"));
        tags.add(new TagEntity("h3", "6"));
        tags.add(new TagEntity("h2", "5"));
        tags.add(new TagEntity("h1", "4"));
        tags.add(new TagEntity("b", "4"));
        tags.add(new TagEntity("i", "4"));
        tags.add(new TagEntity("p", "3"));
        // String url = "http://www.cs.tut.fi/~jkorpela/www/testel.html";
        ArrayList<UniqueKeyWordEntity> uniqueKeyWordEntityArrayList = new ArrayList<UniqueKeyWordEntity>();
        for (TagEntity tag : tags)
        {
            ArrayList<String> parsedSentences = TagParsing.tagParsing(url, tag.getTagName());
            ArrayList<String> nounKeywordsWithoutStopWords = new ArrayList<String>();
            for (String parsedSenteced : parsedSentences) {
              //  parsedSenteced = parsedSenteced.replaceAll("[­]+", "");
                ArrayList<String> nounKeywordsWithoutStopWordsTemp = new ArrayList<String>(POSTagging.tagPos(StopWordRemoval.removeStopWord(parsedSenteced),tag.getTagName()));
                if (!nounKeywordsWithoutStopWordsTemp.isEmpty()) {
                    nounKeywordsWithoutStopWords.addAll(nounKeywordsWithoutStopWordsTemp);
                }


            }
            Set<String> uniquekeyWords = new HashSet<String>(nounKeywordsWithoutStopWords);
            for (String uniqueKeyWord : uniquekeyWords)
            {
                int wordWeight = Integer.parseInt(tag.getTagWeight()) * Integer.parseInt(String.valueOf(Collections.frequency(nounKeywordsWithoutStopWords, uniqueKeyWord)));
             //   System.out.println("Word : " + uniqueKeyWord + " Frequency of the word : " + Integer.parseInt(String.valueOf(Collections.frequency(nounKeywordsWithoutStopWords, uniqueKeyWord))) + " Tag Weight : " + Integer.parseInt(tag.getTagWeight()) + "  Word Weight: " + wordWeight);
                uniqueKeyWordEntityArrayList.add(new UniqueKeyWordEntity(uniqueKeyWord, tag.getTagName(), tag.getTagWeight(), String.valueOf(Collections.frequency(nounKeywordsWithoutStopWords, uniqueKeyWord)), String.valueOf(wordWeight)));
            }


        }

        ArrayList<WordEntity> wordEntities = new ArrayList<WordEntity>();
        for (int i = 0; i < uniqueKeyWordEntityArrayList.size(); i++)
        {
            int tempWeight = 0;
            int tempFrequency=0;

            String x = uniqueKeyWordEntityArrayList.get(i).getKeywordName();
            for (int j = 0; j < uniqueKeyWordEntityArrayList.size(); j++) {
                String y = uniqueKeyWordEntityArrayList.get(j).getKeywordName();
                if (x.equalsIgnoreCase(y))
                {
                    tempWeight = tempWeight + Integer.parseInt(uniqueKeyWordEntityArrayList.get(j).getKeywordWeight());
                    tempFrequency = tempFrequency + Integer.parseInt(uniqueKeyWordEntityArrayList.get(j).getKeywordFrequency());
                    uniqueKeyWordEntityArrayList.remove(j);
                    uniqueKeyWordEntityArrayList.trimToSize();
                }

            }
            try {
                uniqueKeyWordEntityArrayList.remove(i);
                uniqueKeyWordEntityArrayList.trimToSize();
            } catch (IndexOutOfBoundsException e) {

            }
            wordEntities.add(new WordEntity(x, String.valueOf(tempWeight),String.valueOf(tempFrequency)));


        }


      return wordEntities;
    }
}

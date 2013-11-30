package com.company.matsim;

import com.company.domain.WordEntity;
import edu.stanford.nlp.util.Index;

import java.io.*;
import java.util.*;

import static com.company.textpreprocessing.KeywordGeneration.generateKeywords;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 11/15/13
 * Time: 6:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimilarityValue {


    public static double getSimilarityValue(String firstPage, String secondPage) throws IOException
    {
        double commonWordWeight = 0;
        double weight = 0;
        double similarityValue = 0;

        ArrayList<WordEntity> keywordsFirst = new ArrayList<WordEntity>();
        ArrayList<WordEntity> keywordsSecond = new ArrayList<WordEntity>();
        Set<WordEntity> commonWords = new HashSet<WordEntity>();

        File first = new File("./keywords/" + firstPage + ".txt");
        FileReader frFirst = new FileReader(first.getAbsoluteFile());
        BufferedReader brFirst = new BufferedReader(frFirst);

        File second = new File("./keywords/" + secondPage + ".txt");
        FileReader frSecond = new FileReader(second.getAbsoluteFile());
        BufferedReader brSecond = new BufferedReader(frSecond);

        String line = brFirst.readLine();
        while (line != null) {
            String[] partsFirst = line.split(" ");
            keywordsFirst.add(new WordEntity(partsFirst[0], partsFirst[2], partsFirst[1]));
            line = brFirst.readLine();
        }
        line = null;
        brFirst.close();


        line = brSecond.readLine();
        while (line != null) {
            String[] partsSecond = line.split(" ");
            keywordsSecond.add(new WordEntity(partsSecond[0], partsSecond[2], partsSecond[1]));
            line = brSecond.readLine();
        }
        line = null;
        brSecond.close();

        ArrayList<WordEntity> keywordsFirstFinal = new ArrayList<WordEntity>();
        ArrayList<WordEntity> keywordsSecondFinal = new ArrayList<WordEntity>();

        for (WordEntity wordEntity : keywordsFirst)
        {
            if (Integer.parseInt(wordEntity.getKeywordFrequency()) >= 2 || Integer.parseInt(wordEntity.getKeywordValue()) >= 4) {
                weight = weight + Integer.parseInt(wordEntity.getKeywordValue());
                keywordsFirstFinal.add(new WordEntity(wordEntity.getKeywordName(), wordEntity.getKeywordValue(), wordEntity.getKeywordFrequency()));
               // System.out.println("Keyword name 1 : " + wordEntity.getKeywordName() + " Keyword frequency 1 : " + wordEntity.getKeywordFrequency() + " Keyword Weight : " + wordEntity.getKeywordValue());
            }

        }



        for (WordEntity wordEntity : keywordsSecond)
        {
            if (Integer.parseInt(wordEntity.getKeywordFrequency()) >= 2 || Integer.parseInt(wordEntity.getKeywordValue()) >= 4) {

                weight = weight + Integer.parseInt(wordEntity.getKeywordValue());
                keywordsSecondFinal.add(new WordEntity(wordEntity.getKeywordName(), wordEntity.getKeywordValue(), wordEntity.getKeywordFrequency()));

            }

        }

        for(WordEntity wordEntity:keywordsFirstFinal)
        {
            System.out.println("Keyword name 1 : " + wordEntity.getKeywordName() + " Keyword frequency  : " + wordEntity.getKeywordFrequency() + " Keyword Weight : " + wordEntity.getKeywordValue());
        }


        for(WordEntity wordEntity:keywordsSecondFinal)
        {
            System.out.println("Keyword name 2 : " + wordEntity.getKeywordName() + " Keyword frequency  : " + wordEntity.getKeywordFrequency() + " Keyword Weight : " + wordEntity.getKeywordValue());
        }




        try {
            for (int i = 0; i < keywordsFirstFinal.size(); i++)
            {
                String x = keywordsFirstFinal.get(i).getKeywordName();
                System.out.println("x is : "+x);
                for (int j = 0; j < keywordsSecondFinal.size(); j++) {
                    String y = keywordsSecondFinal.get(j).getKeywordName();
                    System.out.println("y is : "+y);
                    if (x.equalsIgnoreCase(y))
                    {
                  //    System.out.println("matched");
                      commonWords.add(new WordEntity(keywordsFirstFinal.get(i).getKeywordName(), String.valueOf(commonWordWeight), keywordsFirstFinal.get(i).getKeywordFrequency()));
                      commonWordWeight = commonWordWeight+Integer.parseInt(keywordsFirstFinal.get(i).getKeywordValue()) + Integer.parseInt(keywordsSecondFinal.get(j).getKeywordValue());
                       keywordsSecondFinal.remove(j);
                       keywordsSecondFinal.trimToSize();
                    }
               }



            }
        } catch (IndexOutOfBoundsException in) {

        }


        for (WordEntity commonword : commonWords) {
            System.out.println("The Word " + commonword.getKeywordName() + " is common and value is " + commonword.getKeywordValue());
        }


        similarityValue = (commonWordWeight) / weight;

        System.out.println("Common " + commonWordWeight);
        System.out.println("Total " + weight);


        // System.out.println("Total Weight " + weight);
        // System.out.println("Common Word Weight " + commonWordWeight);


        return similarityValue;
    }
}


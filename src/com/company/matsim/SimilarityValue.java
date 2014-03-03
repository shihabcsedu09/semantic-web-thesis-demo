package com.company.matsim;

import com.company.clustering.Clustering;
import com.company.domain.WordEntity;
import com.company.performance_evaluation.CheckingSemanticSimilarity;
import util.ClusteringVariable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 11/15/13
 * Time: 6:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimilarityValue {

    public static double getSimilarityValue(String firstPage, String secondPage) throws IOException {
        double commonWordWeight = 0;
        double weight = 0;
        double similarityValue = 0;
        double similarityValueWithJacard = 0;
        double similarityValueWithCosine = 0;
        int numberOfKeywordsFirst = 0;
        int numberOfKeywordsSecond = 0;
        int numberOfCommonWords = 0;
        double weightFirst = 0;
        double weightSecond = 0;
        double weightCommon = 0;
        double similarityWithCosine = 0.0;
        double similarityWithJacard = 0.0;


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

        for (WordEntity wordEntity : keywordsFirst) {
            if (Integer.parseInt(wordEntity.getKeywordFrequency()) >= ClusteringVariable.frequencyThresold || Integer.parseInt(wordEntity.getKeywordValue()) >= ClusteringVariable.weightThresold) {
                weight = weight + Integer.parseInt(wordEntity.getKeywordValue());
                weightFirst = weightFirst + weight * weight;
                keywordsFirstFinal.add(new WordEntity(wordEntity.getKeywordName(), wordEntity.getKeywordValue(), wordEntity.getKeywordFrequency()));
                numberOfKeywordsFirst++;
                // System.out.println("Keyword name 1 : " + wordEntity.getKeywordName() + " Keyword frequency 1 : " + wordEntity.getKeywordFrequency() + " Keyword Weight : " + wordEntity.getKeywordValue());
            }

        }

        for (WordEntity wordEntity : keywordsSecond) {
            if (Integer.parseInt(wordEntity.getKeywordFrequency()) >= ClusteringVariable.frequencyThresold || Integer.parseInt(wordEntity.getKeywordValue()) >= ClusteringVariable.frequencyThresold) {
                weight = weight + Integer.parseInt(wordEntity.getKeywordValue());
                weightSecond = weightSecond + weight * weight;
                keywordsSecondFinal.add(new WordEntity(wordEntity.getKeywordName(), wordEntity.getKeywordValue(), wordEntity.getKeywordFrequency()));
                numberOfKeywordsSecond++;
            }

        }

        for (WordEntity wordEntity : keywordsFirstFinal) {
            //   System.out.println("Keyword name 1 : " + wordEntity.getKeywordName() + " Keyword frequency  : " + wordEntity.getKeywordFrequency() + " Keyword Weight : " + wordEntity.getKeywordValue());
        }


        for (WordEntity wordEntity : keywordsSecondFinal) {
            //  System.out.println("Keyword name 2 : " + wordEntity.getKeywordName() + " Keyword frequency  : " + wordEntity.getKeywordFrequency() + " Keyword Weight : " + wordEntity.getKeywordValue());
        }


        try {
            for (int i = 0; i < keywordsFirstFinal.size(); i++) {
                String x = keywordsFirstFinal.get(i).getKeywordName();
                //   System.out.println("x is : " + x);
                for (int j = 0; j < keywordsSecondFinal.size(); j++) {
                    String y = keywordsSecondFinal.get(j).getKeywordName();
                    // System.out.println("y is : " + y);
                    if (x.equalsIgnoreCase(y)) {
                        //    System.out.println("matched");
                        commonWords.add(new WordEntity(keywordsFirstFinal.get(i).getKeywordName(), String.valueOf(commonWordWeight), keywordsFirstFinal.get(i).getKeywordFrequency()));
                        commonWordWeight = commonWordWeight + Integer.parseInt(keywordsFirstFinal.get(i).getKeywordValue()) + Integer.parseInt(keywordsSecondFinal.get(j).getKeywordValue());
                        weightCommon = weightCommon + commonWordWeight;
                        keywordsSecondFinal.remove(j);
                        keywordsSecondFinal.trimToSize();
                        numberOfCommonWords++;
                    }
                 /*   else if(CheckingSemanticSimilarity.checkSemantic(x,y)==1)
                    {
                        commonWords.add(new WordEntity(keywordsFirstFinal.get(i).getKeywordName(), String.valueOf(commonWordWeight), keywordsFirstFinal.get(i).getKeywordFrequency()));
                        commonWordWeight = commonWordWeight + Integer.parseInt(keywordsFirstFinal.get(i).getKeywordValue()) + Integer.parseInt(keywordsSecondFinal.get(j).getKeywordValue());
                        keywordsSecondFinal.remove(j);
                        keywordsSecondFinal.trimToSize();
                    }*/
                }


            }
        } catch (IndexOutOfBoundsException in) {

        }


        for (WordEntity commonword : commonWords) {
            //  System.out.println("The Word " + commonword.getKeywordName() + " is common and value is " + commonword.getKeywordValue());
        }


        similarityValue = 1.0 - ((commonWordWeight) / weight);

        if (ClusteringVariable.similarityMeasurement.equals("PROPOSED")) {
            return similarityValue;
        } else if ((ClusteringVariable.similarityMeasurement.equals("JACARD"))) {
          //  System.out.println("First Page " + numberOfKeywordsFirst + " Second Page " + numberOfKeywordsSecond + " Common " + numberOfCommonWords);
            similarityValueWithJacard = ((numberOfCommonWords) / (numberOfKeywordsFirst + numberOfKeywordsSecond));
            return 1 - similarityValueWithJacard;

        } else {
            similarityValueWithCosine = ((weightCommon) / (Math.sqrt(weightFirst) * Math.sqrt(weightSecond)));
         //   System.out.println("First Page " + weightFirst + " Second Page " + numberOfKeywordsSecond + " Common " + numberOfCommonWords);
            return 1.0 - similarityValueWithCosine;
        }
    }
}


// System.out.println("Common " + commonWordWeight);
//  System.out.println("Total " + weight);


// System.out.println("Total Weight " + weight);
// System.out.println("Common Word Weight " + commonWordWeight);
      /*  System.out.println("Similarity between "+ firstPage+" "+secondPage);
        System.out.println("Value of similarity before  "+ similarityValue);
        similarityValue=Math.abs(similarityValue-1.0);
        System.out.println("Value of similarity " + similarityValue);*/

 /*       Random r=new Random();
        double randomValue= 0.0 + (1.0 - 0.0) * r.nextDouble();*/
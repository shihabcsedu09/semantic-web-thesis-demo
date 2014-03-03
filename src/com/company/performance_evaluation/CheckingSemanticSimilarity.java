package com.company.performance_evaluation;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Shihab on 2/28/14.
 */
public class CheckingSemanticSimilarity
{
    public static int checkSemantic(String firstWord,String secondWord) throws IOException {
        if(GettingSynonyms.getSynonyms(firstWord)==null || GettingSynonyms.getSynonyms(secondWord)==null) return 0;
        ArrayList<String> synonymsOfFirstWord=GettingSynonyms.getSynonyms(firstWord);
        ArrayList<String> synonymsOfSecondWord=GettingSynonyms.getSynonyms(secondWord);
        int flag=0;
        for(String firstWords:synonymsOfFirstWord)
        {
            for(String secondWords:synonymsOfSecondWord)
            {
                if(firstWords.equalsIgnoreCase(secondWords))
                {
                    System.out.println("Matched "+firstWords+" : "+secondWords );
                    flag=1;
                    break;
                }
                if(flag==1) break;
            }
        }
        return flag;
    }
}

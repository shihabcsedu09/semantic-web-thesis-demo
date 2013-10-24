package com.company.textpreprocessing;

import java.io.IOException;
import org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 * User: Shihab Rahman
 * Date: 10/12/13
 * Time: 7:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class StopWordRemoval
{
    public static String removeStopWord(String inputText) throws IOException {


        FileInputStream stopWordsFile = new FileInputStream(new File("./stopwords/stopwords.txt"));
        List<String> stopWordList = IOUtils.readLines(stopWordsFile);
      //  FileInputStream inputFile = new FileInputStream(new File("./webpages/input.txt"));
      //  String input = IOUtils.toString(inputFile, "UTF-8").toLowerCase().replaceAll("[^A-Za-z]", " ").replaceAll(" +", " ");
        String input = inputText.toLowerCase().replaceAll("[^A-Za-z]", " ").replaceAll(" +", " ");
        ArrayList<String> inputWords = new ArrayList<String>(Arrays.asList(input.split(" ")));

        for(int i=0;i<stopWordList.size();i++)
        {
            int j=0;
            for (ListIterator<String> iterator = inputWords.listIterator(); iterator.hasNext();)
            {
                String z = iterator.next();
                if (z.equalsIgnoreCase(stopWordList.get(i)))
                {
                    iterator.remove();
                }
                if(z.length()<=2)
                {
                    iterator.remove();
                }
            }
        }

        //System.out.print(inputWords.toString());
        return inputWords.toString();

    }
}

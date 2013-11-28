package com.company;

import com.company.domain.TagEntity;
import com.company.domain.UniqueKeyWordEntity;
import com.company.domain.WordEntity;
import com.company.matsim.KeywordsFileCreation;
import com.company.matsim.SimilarityValue;
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

import java.io.*;
import java.net.URL;
import java.util.*;

import de.hu.wbi.textmining.wordsense.google.*;

import static com.company.textpreprocessing.KeywordGeneration.*;
import static java.util.Collections.*;


public class Main {


    public static void main(String[] args) throws IOException, BoilerpipeProcessingException {

        int newsNumber=34;
        double similarityValue;
        double similarityValueFinal;
        String content = "";
        double similarityMatrix[][]=new double[newsNumber][newsNumber];

      /*  for(int i=1;i<newsNumber;i++)
        {
            KeywordsFileCreation.createFile(String.valueOf(i));
        }*/

        //initialization

        for(int i=0;i<newsNumber;i++)
        {
            for(int j=0;j<newsNumber;j++)
            {
                similarityMatrix[i][j]=2.0;
            }
        }
        //initialization



        File file = new File("value.txt");
        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 1; i < newsNumber; i++)
        {
            for (int j = 1; j < newsNumber; j++)
            {

                if(similarityMatrix[i][j]==2.0)
                {

                    similarityValue = SimilarityValue.getSimilarityValue(String.valueOf(i),String.valueOf(j));

                    if(similarityValue<0.5 && similarityValue!=0.0)
                    {
                        similarityValue =similarityValue+0.3;
                    }
                    content = "Similarity Between Page#" + i + " And Page#" + j + " is : " + similarityValue;
                    similarityMatrix[i][j]=similarityValue;
                    similarityMatrix[j][i]=similarityValue;
                    bw.write(content);
                    bw.newLine();
                    bw.flush();
                }


            }

        }


        for (int i = 1; i < newsNumber; i++)
        {
            for (int j = 1; j < newsNumber; j++)
            {
                bw.write(String.valueOf(similarityMatrix[i][j])+" ");

            }
            bw.newLine();
            bw.flush();

        }
        bw.close();


    }
}





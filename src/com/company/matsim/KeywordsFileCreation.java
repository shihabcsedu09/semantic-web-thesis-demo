package com.company.matsim;

import com.company.domain.WordEntity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.company.textpreprocessing.KeywordGeneration.generateKeywords;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 11/22/13
 * Time: 11:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class KeywordsFileCreation
{
    public static void createFile(String fileName) throws IOException {
        String content="";
        File file = new File("./keywords/"+fileName+".txt");
        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        ArrayList<WordEntity> keywordsFirst = new ArrayList<WordEntity>(generateKeywords("./webpages/" + fileName+".htm"));
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        for (WordEntity wordEntity : keywordsFirst)
        {
            content=wordEntity.getKeywordName()+" "+wordEntity.getKeywordFrequency()+" "+wordEntity.getKeywordValue();
            bw.write(content);
            bw.newLine();
            bw.flush();
            content=null;
        }
        bw.close();
    }
}

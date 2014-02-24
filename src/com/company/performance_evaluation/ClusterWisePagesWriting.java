package com.company.performance_evaluation;

import com.company.domain.MembershipEntity;
import com.company.textpreprocessing.TagParsing;
import util.ClusteringVariable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Shihab on 2/24/14.
 */
public class ClusterWisePagesWriting
{
    public static int writeClusterWisePages() throws IOException {
        String content="";
        File memberShipMatrixFile = new File("./results/cluster-wise-pages.txt");
        FileWriter fw = new FileWriter(memberShipMatrixFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        for(int i=1;i<= ClusteringVariable.numberOfClusters;i++)
        {
            ArrayList<MembershipEntity> sortedPages = GettingSortedPages.getSortedPages(i);
            content=content.concat("\n\n\n\n*****Cluster Number "+i+"\n\n\n\n");
           /* bw.write(content);
            bw.newLine();
            content = "";*/
            for(int j=1;j<=ClusteringVariable.numberOfPagesPerCluster;j++)
            {
                //System.out.println("Number "+sortedPages.get(j-1).getPageNumber()+" Title "+ TagParsing.tagParsing("./webpages/" + String.valueOf(sortedPages.get(j-1).getPageNumber()+".htm"),"title"));
                content=content.concat("Number "+sortedPages.get(j-1).getPageNumber()+" Title "+ TagParsing.tagParsing("./webpages/" + String.valueOf(sortedPages.get(j-1).getPageNumber()+".htm"),"title")+"  [ "+sortedPages.get(j-1).getMembershipValue()+" ]");
              //  System.out.println(content);
                bw.write(content);
                bw.newLine();
                bw.flush();
                content = "";
            }

        }
        bw.close();
        return 0;

    }
}

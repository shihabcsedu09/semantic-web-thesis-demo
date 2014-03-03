package com.company;

import com.company.clustering.Clustering;
import com.company.clustering.MembershipMatrixInitialization;
import com.company.domain.MembershipEntity;
import com.company.matsim.GettingDistanceValue;
import com.company.matsim.KeywordsFileCreation;
import com.company.matsim.MeasuringSimilarity;
import com.company.matsim.SimilarityValue;
import com.company.performance_evaluation.GettingSortedPages;
import com.company.performance_evaluation.GettingSynonyms;
import com.company.textpreprocessing.TagParsing;
import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.data.ILoadPolicy;
import edu.mit.jwi.item.*;
import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;
import edu.stanford.nlp.optimization.QNMinimizer;
import util.ClusteringVariable;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        // System.out.println("DBI Value using random initial data");
       /* MeasuringSimilarity.measureSimilarity();


        ClusteringVariable.similarityMeasurement="PROPOSED";
        ClusteringVariable.dataFrom="RANDOM";
        System.out.println("DBI Value using random initial data PROPOSED "+  Clustering.clusterValues("RANDOM"));
        ClusteringVariable.dataFrom="DATA";
        System.out.println("DBI Value intial clusters choosen from random PROPOSED "+  Clustering.clusterValues("DATA"));*/

        String content = "";
        File memberShipMatrixFile = new File("./results/random.txt");
        FileWriter fw = new FileWriter(memberShipMatrixFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        double[] a = new double[10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Random r = new Random();
                double randomValue = 0.00 + (0.99 - 0.00) * r.nextDouble();
                a[j] = randomValue;
                //System.out.println("Number "+sortedPages.get(j-1).getPageNumber()+" Title "+ TagParsing.tagParsing("./webpages/" + String.valueOf(sortedPages.get(j-1).getPageNumber()+".htm"),"title"));

            }
            Arrays.sort(a);

            for (int k = 9; k >= 0; k--) {

                content = content.concat(String.valueOf(a[k]));
                //  System.out.println(content);
                bw.write(content);
                bw.newLine();
                bw.flush();
                content = "";
            }
            a= new double[10];
            bw.newLine();
            bw.newLine();


        }

        bw.close();













       /* ClusteringVariable.similarityMeasurement="JACARD";
        MeasuringSimilarity.measureSimilarity();
        ClusteringVariable.dataFrom="RANDOM";
        System.out.println("DBI Value using random initial data JACARD "+  Clustering.clusterValues("RANDOM"));
        ClusteringVariable.dataFrom="DATA";
        System.out.println("DBI Value intial clusters choosen from random JACARD "+  Clustering.clusterValues("DATA"));


        ClusteringVariable.similarityMeasurement="COSINE";
        MeasuringSimilarity.measureSimilarity();
        ClusteringVariable.dataFrom="RANDOM";
        System.out.println("DBI Value using random initial data COSINE "+  Clustering.clusterValues("RANDOM"));
        ClusteringVariable.dataFrom="DATA";
        System.out.println("DBI Value intial clusters choosen from random COSINE "+  Clustering.clusterValues("DATA"));*/


        //  System.out.print(UpdatingMembershipMatrix.getDistanceBetweenCentroidAndData(3.6,2));


    }

}
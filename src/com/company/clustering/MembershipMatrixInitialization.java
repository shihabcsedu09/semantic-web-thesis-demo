package com.company.clustering;

import com.company.domain.ClusterCentreEntity;
import com.company.matsim.SimilarityValue;
import util.ClusteringVariable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 11/29/13
 * Time: 8:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class MembershipMatrixInitialization {
    public static void initializeMembershipMatix() throws IOException {
        Random r = new Random();
        double rangeMin = 0;
        double rangeMax = 1.0;
        double randomValue;//
        String content = "";

        File memberShipMatrixFile = new File("./membershipmatrix/membershipmatrix[0][RANDOM].txt");
        FileWriter fw = new FileWriter(memberShipMatrixFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 1; i <= ClusteringVariable.numberOfValues; i++) {
            for (int j = 1; j <= ClusteringVariable.numberOfClusters; j++) {
                randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
                Double randomValueFinal = Math.round(100.0 * randomValue) / 100.0;
                content = content.concat(randomValueFinal + " ");
            }
            bw.write(content);
            bw.newLine();
            bw.flush();
            content = "";
        }
        bw.close();

    }

    public static void initializeMembershipMatixFromData() throws IOException {
        Random r = new Random();
        int rangeMin = 1;
        int rangeMax = ClusteringVariable.numberOfValues;
        int randomValue;//
        String content = "";

        File memberShipMatrixfile = new File("./membershipmatrix/membershipmatrix[0][DATA].txt");
        FileWriter fw = new FileWriter(memberShipMatrixfile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        ArrayList<ClusterCentreEntity> randomClusters = new ArrayList<ClusterCentreEntity>();
        for (int i = 1; i <= ClusteringVariable.numberOfClusters; i++) {
            randomValue = (int) (rangeMin + (Math.random() * (rangeMax - rangeMin)));
            randomClusters.add(i-1, new ClusterCentreEntity(i, randomValue));
      //      System.out.println("Random Value is " + randomValue);
        }
 /*       randomClusters.add(new ClusterCentreEntity(1,1.0));
        randomClusters.add(new ClusterCentreEntity(2,2.0));*/

        // System.out.print(randomClusters);
       // UpdatingMembershipMatrix.updateMembershipMatrix(-1,randomClusters);
        for (int i = 1; i <= ClusteringVariable.numberOfValues; i++) {

            for (int j = 1; j <= ClusteringVariable.numberOfClusters; j++) {
                //  randomValue = rangeMin + (rangeMax - rangeMin) * r.nextInt();
                ClusterCentreEntity cluster = randomClusters.get(j-1);
                //  UpdatingMembershipMatrix.updateMembershipMatrix(0,randomClusters);

                double similarityValue = Math.round(100.0 * SimilarityValue.getSimilarityValue(String.valueOf(i), String.valueOf(cluster.clusterNumher))) / 100.0;
                content = content.concat(similarityValue + " ");
            }
            bw.write(content);
            bw.newLine();
            bw.flush();
            content = "";
        }
        bw.close();

    }


}

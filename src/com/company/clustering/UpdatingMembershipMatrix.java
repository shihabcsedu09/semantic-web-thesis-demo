package com.company.clustering;

import com.company.domain.ClusterCentreEntity;
import com.company.matsim.SimilarityValue;
import util.ClusteringVariable;
import util.PrintingMatrix;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 12/2/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class UpdatingMembershipMatrix {
    public static void updateMembershipMatrix(int iterationNumber, ArrayList<ClusterCentreEntity> clusterCentres) throws IOException {
        double[][] membershipmatrixUpdated = new double[ClusteringVariable.numberOfValues + 1][ClusteringVariable.numberOfClusters + 1];
        double membershipValue = 0.0;
        double denominator = 0.0;
        double distanceBetweenKandX = 0.0;
        double distanceBetweenKandJ = 0.0;

      //  System.out.println("*****Iteraion Number " + iterationNumber);
        for (int x = 1; x <= ClusteringVariable.numberOfValues; x++) {
            for (ClusterCentreEntity clusterCenter : clusterCentres) {
                denominator = 0.0;
                distanceBetweenKandX = 0.0;
                distanceBetweenKandX = getDistanceBetweenCentroidAndData(clusterCenter.clusterCenterValues, x);
               // System.out.println("[Distance Between " + x + " and Cluster Centre " + clusterCenter.getClusterNumher() + " (" + clusterCenter.clusterCenterValues + ") " + distanceBetweenKandX + "]");
                for (ClusterCentreEntity clusterCenterSecond : clusterCentres) {
                    distanceBetweenKandJ = getDistanceBetweenCentroidAndData(clusterCenterSecond.clusterCenterValues, x);
                    denominator = denominator + Math.pow((distanceBetweenKandX / distanceBetweenKandJ), (2 / (ClusteringVariable.m - 1)));
                 //   System.out.println("Distance Between " + x + " and Cluster Centre " + clusterCenterSecond.getClusterNumher() + " (" + clusterCenterSecond.clusterCenterValues + ") " + distanceBetweenKandJ);
                    distanceBetweenKandJ = 0.0;
                }

                //  System.out.println("Membership Value  :  "+membershipValue);
                membershipValue = Math.pow(denominator, -1);
                //  System.out.println("Membership Value denominator  :  " + denominator);
                // System.out.println("Membership Value  :  " + membershipValue);

                membershipmatrixUpdated[x][clusterCenter.getClusterNumher()] = membershipValue;
                membershipValue = 0.0;
            }
        }
        MembershipMatrixWrite.writeMembershipMatrix(ClusteringVariable.dataFrom,iterationNumber+1, membershipmatrixUpdated);



    }
    //  getDistanceBetweenCentroidAndData(0.0, 1);

    public static double getDistanceBetweenCentroidAndData(double centroid, int data) throws IOException, NumberFormatException {
       // System.out.println("Centroid Value " + centroid);
       // System.out.println("Measuring Distance Between  " + data + " and " + String.valueOf(new BigDecimal(Math.floor(centroid)).intValueExact()));
        double similarityValueWithFloor = SimilarityValue.getSimilarityValue(String.valueOf(data), String.valueOf(new BigDecimal(Math.floor(centroid)).intValueExact()));
      //  System.out.println("Distance is " + similarityValueWithFloor);
        double difference = (centroid - Math.floor(centroid)) * 100;
        if (difference == 0.0) {
            difference = difference + 0.1;
        }
        //System.out.println("0 diffrence "+difference);
     //   System.out.println("Measuring Distance Between  " + data + " and " + String.valueOf(new BigDecimal(Math.ceil(centroid)).intValueExact()));
        double similarityValueWithCeiling = SimilarityValue.getSimilarityValue(String.valueOf(data), String.valueOf(new BigDecimal(Math.ceil(centroid)).intValueExact()));
     //   System.out.println("Distance is " + similarityValueWithCeiling);
        double distance = (similarityValueWithFloor + ((similarityValueWithCeiling - similarityValueWithFloor) / 100) * difference);
        return Math.round(100.0 * distance) / 100.0;

    }


}

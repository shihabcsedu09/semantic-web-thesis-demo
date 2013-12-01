package com.company.clustering;

import util.ClusteringVariable;
import util.PrintingMatrix;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 12/1/13
 * Time: 11:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class MeasuringClusterCentroid {
    public static double getClusterCentroid(int iterationNumber, int clusterNumber) {
        double numerator = 0.0;
        double denominator = 0.0;
        double[][] membershipMatrix;

        membershipMatrix = MembershipMatrixRead.getMembershipMatrix(iterationNumber);
      //  PrintingMatrix.printMatrix(membershipMatrix,ClusteringVariable.numberOfValues,ClusteringVariable.numberOfClusters);
        for (int i = 1; i <= ClusteringVariable.numberOfValues; i++)
        {

            numerator = numerator + Math.pow(membershipMatrix[i][clusterNumber] * i, ClusteringVariable.m);
            denominator = denominator + Math.pow(membershipMatrix[i][clusterNumber], ClusteringVariable.m);
         //   System.out.println(" ( "+membershipMatrix[i][clusterNumber]+" * "+i+" )^ "+ ClusteringVariable.m+" = "+numerator+" : "+denominator);
        }

        return numerator/denominator;
    }
}

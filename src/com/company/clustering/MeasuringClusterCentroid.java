package com.company.clustering;

import util.ClusteringVariable;

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
        System.out.println();
        membershipMatrix = MembershipMatrixRead.getMembershipMatrix(iterationNumber);


        for (int i = 1; i <= ClusteringVariable.numberOfValues; i++) {
            numerator = numerator + Math.pow(membershipMatrix[i][clusterNumber], ClusteringVariable.m) * i;
            denominator = denominator + Math.pow(membershipMatrix[i][clusterNumber], ClusteringVariable.m);
            //System.out.println(" ( "+membershipMatrix[i][clusterNumber]+" * "+i+" )^ "+ ClusteringVariable.m+" = "+numerator+" : "+denominator);
        }

        if(Double.isNaN(denominator)||Double.isNaN(numerator)) return 1.0;
        else return numerator / denominator;

    }
}

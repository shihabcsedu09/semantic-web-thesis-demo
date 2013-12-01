package com.company.clustering;


import com.sun.org.glassfish.external.statistics.impl.TimeStatisticImpl;
import util.ClusteringVariable;
import util.PrintingMatrix;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 11/29/13
 * Time: 8:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class MembershipMatrixRead {

    public static double[][] getMembershipMatrix(int iterationNumber) {
        double[][] membershipMatrix = new double[ClusteringVariable.numberOfValues + 1][ClusteringVariable.numberOfClusters + 1];
        try {
            //for file reading
            File file = new File("./membershipmatrix/membershipmatrix[" + iterationNumber + "].txt");
            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);
            //for file reading

            String line = br.readLine();
            for (int i = 1; line != null; i++) {
                String[] partsFirst = line.split(" ");
                for (int j = 1; j <= partsFirst.length; j++) {

                    membershipMatrix[i][j] = Double.valueOf(partsFirst[j - 1]);

                }
                line = br.readLine();
            }
            br.close();
        } catch (Exception ex) {

        }

        //  PrintingMatrix.printMatrix(membershipMatrix,ClusteringVariable.numberOfValues,ClusteringVariable.numberOfClusters);
        return membershipMatrix;

    }


}

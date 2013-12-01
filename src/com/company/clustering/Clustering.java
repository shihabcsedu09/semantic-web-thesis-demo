package com.company.clustering;

import java.io.IOException;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 11/30/13
 * Time: 11:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Clustering {


    public static void clusterValues() throws IOException {
        int numberOfClusters = 2;
        int numberOfValues = 33;
        int m = 2;//level of cluster fuzziness
        double[][] membershipmatrix = new double[numberOfValues+1][numberOfClusters+1];


        for(int i=1;i<=numberOfValues;i++)
        {
            for(int j=1;j<=numberOfClusters;j++)
            {
                membershipmatrix[i][j]=0.0;
            }
        }


        for (int i = 0; i < 3; i++)
        {
            MembershipMatrixWrite.writeMembershipMatrix(33, 2,i,membershipmatrix );
        }



    }
}

package com.company.clustering;

import com.company.domain.ClusterCentreEntity;
import util.ClusteringVariable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 11/30/13
 * Time: 11:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Clustering {


    public static void clusterValues() throws IOException {

        double[][] membershipmatrix = new double[ClusteringVariable.numberOfValues+1][ClusteringVariable.numberOfClusters+1];
        ArrayList<ClusterCentreEntity> initialClusterCentres= new ArrayList<ClusterCentreEntity>(RandomelyChoosingCluster.chooseRandomClusters());

        for(ClusterCentreEntity intialCluster: initialClusterCentres)
        {
            System.out.println("Cluster Centre # "+intialCluster.getClusterNumher()+" Cluster Centre Value : "+intialCluster.getClusterCenterValues());
        }

       /* for(int i=1;i<=numberOfValues;i++)
        {
            for(int j=1;j<=numberOfClusters;j++)
            {
                membershipmatrix[i][j]=0.0;
            }
        }


        for (int i = 0; i < 3; i++)
        {
            MembershipMatrixWrite.writeMembershipMatrix(33, 2,i,membershipmatrix );
        }*/

       // randomValue= rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        //for()





    }
}

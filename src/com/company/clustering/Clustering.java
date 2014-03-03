package com.company.clustering;

import com.company.domain.ClusterCentreEntity;
import com.company.domain.MembershipEntity;
import com.company.performance_evaluation.ClusterWisePagesWriting;
import com.company.performance_evaluation.DBICalculation;
import com.company.performance_evaluation.GettingSortedPages;
import util.ClusteringVariable;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 11/30/13
 * Time: 11:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Clustering {


    public static double clusterValues(String dataFrom) throws IOException {


        double dbi = 0;
        double[][] membershipmatrix = new double[ClusteringVariable.numberOfValues + 1][ClusteringVariable.numberOfClusters + 1];
        if (ClusteringVariable.dataFrom == "DATA") MembershipMatrixInitialization.initializeMembershipMatixFromData();
        else MembershipMatrixInitialization.initializeMembershipMatix();

        ArrayList<ClusterCentreEntity> initialClusterCentres = new ArrayList<ClusterCentreEntity>(ChoosingInitialClusters.chooseInitialClusters(dataFrom));

        UpdatingMembershipMatrix.updateMembershipMatrix(0, initialClusterCentres);

        for (int i = 1; i <= ClusteringVariable.numberOfIteration; i++) {
            ArrayList<ClusterCentreEntity> clusters = new ArrayList<ClusterCentreEntity>();
            for (int j = 1; j <= ClusteringVariable.numberOfClusters; j++) {
              //  System.out.println("New Cluster Centre # " + j + " Cluster Centre Value : " + MeasuringClusterCentroid.getClusterCentroid(i, j));
              //    System.out.println("For iteration " + i + " cluster number " + j);
                clusters.add(new ClusterCentreEntity(j, MeasuringClusterCentroid.getClusterCentroid(i, j)));
            }
          /*  for(int k=0;k<clusters.size();k++)
            {
                System.out.println(clusters.get(k).getClusterCenterValues());
            }*/

            UpdatingMembershipMatrix.updateMembershipMatrix(i, clusters);
            dbi=DBICalculation.calculateDBI(clusters);

        }


        ClusterWisePagesWriting.writeClusterWisePages();

        return dbi;

    }
}

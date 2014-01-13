package com.company.clustering;

import com.company.domain.ClusterCentreEntity;
import util.ClusteringVariable;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 12/1/13
 * Time: 10:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChoosingInitialClusters {
    public static ArrayList<ClusterCentreEntity> chooseInitialClusters(String dataFrom) {

        int randomValue;
        ArrayList<ClusterCentreEntity> clusterCentres = new ArrayList<ClusterCentreEntity>();
        double[][] memberShipMatrix = new double[ClusteringVariable.numberOfValues + 1][ClusteringVariable.numberOfClusters + 1];
        memberShipMatrix = MembershipMatrixRead.getMembershipMatrix(0);

        for (int i = 1; i <= ClusteringVariable.numberOfClusters; i++) {
            clusterCentres.add(new ClusterCentreEntity(i, MeasuringClusterCentroid.getClusterCentroid(0, i)));
            //  System.out.println("Centroid Value for Cluster " + i + " is " + MeasuringClusterCentroid.getClusterCentroid(0, i));
        }

        return clusterCentres;
    }
}

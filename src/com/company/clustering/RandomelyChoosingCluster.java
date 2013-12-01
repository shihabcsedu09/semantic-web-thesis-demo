package com.company.clustering;

import com.company.domain.ClusterCentreEntity;
import util.ClusteringVariable;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 12/1/13
 * Time: 10:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class RandomelyChoosingCluster
{
    public static ArrayList<ClusterCentreEntity> chooseRandomClusters()
    {
        Random r= new Random();
        int randomValue;
        ArrayList<ClusterCentreEntity> clusterCentres = new ArrayList<ClusterCentreEntity>();
        double[][]memberShipMatrix=new double [ClusteringVariable.numberOfValues+1][ClusteringVariable.numberOfClusters+1];
        memberShipMatrix=MembershipMatrixRead.getMembershipMatrix(0);

        for(int i=1;i<= ClusteringVariable.numberOfClusters;i++)
        {
           randomValue= 1 + (ClusteringVariable.numberOfValues - 1) * r.nextInt();
           clusterCentres.add(new ClusterCentreEntity(i,MeasuringClusterCentroid.getClusterCentroid(0,i)));
           System.out.println("Centroid Value for Cluster "+i+" is "+MeasuringClusterCentroid.getClusterCentroid(0,i));
        }

       return clusterCentres;
    }
}

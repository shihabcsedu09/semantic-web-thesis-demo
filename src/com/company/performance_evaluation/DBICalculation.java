package com.company.performance_evaluation;

import com.company.clustering.UpdatingMembershipMatrix;
import com.company.domain.ClusterCentreEntity;
import com.company.matsim.SimilarityValue;
import util.ClusteringVariable;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Shihab on 2/25/14.
 */
public class DBICalculation
{
    public static double calculateDBI(ArrayList<ClusterCentreEntity> clusterCentres) throws IOException {
        double sigmaI;
        double sigmaJ;
        double fraction;
        double values[] = new double[500];
        double total=0;

        for(int i=1;i<= ClusteringVariable.numberOfClusters;i++)
        {
            int k=0;
            sigmaI=getIntraClusterDistance(i,clusterCentres);
            for(int j=1;j<=ClusteringVariable.numberOfClusters;j++)
            {
                if(i==j) continue;
                else
                {
                    sigmaJ=getIntraClusterDistance(j,clusterCentres);
                    double distance = SimilarityValue.getSimilarityValue(String.valueOf(Math.round(clusterCentres.get(i-1).getClusterCenterValues())),String.valueOf(Math.round(clusterCentres.get(j-1).getClusterCenterValues())));
                    if(distance==0.0) distance=distance+0.1;
                    values[k++]=(sigmaI+sigmaJ)/(distance);
                }
                Arrays.sort(values);
                double max = values[values.length-1];
                total=total+max;
                values= new double[500];
            }

        }
        if(ClusteringVariable.similarityMeasurement=="PROPOSED")
        {
        return total/Math.pow(ClusteringVariable.numberOfClusters,2.5);
        }
        else return total/ClusteringVariable.numberOfClusters;
    }

    public static double getIntraClusterDistance(int clusterNumber,ArrayList<ClusterCentreEntity> clusterCentres) throws IOException {
        double distance=0.0;
        for(int i=1;i<=ClusteringVariable.numberOfValues;i++)
        {
            distance=distance+UpdatingMembershipMatrix.getDistanceBetweenCentroidAndData(clusterCentres.get(clusterNumber-1).clusterCenterValues,i);
        }
        return 1/(distance/ClusteringVariable.numberOfValues);
    }
}

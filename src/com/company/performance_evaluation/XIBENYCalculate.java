package com.company.performance_evaluation;

import com.company.clustering.MembershipMatrixRead;
import com.company.clustering.UpdatingMembershipMatrix;
import com.company.domain.ClusterCentreEntity;
import com.company.matsim.SimilarityValue;
import util.ClusteringVariable;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Shihab on 3/4/14.
 */
public class XIBENYCalculate {
    public static double getXIBENI(ArrayList<ClusterCentreEntity> clusterCentres) throws IOException {
        double[][] membershipMatrix = MembershipMatrixRead.getMembershipMatrix(0);
        double sum = 0.0;
        for (int i = 1; i <= ClusteringVariable.numberOfClusters; i++) {
            double clusterCentroid = clusterCentres.get(i - 1).clusterCenterValues;
            for (int j = 1; j <= ClusteringVariable.numberOfValues; j++) {
                sum = sum + Math.pow(membershipMatrix[j][i], 2.0) * Math.pow((UpdatingMembershipMatrix.getDistanceBetweenCentroidAndData(clusterCentroid, j)), 2.0);
            }
        }
        double min = 123333.999;
        for (int i = 1; i <= ClusteringVariable.numberOfClusters; i++) {
            for (int j = 1; j <= ClusteringVariable.numberOfClusters; j++) {
                if (i == j) continue;
                else {
                    double distance = SimilarityValue.getSimilarityValue(String.valueOf(Math.round(clusterCentres.get(i - 1).getClusterCenterValues())), String.valueOf(Math.round(clusterCentres.get(j - 1).getClusterCenterValues())));
                    if (Math.pow(distance, 2) <= min && distance !=0.0) {
                        min = distance;
                    }
                }
            }
        }
     /*   if(min==0) min = sum+10;
        {
         System.out.println("Sum "+sum);
         System.out.println("Distance "+min);
        }
*/

        return 1/(sum/((ClusteringVariable.numberOfValues)*min));
    }
}

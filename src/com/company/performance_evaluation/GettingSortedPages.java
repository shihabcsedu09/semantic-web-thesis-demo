package com.company.performance_evaluation;

import com.company.clustering.MembershipMatrixRead;
import com.company.domain.MembershipEntity;
import util.ClusteringVariable;

import java.lang.reflect.Array;

import java.util.*;

/**
 * Created by Shihab on 2/1/14.
 */
public class GettingSortedPages {
    public static ArrayList<MembershipEntity> getSortedPages(int clusterNumber) {
        double membershipMatrix[][] = MembershipMatrixRead.getMembershipMatrix(5);
        ArrayList<MembershipEntity> sortedPages = new ArrayList<MembershipEntity>();
        for (int i = 1; i <= ClusteringVariable.numberOfValues; i++) {
            sortedPages.add(new MembershipEntity(i, clusterNumber, membershipMatrix[i][clusterNumber]));
        }

        Collections.sort(sortedPages, new Comparator<MembershipEntity>() {
            @Override
            public int compare(MembershipEntity o1, MembershipEntity o2) {
                if (o1.getMembershipValue() > o2.getMembershipValue())
                    return -1;
                else return 1;

            }
        });


       /* for (int i = 0; i < sortedPages.size(); i++) {
            if (sortedPages.get(i).getClusterNumber() == 2) {
                System.out.println("Page Number " + sortedPages.get(i).getPageNumber() + "  Value " + sortedPages.get(i).getMembershipValue());
            }
            System.out.println(sortedPages.size());

        }*/

        return sortedPages;
    }

}

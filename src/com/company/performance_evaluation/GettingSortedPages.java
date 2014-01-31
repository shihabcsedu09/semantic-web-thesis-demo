package com.company.performance_evaluation;

import com.company.clustering.MembershipMatrixRead;
import com.company.domain.MembershipEntity;

import java.util.ArrayList;

/**
 * Created by Shihab on 2/1/14.
 */
public class GettingSortedPages
{
    public static ArrayList<MembershipEntity> getSortedPages()
    {
        double membershipMatrix[][]= MembershipMatrixRead.getMembershipMatrix(5);
        return null;
    }

}

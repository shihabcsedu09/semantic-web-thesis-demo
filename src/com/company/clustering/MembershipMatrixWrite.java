package com.company.clustering;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 11/30/13
 * Time: 11:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class MembershipMatrixWrite
{
    public static void writeMembershipMatrix(int numberOfValues,int numberOfClusters,int iterationNumber,double[][] membershipMatrix) throws IOException {
        String content="";
        File memberShipMatrixFile = new File("./membershipmatrix/membershipmatrix["+iterationNumber+"].txt");
        FileWriter fw = new FileWriter(memberShipMatrixFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        for(int i=1;i<=numberOfValues;i++)
        {
            for(int j=1;j<=numberOfClusters;j++)
            {
                content=content.concat(String.valueOf(membershipMatrix[i][j])+" ");
            }
            bw.write(content);
            bw.newLine();
            bw.flush();
            content="";
        }
        bw.close();
    }
}

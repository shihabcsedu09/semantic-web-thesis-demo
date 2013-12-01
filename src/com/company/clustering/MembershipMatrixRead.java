package com.company.clustering;







import com.sun.org.glassfish.external.statistics.impl.TimeStatisticImpl;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 11/29/13
 * Time: 8:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class MembershipMatrixRead {

    public static double[][] getMembershipMatrix(int numberOfValues,int numberOfClusters,int iterationNumber) {
        double[][] membershipMatrix = new double[numberOfValues+1][numberOfClusters+1];
        try
        {
        //for file reading
        File file = new File("./membershipmatrix/membershipmatrix["+iterationNumber+"].txt");
        FileReader fr = new FileReader(file.getAbsoluteFile());
        BufferedReader br = new BufferedReader(fr);
        //for file reading

        String line = br.readLine();
        for(int i=1;line!=null;i++)
        {
            String[] partsFirst = line.split(" ");
            for(int j=1;j<=partsFirst.length;j++)
            {
               membershipMatrix[i][j]=Double.valueOf(partsFirst[j]);
            }
            line = br.readLine();
        }
        br.close();
        }
        catch (IOException ex)
        {

        }


        return membershipMatrix;

    }


}

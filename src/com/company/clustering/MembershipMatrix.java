package com.company.clustering;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 11/29/13
 * Time: 8:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class MembershipMatrix {

    public static double[][] getMembershipMatrix(int numberOfValues,int numberOfClusters) throws IOException {
        double[][] membershipMatrix = new double[numberOfValues][numberOfClusters];

        //for file reading
        File file = new File("membershipmatrix.txt");
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


        return membershipMatrix;

    }


}

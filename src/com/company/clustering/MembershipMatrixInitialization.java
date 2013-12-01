package com.company.clustering;

import java.io.*;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 11/29/13
 * Time: 8:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class MembershipMatrixInitialization
{
    public static void initializeMembershipMatix(int numberOfValues,int numberOfClusters) throws IOException {
        Random r = new Random();
        double rangeMin=0.0;
        double rangeMax=1.0;
        double randomValue;//
        String content="";

        File memberShipMatrixfile = new File("./membershipmatrix/membershipmatrix[0].txt");
        FileWriter fw = new FileWriter(memberShipMatrixfile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        for(int i=1;i<=numberOfValues;i++)
        {
            for(int j=1;j<=numberOfClusters;j++)
            {
               randomValue= rangeMin + (rangeMax - rangeMin) * r.nextDouble();
               Double randomValueFinal=Math.round(100.0 * randomValue) / 100.0;
               content=content.concat(randomValueFinal+" ");
            }
            bw.write(content);
            bw.newLine();
            bw.flush();
            content="";
        }
        bw.close();

    }
}

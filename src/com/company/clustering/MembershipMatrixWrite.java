package com.company.clustering;

import util.ClusteringVariable;

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
public class MembershipMatrixWrite {
    public static void writeMembershipMatrix(String dataFrom,int iterationNumber, double[][] membershipMatrix) throws IOException {
        String content = "";

        File memberShipMatrixFile = new File("./membershipmatrix/membershipmatrix[" + iterationNumber + "]"+"["+dataFrom+"].txt");
        FileWriter fw = new FileWriter(memberShipMatrixFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 1; i <= ClusteringVariable.numberOfValues; i++) {
            for (int j = 1; j <= ClusteringVariable.numberOfClusters; j++) {
                if (Double.isNaN(membershipMatrix[i][j])) {
                    content = content.concat(String.valueOf(0.1) + " ");
                } else {
                    content = content.concat(String.valueOf(membershipMatrix[i][j]) + " ");
                }

            }
            bw.write(content);
            bw.newLine();
            bw.flush();
            content = "";
        }
        bw.close();
    }
}

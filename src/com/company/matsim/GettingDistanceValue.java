package com.company.matsim;

import util.ClusteringVariable;

import java.io.*;

/**
 * Created by Shihab on 3/1/14.
 */
public class GettingDistanceValue {
    public static double getDistance(int first, int second) {

        double[][] membershipMatrix = new double[ClusteringVariable.numberOfValues+1 ][ClusteringVariable.numberOfValues+1 ];
        try {
            //for file reading
            File file = new File("distance.txt");
            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);
            //for file reading

            String line = br.readLine();
            for (int i = 1; i<=ClusteringVariable.numberOfValues; i++) {
                String[] partsFirst = line.split(" ");
                for (int j = 1; j <= ClusteringVariable.numberOfValues; j++) {
                    membershipMatrix[i][j] = Double.valueOf(partsFirst[j-1]);

                }
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch (NumberFormatException ex) {

        }


        return membershipMatrix[first][second];

    }
}


package com.company.matsim;

import util.ClusteringVariable;
import util.PrintingMatrix;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Shihab on 3/1/14.
 */
public class MeasuringSimilarity
{
    public static void measureSimilarity() throws IOException {
        int newsNumber = ClusteringVariable.numberOfValues;
        double similarityValue;
        double similarityValueFinal;
        String content = "";
        double similarityMatrix[][] = new double[newsNumber+1][newsNumber+1];

   /*     for(int i=1;i<newsNumber;i++)
        {
            KeywordsFileCreation.createFile(String.valueOf(i));
        }
*/
        //initialization

        for (int i = 1; i <= newsNumber; i++) {
            for (int j = 1; j <= newsNumber; j++) {
                similarityMatrix[i][j] = 2.0;
            }
        }



        File file = new File("value.txt");
        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 1; i <= newsNumber; i++) {
            for (int j = 1; j <= newsNumber; j++) {

                if (similarityMatrix[i][j] == 2.0) {

                    similarityValue = SimilarityValue.getSimilarityValue(String.valueOf(i), String.valueOf(j));

                    if (similarityValue < 0.5 && similarityValue != 0.0) {
                        similarityValue = similarityValue + 0.3;
                    }
                    content = "Similarity Between Page#" + i + " And Page#" + j + " is : " + similarityValue;
                    similarityMatrix[i][j] = similarityValue;
                    similarityMatrix[j][i] = similarityValue;
                    bw.write(content);
                    bw.newLine();
                    bw.flush();
                    content="";
                }


            }

        }


        for (int i = 1; i <= newsNumber; i++) {
            for (int j = 1; j <= newsNumber; j++) {
                bw.write(String.valueOf(similarityMatrix[i][j]) + " ");

            }
            bw.newLine();
            bw.flush();

        }
        bw.close();

        PrintingMatrix.printMatrix(similarityMatrix,ClusteringVariable.numberOfValues,ClusteringVariable.numberOfValues);


    }
}

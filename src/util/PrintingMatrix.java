package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 12/2/13
 * Time: 12:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class PrintingMatrix
{
    public static void printMatrix(double[][] matrix,int m,int n) throws IOException {

        String content="";
        File file = new File("distance.txt");
        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
              //  System.out.println("Value of "+matrix[i][j]  );
                content=content.concat(String.valueOf(matrix[i][j])+" ");
            }
            bw.write(content);
            bw.newLine();
            bw.flush();
            content="";
        }
        bw.close();


    }
}

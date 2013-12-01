package util;

/**
 * Created with IntelliJ IDEA.
 * User: Sheab
 * Date: 12/2/13
 * Time: 12:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class PrintingMatrix
{
    public static void printMatrix(double[][] matrix,int m,int n)
    {
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}

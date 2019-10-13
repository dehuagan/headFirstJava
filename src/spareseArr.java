import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by gandehua on 2019/9/28.
 */
public class spareseArr {
    public static void main(String[] args){
        int[][] sarr = new int[11][11];
        sarr[1][2] = 1;
        sarr[2][3] = 2;

        int sum = 0;
        for (int i=0;i<11;i++){
            for (int j=0;j<11;j++){
                if(sarr[i][j] != 0)
                    sum++;
            }
        }

        int[][] newsarr = new int[sum+1][3];
        newsarr[0][0] = 11;
        newsarr[0][1] = 11;
        newsarr[0][2] = sum;

        int count = 1;

        for (int i=0;i<11;i++){
            for (int j=0;j<11;j++){
                if(sarr[i][j] != 0){
                    newsarr[count][0] = i;
                    newsarr[count][1] = j;
                    newsarr[count][2] = sarr[i][j];
                    count++;
                }
            }
        }

        File file = new File("/Users/gandehua/Desktop/sparseArr.txt");
        try{
            FileWriter fw = new FileWriter(file);
            for (int i =0;i<newsarr.length;i++){
                fw.write(newsarr[i][0]+" ");
                fw.write(newsarr[i][1]+" ");
                fw.write(newsarr[i][2]+"");
                fw.write("\n");

            }
            fw.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }


        int[][] sparseArray = new int[newsarr[0][0]][newsarr[0][1]];
        for (int i =0;i<newsarr[0][2];i++){
            sparseArray[newsarr[i+1][0]][newsarr[i+1][1]] = newsarr[i+1][2];

        }

        for (int[] arr:sparseArray){
            for (int item:arr){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }


    }
}

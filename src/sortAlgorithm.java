import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by gandehua on 2019/8/26.
 */
public class sortAlgorithm {


    public static void main(String[] args){
        int [] list = {5,3,2,0,2,3,0,1,4};
        CountingSort bs = new CountingSort(list);
        int [] res = bs.sortTest();
        for (int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }

    }
}


//冒泡排序
class bubbleSort{
    int [] arr;
    bubbleSort(int newlist[]){
        arr = newlist;
    }

    public int[] sortTest(){
        for (int i=1;i<arr.length;i++){
            boolean flag = true;
            for (int j=0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
        return arr;
    }
}


//选择排序
class selectSort{
    int [] arr;
    selectSort(int newlist[]){
        arr = newlist;
    }

    public int[] sortTest(){
        for (int i=0;i<arr.length-1;i++){
            int min = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[min]>arr[j]){
                    min = j;
                }
            }
            if (min != i){
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }

}

//插入排序
class insertSort{
    int [] arr;
    insertSort(int newlist[]){
        arr = newlist;
    }

    public int[] sortTest(){
        for (int i=1;i<arr.length;i++){
            int tmp = arr[i];
            int j = i;
            while (j>0 && tmp<arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            if (j != i){
                arr[j] = tmp;
            }
        }

        return arr;
    }

}


//归并排序
class mergeSort{
    int [] arr;
    mergeSort(int newlist[]){
        arr = newlist;
    }

    public int[] sortTest(int[] sourceArray){
        if (arr.length<2){
            return arr;
        }
        int middle = (int)Math.floor(arr.length/2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr,middle,arr.length);

        return merge(sortTest(left),sortTest(right));
    }

    protected int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int i=0;
        while (left.length>0 && right.length>0){
            if (left[0] <= right[0]){
                result[i++] = left[0];
                left = Arrays.copyOfRange(left,1,left.length);
            }else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right,1,right.length);
            }
        }

        while (left.length>0){
            result[i++] = left[0];
            left = Arrays.copyOfRange(left,1,left.length);
        }


        while (right.length>0){
            result[i++] = right[0];
            right = Arrays.copyOfRange(right,1,right.length);
        }

        return result;
    }

}



//快速排序
class quickSort{
    int [] arr;
    quickSort(int newlist[]){
        arr = newlist;
    }

    public int[] sortTest(){

        return quick(arr,0,arr.length-1);
    }

    private int[] quick(int[] source, int left, int right){
        if(left < right){
            int partitionIndex = partition(source, left, right);
            quick(source,left,partitionIndex-1);
            quick(source, partitionIndex+1,right);
        }
        return source;
    }

    private int partition(int[] source, int left, int right){
        int pivot = left;
        int index = pivot + 1;
        for (int i=index;i<=right;i++){
            if(source[i]<source[pivot]){
                swap(source,index,i);
                index++;
            }

        }
        swap(source,pivot,index-1);
        return index-1;
    }

    private void swap(int[] source, int i, int j){
        int tmp = source[j];
        source[j] = source[i];
        source[i] = tmp;


    }



}


//计数排序
class CountingSort{
    int[] arr;
    CountingSort(int[] newlist){
        arr = newlist;
    }

    public int[] sortTest(){
        int maxValue = getMax(arr);
        return countingSort(arr, maxValue);
    }

    private int[] countingSort(int[] source, int max){
        int bucketLen = max+1;
        int[] bucket = new int[bucketLen];
        for (int value : arr){
            bucket[value]++;
        }

        int index = 0;

        for (int j=0;j<bucketLen;j++){
            while (bucket[j]>0){
                arr[index++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    private int getMax(int[] source){
        int max = source[0];
        for (int i : source){
            if (i > max){
                max = i;
            }
        }
        return max;
    }
}



import java.awt.geom.QuadCurve2D;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by gandehua on 2019/10/11.
 */
public class ArrayQueueDemo {

    public static void main(String[] args){
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s：显示队列");
            System.out.println("e：退出程序");
            System.out.println("a：添加数据");
            System.out.println("g：取出数据");
            System.out.println("h：查看头数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输入一个数:");
                    arrayQueue.addQueue(scanner.nextInt());
                    break;
                case 'g':
                    try {
                        System.out.printf("取出的数据是%d\n",arrayQueue.getQueue());
                    } catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.printf("头数据是%d\n",arrayQueue.headQueue());
                    } catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

        }
    }

}

//数组模拟队列
class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

//    判断队列是否已满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

//    判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

//    添加数据进队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

//    获取数据出队列
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

//    显示队列所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i=0;i<arr.length;i++){
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }


//    显示队列头数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }
}

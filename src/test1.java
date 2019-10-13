/**
 * Created by gandehua on 2019/8/14.
 */
public class test1 extends StaticSuper{
    static int rand;

    static {
        rand = (int) (Math.random() * 6);
        System.out.println("static block" + rand);
    }

    test1(){
        System.out.println("constructor");
    }

    public static void main(String [] args){
        System.out.println("int main");
        test1 st = new test1();
    }


}

class StaticSuper{
    static {
        System.out.println("super static block");
    }
}

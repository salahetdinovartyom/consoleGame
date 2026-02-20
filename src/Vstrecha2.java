import java.util.Scanner;

public class Vstrecha2 {
    public static void main (String[] args){
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        if (a>0 || b>0) {
            System.out.println("положительное число");
        }
        else if (a==0) {
            System.out.println("Вы ввели 0");
        }
        else {
            System.out.println("отрицательное число");
        }
        switch (a){
            case 0:
                System.out.println("Вы ввели 0");
                break;
            case 1,2:
                a+=1;
                break;

        }
        System.out.println(a);
    }


}

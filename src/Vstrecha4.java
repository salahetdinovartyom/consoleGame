import java.util.Scanner;

public class Vstrecha4 {
    public static void main(String[] args) {
//        short a=5;
//        short b=128;
//
//        while (a<9) {
//            System.out.println("Мася");
//            a++;
//            if (b<17) break;
//            b/=2;
//            break;
        Scanner in = new Scanner(System.in);
        double sum=in.nextDouble();
        int mec=in.nextInt();
        while (mec>0) {
            sum=sum+sum*0.15/12;
            mec--;


        }
        System.out.println(sum);
    }
}

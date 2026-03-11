import java.util.Random;
import java.util.Scanner;

public class BigMonster extends Monster{
    private String monster="🧌";
//    BigMonster(int sizeBoard) {
//        super(sizeBoard);
//    } я посчитал его ненужным)))
    public String getMonster() {return monster;}

    public int countMonster(int sizeBoard) {return sizeBoard-1;}

//    @Override
    public static boolean taskMonster(int difficultGame){
        if (difficultGame==1) {return taskMonster();}
        else {
        Random r=new Random();
        int x = r.nextInt(15);
        int y = r.nextInt(10);
        int z = r.nextInt(20);
        int trueAnswer = x * y - z;
        System.out.println("Реши пример: " + x + " * " + y + " - " + z + " = ?");
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        if (trueAnswer == ans) {
            System.out.println("Верно! Ты победил монстра");
            return true;
        }
        System.out.println("Ты проиграл эту битву!");
        return false;
        }
    }
//    public boolean taskMonster() {
//        return super.taskMonster();
//    }
}

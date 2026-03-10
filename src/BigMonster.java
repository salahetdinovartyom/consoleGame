import java.util.Random;
import java.util.Scanner;

public class BigMonster extends Monster{
    private String bigMonster="🧌";
//    BigMonster(int sizeBoard) {
//        super(sizeBoard);
//    } я посчитал его ненужным)))
    public String getImage() {
        return bigMonster;
    }

    @Override
    public boolean taskMonster(/*int difficultGame*/){
        System.out.println("Решите задачу:");
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

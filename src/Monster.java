import java.util.Random;
import java.util.Scanner;

public class Monster {
    private String monster = "👹";

    public int countMonster (int sizeBoard) {return sizeBoard * sizeBoard - sizeBoard - 1;}

    public String getMonster() {return monster;}

    public void setMonster(String monster) {this.monster = monster;}

    public static boolean taskMonster() {
//        if (key == 1) {
            Random r = new Random();
            Scanner sc = new Scanner(System.in);
            int monster1 = r.nextInt(300);
            int monster2 = r.nextInt(300);
            int trueAnswer = monster1 + monster2;
            System.out.print(monster1 + "+" + monster2 + "=");
            int ans = sc.nextInt();
            if (ans == trueAnswer) {
                System.out.println("Правильно! Ты победил монстра!");
                return true;
            } else {
                System.out.println("Неправильно! Правильный ответ = " + trueAnswer);
                return false;
            }

//        } else {
//            return false;
//        }
    }

    public static boolean lastChance(byte step) {
        Random random=new Random();
        Scanner scanner = new Scanner(System.in);
        int monster1 = random.nextInt(300);
        int monster2 = random.nextInt(300);
        int trueAnswer = monster1 + monster2;
        System.out.print("У тебя 0 жизней. Я добрый и даю тебе + попытку пройти дальше. Реши задачу: ");
        System.out.println(monster1 + "+" + monster2 + "= ");
        int ans = scanner.nextInt();
        if (ans == trueAnswer) {
            System.out.println("Правильно!");
            return true;
        } else {
            System.out.println("Неправильно! Правильный ответ = " + trueAnswer);
            System.out.println("Ты проиграл. Сделано ходов: " + step);
            return false;
        }
    }
}

import java.util.Random;
import java.util.Scanner;

public class BigMonster extends Monster{
//        BigMonster(int sizeBoard) {
//        super(sizeBoard);
//    } я посчитал его ненужным))) он всё равно ошибку выдаёт, потому что у меня логика другая у кода

    public String getMonster() {return "🧌";}

    private static boolean isAsk=false;

    public int countMonster(int sizeBoard) {return sizeBoard-1;}

//    @Override это тоже выдаёт ошибку, но уже красную, наверное потому что у меня один просит сложность, а другой нет
    public static boolean taskMonster(int difficultGame){
        Scanner sc = new Scanner(System.in);
        if (difficultGame==1) {return taskMonster();}
        else if (difficultGame==2) {
            Random r=new Random();
            int x = r.nextInt(15);
            int y = r.nextInt(10);
            int z = r.nextInt(20);
            int trueAnswer = x * y - z;
            System.out.println("Реши пример: " + x + " * " + y + " - " + z + " = ?");

            int ans = sc.nextInt();
            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            }
            System.out.println("Неправильно! Правильный ответ = " + trueAnswer);
            return false;
        }
        else {
            if (!isAsk) {
                System.out.println("У морской кошачьей выдры есть толстый слой меха, который помогает ей охотиться возле опасных скал, поскольку выполняет роль ЕЁ.\nНазовите ЕЁ двумя словами, которые начинаются на парные согласные");
                String answer=sc.nextLine().toLowerCase();
                String trueAns="подушка безопасности";
                if (trueAns.equals(answer)) {
                    System.out.println("Верно! Ты победил монстра");
                    isAsk=true;
                    return true;
                } else {
                    System.out.println("Неправильно! Правильный ответ = " + trueAns);
                    isAsk=true; // это нужно чтобы не переспрашивать пользователя, потому что он уже знает ответ
                    return false;
                }
            } else {
                return taskMonster(2);
            }
        }
    }
//    public boolean taskMonster() {
//        return super.taskMonster();
//    }
}

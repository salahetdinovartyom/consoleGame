import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class BigMonster extends Monster{
//        BigMonster(int sizeBoard) {
//        super(sizeBoard);
//    } я посчитал его ненужным))) он всё равно ошибку выдаёт, потому что у меня логика другая у кода

    public String getMonster() {return "🧌";}

//    private static boolean isAsk=false;

    public int countMonster(int sizeBoard) {return sizeBoard-1;}

//    @Override это тоже выдаёт ошибку, но уже красную, наверное потому что у меня один просит сложность, а другой нет
    public static boolean taskMonster(int difficultGame){
        Scanner sc = new Scanner(System.in);
        Random r=new Random();
        if (difficultGame==1) {return taskMonster();}
        else if (difficultGame==2) {
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
            String[] ask = new String[6];
            ask[0]="У морской кошачьей выдры есть толстый слой меха, который помогает ей охотиться возле опасных скал, поскольку выполняет роль ЕЁ.\nНазовите ЕЁ двумя словами, которые начинаются на парные согласные";
            ask[1]="Распространённое среди журналистов правило Беттериджа гласит: если в заголовке есть ОН, то статья рассказывает о чём‑то маловероятном или несуществующем. \nВ тексте этого вопроса ОН тоже есть. Какие два слова мы заменили словом ОН?";
            ask[2]="Красная зона — это регион во Франции, который уже более века признан опасным для жизни. \nВо Франции даже появился специальный департамент, который занимается ЭТИМ, а помогают департаменту фермеры, которые часто совершают находки в полях. \nНазовите ЭТО словом с приставкой.";
            ask[3]="Персонаж одной карикатуры изображён с большим количеством лёгких травм. \nОн держит в руке предмет, от которого безуспешно пытается избавиться. Назовите этот предмет одним словом.";
            ask[4]="Во второй половине 2025 года французские издания писали, что ОН был больше озабочен мерами по управлению толпой, нежели безопасностью. \nНапишите ЕГО название по русски.";
            ask[5]="ИКС — замена. На табличке, установленной у входа в одну поликлинику, ИКС оказался плоским, что сделало саму табличку бесполезной. \nНапишите фамилию человека, в честь которого назван ИКС.";
            int index= r.nextInt(6);
            String[] trueAns=new String[6];
            trueAns[0]="подушка безопасности";
            trueAns[1]="вопросительный знак";
            trueAns[2]="разминирование";
            trueAns[3]="бумеранг";
            trueAns[4]="лувр";
            trueAns[5]="брайль";

//            if (!isAsk) {
                System.out.println(ask[index]);
                String answer=sc.nextLine().toLowerCase();
                if (Objects.equals(trueAns[index], answer)) {
                    System.out.println("Верно! Ты победил монстра");
//                    isAsk=true;
                    return true;
                } else {
                    System.out.println("Неправильно! Правильный ответ: " + trueAns[index]);
//    из-за того, что теперь вопросов не один (а сначала один) от такой идеи пришлось отказаться
//                    isAsk=true; // это нужно чтобы не переспрашивать пользователя, потому что он уже знает ответ
                    return false;
                }
//            } else {
//                return taskMonster(2);
//            }
        }
    }

//    public boolean taskMonster() {
//        return super.taskMonster();
//    }
}

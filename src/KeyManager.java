import java.util.Scanner;

public class KeyManager {
    public static int move() {
        System.out.println("Напиши одну из букв: \nW-вперёд;\nS-назад;\nA-влево;\nD-вправо;");
        Scanner s = new Scanner(System.in);
        String c=s.nextLine().toUpperCase();
        System.out.println(c);
        switch (c) {
            case "W", "Ц" -> {return 1;}
            case "S", "Ы" -> {return 2;}
            case "A", "Ф" -> {return 3;}
            case "D", "В" -> {return 4;}
            default -> {return 52;}
        }
    }
}

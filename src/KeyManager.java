import java.util.Scanner;

public class KeyManager {
    public static int move(int x, int y) {
        System.out.println("Напиши одну из букв: \nW-вперёд;\nS-назад;\nA-влево;\nD-вправо;\n");
        Scanner s = new Scanner(System.in);
        String c=s.nextLine().toUpperCase();
        int newX = 0,newY=0;
        switch (c) {
            case "W", "Ц" -> newX=x+1;
            case "S", "Ы" -> newX=x-1;
            case "A", "Ф" -> newY=y-1;
            case "D", "В" -> newY=y+1;
        }
        if (newX != x) return newX;
        else if (newY!=y) return newY;
        else return -7;
    }

}

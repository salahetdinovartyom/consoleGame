import java.util.Random;

public class Person {
    String person = "🦸🏻";
    int x, y;
    byte personLive = 3;
    void move(byte x,byte y) {
        this.x = x;
        this.y = y;
    }
    public boolean isMoveCorrect(int x, int y) {
        return this.x == x && Math.abs(this.y - y) == 1 || this.y == y && Math.abs(this.x - x) == 1;
    }
    public void minusLive () {
        this.personLive--;
    }
    Person(byte sizeBoard) {
        Random random=new Random();
        y=sizeBoard;
        x=1 + random.nextInt(sizeBoard);
    }
    Person() {
        this(1, 1);
    }

}

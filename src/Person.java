import java.util.Random;

public class Person {

    private String person="\uD83E\uDDB8";
    private int x, y;
    private byte personLive = 3;
    Random random=new Random();

    Person(byte sizeBoard) {
        y=sizeBoard;
        x=1 + random.nextInt(sizeBoard);
    }
    public int getX(){return x;}
    public int getY() {return y;}
    public int getLive() {return personLive;}
    public String getPerson(){return person;}

    public void setPerson(String person) {this.person=person;}

    void move(int x,int y) {
        this.x = x;
        this.y = y;
    }
    public boolean isMoveCorrect(int x, int y) {return this.x == x && Math.abs(this.y - y) == 1 || this.y == y && Math.abs(this.x - x) == 1;}

    public void minusLive () {
        if (personLive<0) personLive=0;
        else personLive--;
    }
    public void plusLive() {personLive++;}

//    Person() {this(1, 1);}
}

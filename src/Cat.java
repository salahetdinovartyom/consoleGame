import java.awt.*;

public class Cat {
//    встреча6
    String name;

    public Cat(String name, Color color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    Color color;

    public Cat(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "color=" + color +
                ", age=" + age +
                '}';
    }
}

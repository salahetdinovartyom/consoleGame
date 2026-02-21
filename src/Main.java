import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte step=0;
        short personX;
        short personY;
        byte personLive=3;
        byte sizeBoard=5;
        Scanner scanner= new Scanner(System.in);
       /*personX=1+sizeBoard/2;
       personY=1+sizeBoard/2;
       step+=1; */
        String person = "🦸🏻";
        String monster = "👹";
        String gamingField= "+ —— + —— + —— +\n"
                + "|    |    |    |\n"
                + "+ —— + —— + —— +\n"
                + "|    | " + monster + " |    |\n"
                + "+ —— + —— + —— +\n"
                + "| " + person + " |    |    |\n"
                + "+ —— + —— + —— +";
        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");
        String answer=scanner.nextLine();
        System.out.println("Ваш ответ:\t" + answer );
//        Scanner in = new Scanner(System.in);
//        double d=in.nextDouble();
//        System.out.println(d);
//        ВСТРЕЧА 3
//        int personX = 1;
//        int personY = 3;
//        System.out.println(personX > 10); //выведет false
//        System.out.println(personY == 3); //выведет true
        switch (answer) {
            case "ДА":
                System.out.println("Начинаем играть!"); /*Начинаем доклад октонавты*/
                System.out.println("Выбери сложность игры (от 1 до 5): ");
                byte difficultGame =scanner.nextByte();
                System.out.println("Выбранная сложность:\t" + difficultGame);
                System.out.println("Кол-во жизней:"+ personLive+ " "+ person);
                System.out.println(gamingField);
                personX=3;
                personY=1;
                System.out.println("Введите куда пойдёт персонаж (ход возможен только по вертикали или горизонтали)");
                System.out.printf("Координаты персонажа - x: "+ personX +", y:" +personY);
                byte x=scanner.nextByte();
                byte y=scanner.nextByte();
                if (x != personX && y!=personY) {
                    System.out.println("Некорректный ход");
                }
//              Math.abs(x - personX);
                if (x!=personX && y != personY) {
                    System.out.println("Некорректный ход");
                }
                else if (Math.abs(x - personX)==1 || Math.abs(y-personY)==1) {
                    personX=x;
                    personY=y;
                    step+=1;
                    System.out.println("Ход корректный. Новые координаты: "+ personX + ", " + personY + "\nХод номер: " + step);
                }
                else {
                    System.out.println("Координаты не изменены");
//                    эта строка чтобы просто ещё раз закоммитить
//                    а почему у меня вообще ничего нет на гите? Сейчас закомичу ещё раз
                }
                break;
            case "НЕТ":
                System.out.println("У меня вообще-то супер пупер мега игра где можно выиграть миллион(((");
                System.out.println("Ну ладно если захочешь потом приходи!");
                break;
            default:
                System.out.println("ДА иль НЕТ дай мне ответ!");
        }

    }
}
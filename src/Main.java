import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Random random = new Random();
        byte step=0;

        byte sizeBoard =5;
        String castle = "🏰";
        byte castleY = 1;
        int castleX=1+random.nextInt(sizeBoard);
        String person = "🦸🏻";
        int personX = 1+random.nextInt(sizeBoard);
        short personY = 5;
        byte personLive=3;
        String monster = "👹";
        int countMonster=sizeBoard*sizeBoard -sizeBoard -1;
       /*personX=1+sizeBoard/2;
       personY=1+sizeBoard/2;
       step+=1; */
        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— + ";
//        String gamingField= "+ —— + —— + —— +\n"
//                + "|    |    |    |\n"
//                + "+ —— + —— + —— +\n"
//                + "|    | " + monster + " |    |\n"
//                + "+ —— + —— + —— +\n"
//                + "| " + person + " |    |    |\n"
//                + "+ —— + —— + —— +";
        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");
        String answer=scanner.nextLine();
//        System.out.println("Ваш ответ:\t" + answer );
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
//                while ((personLive > 0)&& !(castleX == personX && castleY ==personY)) {
//
//                }
                String[][] board = new String[sizeBoard][sizeBoard];
                for (int y = 1; y <= sizeBoard; y++) {
                    for (int x = 1; x <= sizeBoard; x++) {
                        board[y - 1][x - 1] = "  ";
                    }
                }
                for (int i =0;i<=countMonster;i++) {
                    board[random.nextInt(sizeBoard-1)][random.nextInt(sizeBoard)] =monster;
                }
                board[castleY - 1][castleX - 1] = castle;
                board[personY - 1][personX - 1] = person;
                while (true) {
                    System.out.println("Кол-во жизней:" + personLive + " " + person);
//                    System.out.println(gamingField);

                    for (String[] raw : board) {
                        System.out.println(wall);
                        for (String col : raw) {
                            System.out.print(leftBlock + col);
//                          System.out.print(board[raw - 1][ - 1]);
                        }
                        System.out.println(rightBlock);
                    }
                    System.out.println(wall);

                    System.out.println("Введите куда пойдёт персонаж (ход возможен только по вертикали или горизонтали)");
                    System.out.printf("Координаты персонажа - x: " + personX + ", y:" + personY);
                    byte x = scanner.nextByte();
                    byte y = scanner.nextByte();
                    if (x != personX && y != personY) {
                        System.out.println("Некорректный ход");
                    }
//              Math.abs(x - personX);
                    if (x != personX && y != personY) {
                        System.out.println("Некорректный ход");
                    } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {
                        board[personY - 1][personX - 1] = "  ";
                        if (board[y-1][x-1].equals("  ")) {
                            personX = x;
                            personY = y;
                            step += 1;
                            board[personY - 1][personX - 1] = person;
                            System.out.println("Ход корректный. Новые координаты: " + personX + ", " + personY + "\nХод номер: " + step);
                        }
                        else if (board[y-1][x - 1].equals(castle)) {
                            System.out.println("Вы прошли игру");
                            break;
                        } else {
                            System.out.println("Решите задачу");
                        }
                    }

                    else {
                        System.out.println("Координаты не изменены");}
                    if(personLive <=0){
                        System.out.println("Жизни закончились. Вы проиграли. Счёт: \nХаха, ты реально думал что ты на очки играешь? Ты сделал ходов: "+ step);
                        break;
                    }
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
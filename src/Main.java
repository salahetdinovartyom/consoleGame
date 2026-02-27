import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        byte step = 0;


        byte sizeBoard = 5;
        String castle = "🏰";
        byte castleY = 1;
        int castleX = 1 + random.nextInt(sizeBoard);

        String person = "🦸🏻";
        int personX = 1 + random.nextInt(sizeBoard);
        short personY = 5;
        byte personLive = 3;

        String monster = "👹";

        int countMonster = sizeBoard * sizeBoard - sizeBoard - 1;



        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");
        String answer = scanner.nextLine();
//        System.out.println("Ваш ответ:\t" + answer );

        switch (answer) {
            case "ДА":
                System.out.println("Начинаем играть!"); /*Начинаем доклад октонавты*/
                System.out.println("Выбери сложность игры (от 1 до 5): ");
                byte difficultGame = scanner.nextByte();
                System.out.println("Выбранная сложность:\t" + difficultGame);

                String[][] board = new String[sizeBoard][sizeBoard];
                for (int y = 1; y <= sizeBoard; y++) {
                    for (int x = 1; x <= sizeBoard; x++) {
                        board[y - 1][x - 1] = "  ";
                    }
                }
                for (int i = 0; i <= countMonster; i++) {
                    board[random.nextInt(sizeBoard - 1)][random.nextInt(sizeBoard)] = monster;
                }
                board[castleY - 1][castleX - 1] = castle;
                board[personY - 1][personX - 1] = person;

                while (true) {
                    if (personLive < 0) {
                        int monster1 = random.nextInt(300);
                        int monster2 = random.nextInt(300);
                        int trueAnswer = monster1 + monster2;
                        System.out.print("У тебя " + personLive + " жизней. Я добрый и даю тебе + попытку пройти дальше. Реши задачу: ");
                        System.out.println(monster1 + '+' + monster2 + "= ");
                        int ans = scanner.nextInt();
                        if (ans == trueAnswer) {
                            System.out.println("Правильно!");
                            personLive++;
                        } else {
                            System.out.println("Неправильно! Правильный ответ = " + trueAnswer);
                            System.out.println("Ты проиграл. Сделано ходов: " + step);
                            break;
                        }

                    } else if (personLive == 0) {
                        int monster1 = random.nextInt(300);
                        int monster2 = random.nextInt(300);
                        int trueAnswer = monster1 + monster2;
                        System.out.print("У тебя 0 жизней. Я добрый и даю тебе + попытку пройти дальше. Реши задачу: ");
                        System.out.println(monster1 + '+' + monster2 + "= ");
                        int ans = scanner.nextInt();
                        if (ans == trueAnswer) {
                            System.out.println("Правильно!");
                            personLive++;
                        } else {
                            System.out.println("Неправильно! Правильный ответ = " + trueAnswer);
                            personLive--;
                        }
                    }
                    outputBoard(board,personLive);
                    System.out.println("Введите куда пойдёт персонаж (ход возможен только по вертикали или горизонтали)");
                    System.out.printf("Координаты персонажа - x: " + personX + ", y:" + personY);
                    byte x = scanner.nextByte();
                    byte y = scanner.nextByte();

                    if (x != personX && y != personY) {
                        System.out.println("Некорректный ход");
                    }
                    if (x != personX && y != personY) {
                        System.out.println("Некорректный ход");

                    } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {
                        board[personY - 1][personX - 1] = "  ";
                        if (board[y - 1][x - 1].equals("  ")) {
                            personX = x;
                            personY = y;
                            step += 1;
                            board[personY - 1][personX - 1] = person;
                            System.out.println("Ход корректный. Новые координаты: " + personX + ", " + personY + "\nХод номер: " + step);
                        } else if (board[y - 1][x - 1].equals(castle)) {
                            System.out.println("Вы прошли игру");
                            break;
                        } else {

                            System.out.print("Решите задачу: ");
                            if (taskMonster(difficultGame)) {
                                board[personY - 1][personX - 1] = "  ";
                                personX = x;
                                personY = y;
                            } else {
                                personLive--;
                            }
                        }

                    } else {
                        System.out.println("Координаты не изменены");
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

    static boolean taskMonster(byte key) {
        if (key == 1) {
            Random r = new Random();
            Scanner sc = new Scanner(System.in);
            int monster1 = r.nextInt(300);
            int monster2 = r.nextInt(300);
            int trueAnswer = monster1 + monster2;
            System.out.println(monster1 + "+" + monster2 + "= ");
            int ans = sc.nextInt();
            if (ans == trueAnswer) {
                System.out.println("Правильно! Ты победил монстра!");
                return true;
            } else {
                System.out.println("Неправильно! Правильный ответ = " + trueAnswer);
                return false;
            }

        } else {
            return false;
        }


    }
    static void outputBoard(String[][] board, int live) {
        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— + ";

        for (String[] raw : board) {
            System.out.println(wall);
            for (String col : raw) {
                System.out.print(leftBlock + col);
            }
            System.out.println(rightBlock);
        }
        System.out.println(wall);
        System.out.println("Кол-во жизней:" + live + "\n");
    }
}
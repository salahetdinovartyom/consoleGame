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

        Person person = new Person(sizeBoard);

        Monster monster = new Monster();

        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");
        String answer = scanner.nextLine().toUpperCase();
//        System.out.println("Ваш ответ:\t" + answer );

        switch (answer) {
            case "ДА":
                System.out.println("Начинаем играть!"); /*Октонавты*/
                System.out.println("Выбери сложность игры (от 1 до 5): ");
                byte difficultGame = scanner.nextByte();
//                System.out.println("Выбранная сложность:\t" + difficultGame);

                String[][] board = new String[sizeBoard][sizeBoard];
                for (int y = 1; y <= sizeBoard; y++) {
                    for (int x = 1; x <= sizeBoard; x++) {
                        board[y - 1][x - 1] = "  ";
                    }
                }
                for (int i = 0; i <= monster.countMonster(sizeBoard); i++) {
                    board[random.nextInt(sizeBoard - 1)][random.nextInt(sizeBoard)] = monster.getMonster();
                }
                board[castleY - 1][castleX - 1] = castle;
                board[person.getY() - 1][person.getX() - 1] = person.getPerson();

                while (true) {

                    if (person.getLive() == 0) {
                        if (Monster.lastChance(step)) {
                            person.plusLive();
                        } else {
                            break;
                        }
                    }

                    outputBoard(board,person.getLive());
                    System.out.println("Введите куда пойдёт персонаж (ход возможен только по вертикали или горизонтали)");

//                    if (0<KeyManager.move(person.getX(),person.getY()) && KeyManager.move(person.getX(),person.getY()) <= sizeBoard) {
//                        System.out.println("Неуспел доделать");
//                    }
                    System.out.printf("Координаты персонажа - x: " + person.getX() + ", y:" + person.getY() + " ");
                    byte x = scanner.nextByte();
                    byte y = scanner.nextByte();
                    if (person.isMoveCorrect(x, y)) {
                        String next = board[y - 1][x - 1];
                        if (next.equals("  ")) {
                            board[person.getY() - 1][person.getX() - 1] = "  ";
                            person.move(x, y);
                            board[person.getY()-1][person.getX()-1]= person.getPerson();
                            step++;
                            System.out.println("Ход корректный; Новые координаты: " + person.getX() + ", " + person.getY() +
                                    "\nХод номер: " + step);

                        } else if (next.equals(castle)) {
                            System.out.println("Вы прошли игру!");
                            break;

                        } else {
                            System.out.print("Решите задачу: ");
                            if (Monster.taskMonster(difficultGame)) {
                                board[person.getY()-1][person.getX()-1] = "  ";
                                person.move(x,y);

                            } else {
                                person.minusLive();
                            }
                            step++;
                            board[person.getY()-1][person.getX()-1] = person.getPerson();
                        }
                    } else {
                        System.out.println("Некорректный ход");
                    }
                }
                break;

            case "НЕТ":
                System.out.println("У меня вообще-то супер пупер мега игра где можно выиграть миллион(((");
                System.out.println("Ну ладно если захочешь потом приходи!");
                break;

            default:
                System.out.println("ДА иль НЕТ дай мне ответ!");
                person.setPerson("😺");
                monster.setMonster("🐶");
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
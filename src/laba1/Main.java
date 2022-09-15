package laba1;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


/**
 * Класс точки входа
 */
public class Main {
    public static void main(String[] args) {
        Output output = new Output();
        output.startMenu();
    }
}



interface menuEnum {
    int MANUAL_INPUT = 1,
        AUTO_INPUT = 2;

    int OUTPUT_MATRIX = 1,
        SEARCH_BY_KEYWORD = 2,
        REWRITE_THE_MATRIX = 3,
        EXIT = 4;
}

/**
 * Класс, реализующий интерфейс программы
 */
class Output implements menuEnum {

    PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    Scanner inp = new Scanner(System.in);
    int numb = -1;
    Matrix_string matrix = null;

    /**
     * Метод сбора данных для работы программы + реализации начальногого меню
     */
    public void startMenu() {

        do {
            this.out.println("""
                    1. Ввести слова вручную
                    2. Сгенерировать набор слов автоматически
                    """);

            int menuVariant = this.getInt();
            switch (menuVariant) {
                case MANUAL_INPUT -> {
                    out.println("Вводите слова через пробел");
                    this.matrix = new Matrix_string(this.inp.nextLine());
                }
                case AUTO_INPUT -> {
                    while (this.numb == -1) {
                        out.println("Введите количество слов:");
                        this.numb = this.getInt();
                        if (this.numb == -1) {
                            this.out.println("Некорректный ввод, попробуйте снова");
                            inp.nextLine();
                        }
                    }
                    this.matrix = new Matrix_string(this.numb);
                }
                default -> {out.println("Некорректный ввод, попробуйте снова");
                    inp.nextLine();}
            }
        } while (this.matrix == null);

        mainMenu();

    }

    /**
     * Метод, выводящий главное меню и приводящий в действие его варианты
     */
    private void mainMenu() {
        int menuVariant;
        do {
            this.out.println("""
                    1. Вывести матрицу строк
                    2. Поиск по ключевому слову
                    3. Заполнить матрицу заново
                    4. Выйти из программы
                    """);
            menuVariant = this.getInt();
            switch (menuVariant) {
                case OUTPUT_MATRIX -> this.matrix.print();
                case SEARCH_BY_KEYWORD -> {
                    this.out.println("Введите ключевое слово");
                    String word = this.inp.nextLine().split(" ")[0];
                    this.matrix.findFromKey(word).print();
                }
                case REWRITE_THE_MATRIX -> {
                    this.numb = -1;
                    this.matrix = null;
                    this.startMenu();
                }
                case EXIT -> {
                    this.out.println("Программа завершена");
                }
                default -> {out.println("Некорректный ввод, попробуйте снова");
                    inp.nextLine();}
            }

        } while (menuVariant != 4);
    }
    /**
     * Метод получения и проверки значения int из консоли
     */
    private int getInt() {
        int res;
        try {
            res = this.inp.nextInt();
            this.inp.nextLine();
        } catch (Exception e) {
            res = -1;
        }
        return res;
    }
}


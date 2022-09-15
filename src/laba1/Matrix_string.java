package laba1;

import java.util.Random;

public class Matrix_string {

    String[] matrix;

    /**
     * Конструктор класса, генерирующий матрицу слов рандомно
     * @param numb количество слов в строке
     */
    public Matrix_string(int numb) {
        Random rand = new Random();
        this.matrix = new String[numb];
        String rus_sym = "ёйцукенгшщзхъфывапролджэячсмитьбю";
        int numLet = 5;
        for (int i = 0; i < numb; i++){
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < numLet; j++){
                char let = rus_sym.charAt(rand.nextInt(33));
                builder.append(Character.toString(let));
            }
            matrix[i] = builder.toString();
        }
    }

    /**
     * Конструктор класса, создающий матрицу из строки,
     * введенной в консоли
     */
    public Matrix_string(String text){
        this.matrix = text.split(" ");
    }

    /**
     * Конструктор класса, необходимый для удобного
     * выполнения пункта 2 главного меню
     */
    public Matrix_string(String[] wordList) {
        this.matrix = wordList;
    }

    /**
     * Конструктор класса, находящий слова в массиве, содержащие
     * ключевое слово, введенное пользователем
     * @param key ключевое слово
     * @return строку, состоящую из этих слов
     */
    public Matrix_string findFromKey(String key){
        int wordCount = 0;
        for (String word : this.matrix){
            if (word.toLowerCase().contains(key.toLowerCase())) {
                wordCount ++;
            }
        }
        System.out.println(wordCount);
        String[] res = new String[wordCount];
        int addCounter = 0;
        for (String s : this.matrix) {
            if (s.toLowerCase().contains(key.toLowerCase())) {
                res[addCounter] = s;
                addCounter++;
            }
        }
        return new Matrix_string(res);
    }

    /**
     * Метод вывода матрицы на экран
     */
    public void print() {
        var out = System.out;
        for (String elem : this.matrix){
            out.print(elem + " ");
        }
        out.print("\n");
    }

}


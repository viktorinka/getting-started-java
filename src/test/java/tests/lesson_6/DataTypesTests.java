package tests.lesson_6;

public class DataTypesTests {

    public static void main(String[] args) {

        //Целочисленные типы данных
        byte a = 12 + 12; // 8 bit
        System.out.println("Type of byte from -128 to 127. Example byte " + a);

        short b = -32 + 32768; // 16 bit
        System.out.println("Type of short from -32 768 to 32 767. Example short " + b);

        int i = 1234569 + 1234569000; //32 bit
        System.out.println("Type of int from -2 147 483 648 to 2 147 483 647. Example int " + i);

        long d = 922337204 + 922337203; //64 bit
        System.out.println("Type of long from -9 223 372 036 854 775 808 to 9 223 372 036 854 775 807. Example long " + d);

        // Типы данных с плавающей точкой
        double v = i + d;
        System.out.println("int plus long = result double. Example double " + v); // приведение к типу данных, который соответствует наибольшей точности вычислений - double

        float e = 12.8F + 28888.0F;
        System.out.println("Type of float from -9 223 372 036 854 775 808 to 9 223 372 036 854 775 807. Example float " + e);

        double f = 567.6666 + 46.88888;
        System.out.println("Type of double from -9 223 372 036 854 775 808 to 9 223 372 036 854 775 807. Example double " + f);

        boolean yes = 2 < 3;
        boolean no = 2 > 3;
        System.out.println("Type of boolean, true or false. Example 2 < 3 " + yes);
        System.out.println("Type of boolean, true or false. Example 2 > 3 " + no);


        // Операторы
        // 1. Присвоение
        char assignment = 'T';
        System.out.println(assignment);

        int c = 10;
        System.out.println("c = " + c);
        c += 5; // эквивалентно c = c + 5
        System.out.println("Эквивалентно c = c + 5: " + c);
        c -= 5; // эквивалентно c = c - 5
        System.out.println("Эквивалентно c = c - 5: " + c);
        c *= 5; // эквивалентно c = c * 5
        System.out.println("Эквивалентно c = c * 5: " + c);
        c /= 5; // эквивалентно c = c / 5
        System.out.println("Эквивалентно c = c / 5: " + c);
        c %= 5; // эквивалентно c = c % 5
        System.out.println("Эквивалентно c = c % 5: " + c);

        // 2. Математические + - * / %
        int math = 6 / 2;
        System.out.println("Mathematical operator. Example division " + math);

        int remainder = 6 % 5; // остаток от деления
        System.out.println("Остаток от деления: " + remainder);

        // ++	Инкремент - увеличивает значение операнда на 1
        // --	Декремент - уменьшает значение операнда на 1

        // 3. Операторы сравнения
        // > больше,
        // < меньше,
        // >= больше или равно,
        // <= меньше или равно,
        // != не равно,
        // == равно

        // 4.Логические операторы
        //&& логическое "и"
        // || логическое "или"
        // ! логическое отрицание

        // 5.Тернарный оператор
        int min = (a < b) ? a : b; // если a < b, то min = a, иначе min = b
        System.out.println("min = " + min);

        // 6.Оператор instanceof
        // – проверяет, является ли объект определенного типа (типа класса или типа интерфейса) и используется
        // только для переменных ссылочного объекта.

        String name = "Олег";
        // Следующее вернётся верно, поскольку тип String
        boolean result = name instanceof String;
        System.out.println(result);
    }
}


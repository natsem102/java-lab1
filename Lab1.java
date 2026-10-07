import java.util.Arrays;
import java.util.Scanner;

class Lab1 {
    private final Scanner sc = new Scanner(System.in);

    // Методы ввода, с проверкой
    private int readInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                int v = Integer.parseInt(sc.nextLine().trim());
                if (v >= min && v <= max) return v;
                System.out.println("Ошибка: число должно быть от " + min + " до " + max);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число");
            }
        }
    }

    private int readInt(String msg) {
        return readInt(msg, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private long readLong(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Long.parseLong(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число");
            }
        }
    }

    private double readDouble(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число");
            }
        }
    }

    private String readString(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim().toLowerCase();
    }

    private int[] readArray(String msg) {
        while (true) {
            System.out.print(msg + " (числа через пробел): ");
            String[] p = sc.nextLine().trim().split("\\s+");
            try {
                int[] a = new int[p.length];
                for (int i = 0; i < p.length; i++) a[i] = Integer.parseInt(p[i]);
                return a;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: вводите только целые числа");
            }
        }
    }

    // Задание 1
    public double fraction(double x) {
        return x - (long) x;
    }

    public int sumLastNums(int x) {
        return x % 10 + x / 10 % 10;
    }

    public boolean is2Digits(int x) {
        return (x >= 10 && x <= 99) || (x <= -10 && x >= -99);
    }

    public boolean isInRange(int a, int b, int num) {
        return num >= Math.min(a, b) && num <= Math.max(a, b);
    }

    public boolean isEqual(int a, int b, int c) {
        return a == b && b == c;
    }

    // Задание 2
    public double safeDiv(int x, int y) {
        if (y == 0) return 0;
        return (double) x / y;
    }

    public boolean is35(int x) {
        return (x % 3 == 0) != (x % 5 == 0);
    }

    public boolean sum3(int x, int y, int z) {
        return x + y == z || x + z == y || y + z == x;
    }

    public String age(int x) {
        int d = x % 10, t = x % 100;
        if (d == 1 && t != 11) return x + " год";
        if (d >= 2 && d <= 4 && (t < 12 || t > 14)) return x + " года";
        return x + " лет";
    }

    public void printDays(String x) {
        switch (x) {
            case "понедельник": System.out.println("понедельник");
            case "вторник": System.out.println("вторник");
            case "среда": System.out.println("среда");
            case "четверг": System.out.println("четверг");
            case "пятница": System.out.println("пятница");
            case "суббота": System.out.println("суббота");
            case "воскресенье": System.out.println("воскресенье");
                break;
            default: System.out.println("это не день недели");
        }
    }

    // Задание 3
    public String listNums(int x) {
        String s = "";
        for (int i = 0; i <= x; i++) s += i + " ";
        return s.trim();
    }

    public int pow(int x, int y) {
        int res = 1;
        for (int i = 0; i < y; i++) res *= x;
        return res;
    }

    public int numLen(long x) {
        int n = 0;
        do {
            n++;
            x /= 10;
        } while (x != 0);
        return n;
    }

    public void square(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) System.out.print("*");
            System.out.println();
        }
    }

    public void guessGame() {
        int secret = (int) (Math.random() * 10);
        int tries = 1;
        int g = readInt("Введите число от 0 до 9: ", 0, 9);
        while (g != secret) {
            tries++;
            g = readInt("Вы не угадали, введите число от 0 до 9: ", 0, 9);
        }
        int d = tries % 10, t = tries % 100;
        String w = (d == 1 && t != 11) ? "попытку" : (d >= 2 && d <= 4 && (t < 12 || t > 14)) ? "попытки" : "попыток";
        System.out.println("Вы угадали!");
        System.out.println("Вы отгадали число за " + tries + " " + w);
    }

    // Задание 4
    public int maxAbs(int[] arr) {
        int m = arr[0];
        for (int v : arr)
            if (Math.abs(v) > Math.abs(m)) m = v;
        return m;
    }

    public int[] add(int[] arr, int[] ins, int pos) {
        int[] res = new int[arr.length + ins.length];
        for (int i = 0; i < pos; i++) res[i] = arr[i];
        for (int i = 0; i < ins.length; i++) res[pos + i] = ins[i];
        for (int i = pos; i < arr.length; i++) res[ins.length + i] = arr[i];
        return res;
    }

    public void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int t = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = t;
        }
    }

    public int[] concat(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) res[i] = arr1[i];
        for (int i = 0; i < arr2.length; i++) res[arr1.length + i] = arr2[i];
        return res;
    }

    public int[] findAll(int[] arr, int x) {
        int[] res = new int[arr.length];
        int n = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == x) res[n++] = i;
        return Arrays.copyOf(res, n);
    }

    // Запускаем выбранную задачку
    private void run(int c) {
        switch (c) {
            case 1:
                System.out.println("Результат: " + fraction(readDouble("Введите число: ")));
                break;
            case 2:
                System.out.println("Результат: " + sumLastNums(readInt("Введите число (не менее двух знаков): ", 10, Integer.MAX_VALUE)));
                break;
            case 3:
                System.out.println("Результат: " + is2Digits(readInt("Введите число: ")));
                break;
            case 4:
                System.out.println("Результат: " + isInRange(readInt("Введите a: "), readInt("Введите b: "), readInt("Введите num: ")));
                break;
            case 5:
                System.out.println("Результат: " + isEqual(readInt("Введите a: "), readInt("Введите b: "), readInt("Введите c: ")));
                break;
            case 6:
                System.out.println("Результат: " + safeDiv(readInt("Введите x: "), readInt("Введите y: ")));
                break;
            case 7:
                System.out.println("Результат: " + is35(readInt("Введите число: ")));
                break;
            case 8:
                System.out.println("Результат: " + sum3(readInt("Введите x: "), readInt("Введите y: "), readInt("Введите z: ")));
                break;
            case 9:
                System.out.println("Результат: " + age(readInt("Введите возраст (0..1000): ", 0, 1000)));
                break;
            case 10:
                printDays(readString("Введите день недели: "));
                break;
            case 11:
                System.out.println("Результат: " + listNums(readInt("Введите x (0..10000): ", 0, 10000)));
                break;
            case 12:
                System.out.println("Результат: " + pow(readInt("Введите x: "), readInt("Введите степень y (0..30): ", 0, 30)));
                break;
            case 13:
                System.out.println("Результат: " + numLen(readLong("Введите число: ")));
                break;
            case 14:
                square(readInt("Введите размер (1..50): ", 1, 50));
                break;
            case 15:
                guessGame();
                break;
            case 16:
                System.out.println("Результат: " + maxAbs(readArray("Введите массив")));
                break;
            case 17:
                int[] a1 = readArray("Введите массив");
                int[] ins = readArray("Введите вставляемый массив");
                int pos = readInt("Введите позицию (0.." + a1.length + "): ", 0, a1.length);
                System.out.println("Результат: " + Arrays.toString(add(a1, ins, pos)));
                break;
            case 18:
                int[] a2 = readArray("Введите массив");
                reverse(a2);
                System.out.println("Результат: " + Arrays.toString(a2));
                break;
            case 19:
                int[] a3 = readArray("Введите первый массив");
                int[] a4 = readArray("Введите второй массив");
                System.out.println("Результат: " + Arrays.toString(concat(a3, a4)));
                break;
            case 20:
                int[] a5 = readArray("Введите массив");
                System.out.println("Результат: " + Arrays.toString(findAll(a5, readInt("Введите x: "))));
                break;
        }
    }

    // MAIN
    public static void main(String[] args) {
        Lab1 l = new Lab1();
        String[] menu = {
            "1.1 Дробная часть", "1.2 Сумма знаков", "1.5 Двузначное", "1.7 Диапазон", "1.9 Равенство",
            "2.2 Безопасное деление", "2.3 Тридцать пять", "2.6 Тройная сумма", "2.8 Возраст", "2.10 Вывод дней недели",
            "3.1 Числа подряд", "3.4 Степень числа", "3.5 Длина числа", "3.7 Квадрат", "3.10 Угадайка",
            "4.3 Поиск максимального", "4.5 Добавление массива в массив", "4.6 Реверс", "4.8 Объединение", "4.9 Все вхождения"
        };
        while (true) {
            System.out.println("\nЛабораторная работа №1 - 9 вариант)");
            for (int i = 0; i < menu.length; i++) System.out.println((i + 1) + ". " + menu[i]);
            System.out.println("0. Выход");
            int c = l.readInt("Выберите пункт меню: ", 0, menu.length);
            if (c == 0) {
                System.out.println("До свидания!");
                return;
            }
            System.out.println("- " + menu[c - 1] + " -");
            l.run(c);
        }
    }
}

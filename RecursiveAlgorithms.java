import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Рекурсивные алгоритмы — решения задач 1–40.
 * Каждая задача — отдельный статический метод; в main() показан пример работы каждого.
 */
public class RecursiveAlgorithms {

    // ===================== 1–11. Числа =====================

    // 1. Вывод чисел от 1 до N
    static void printAscending(int n) {
        if (n < 1) return;
        printAscending(n - 1);
        System.out.print(n + " ");
    }

    // 2. Вывод чисел от N до 1
    static void printDescending(int n) {
        if (n < 1) return;
        System.out.print(n + " ");
        printDescending(n - 1);
    }

    // 3. Сумма чисел от 1 до N
    static int sum(int n) {
        if (n <= 0) return 0;
        return n + sum(n - 1);
    }

    // 4. Факториал
    static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // 5. Возведение в степень (без Math.pow)
    static long power(int a, int n) {
        if (n == 0) return 1;
        return a * power(a, n - 1);
    }

    // 6. Сумма цифр числа
    static int digitSum(int n) {
        if (n == 0) return 0;
        return n % 10 + digitSum(n / 10);
    }

    // 7. Количество цифр
    static int digitCount(int n) {
        if (n < 10) return 1;
        return 1 + digitCount(n / 10);
    }

    // 8. Произведение цифр
    static int digitProduct(int n) {
        if (n < 10) return n;
        return n % 10 * digitProduct(n / 10);
    }

    // 9. Максимальная цифра
    static int maxDigit(int n) {
        if (n < 10) return n;
        return Math.max(n % 10, maxDigit(n / 10));
    }

    // 10. Минимальная цифра
    static int minDigit(int n) {
        if (n < 10) return n;
        return Math.min(n % 10, minDigit(n / 10));
    }

    // 11. N-е число Фибоначчи (F(0)=0, F(1)=1)
    static long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // ===================== 12–16. Массивы =====================

    // 12. Сумма элементов массива
    static int arraySum(int[] arr, int i) {
        if (i == arr.length) return 0;
        return arr[i] + arraySum(arr, i + 1);
    }

    // 13. Максимум массива
    static int arrayMax(int[] arr, int i) {
        if (i == arr.length - 1) return arr[i];
        return Math.max(arr[i], arrayMax(arr, i + 1));
    }

    // 14. Минимум массива
    static int arrayMin(int[] arr, int i) {
        if (i == arr.length - 1) return arr[i];
        return Math.min(arr[i], arrayMin(arr, i + 1));
    }

    // 15. Количество чётных элементов
    static int countEven(int[] arr, int i) {
        if (i == arr.length) return 0;
        return (arr[i] % 2 == 0 ? 1 : 0) + countEven(arr, i + 1);
    }

    // 16. Проверка, отсортирован ли массив по возрастанию
    static boolean isSorted(int[] arr, int i) {
        if (i >= arr.length - 1) return true;
        if (arr[i] > arr[i + 1]) return false;
        return isSorted(arr, i + 1);
    }

    // ===================== 17–20. Математика =====================

    // 17. НОД (алгоритм Евклида)
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // 18. НОК через НОД
    static long lcm(int a, int b) {
        return (long) a / gcd(a, b) * b;
    }

    // 19. Перевод в двоичную систему
    static String toBinary(int n) {
        if (n < 2) return String.valueOf(n);
        return toBinary(n / 2) + n % 2;
    }

    // 20. Сумма квадратов от 1 до N
    static long sumOfSquares(int n) {
        if (n <= 0) return 0;
        return (long) n * n + sumOfSquares(n - 1);
    }

    // ===================== 21–30. Строки =====================

    // 21. Переворот строки
    static String reverse(String s) {
        if (s.isEmpty()) return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }

    // 22. Проверка палиндрома (без учёта регистра)
    static boolean isPalindrome(String s, int left, int right) {
        if (left >= right) return true;
        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
        return isPalindrome(s, left + 1, right - 1);
    }

    // 23. Количество вхождений символа
    static int countChar(String s, char c, int i) {
        if (i == s.length()) return 0;
        return (s.charAt(i) == c ? 1 : 0) + countChar(s, c, i + 1);
    }

    // 24. Количество гласных (русские и английские)
    static final String VOWELS = "aeiouyаеёиоуыэюя";

    static int countVowels(String s, int i) {
        if (i == s.length()) return 0;
        boolean vowel = VOWELS.indexOf(Character.toLowerCase(s.charAt(i))) >= 0;
        return (vowel ? 1 : 0) + countVowels(s, i + 1);
    }

    // 25. Удаление всех вхождений символа
    static String removeChar(String s, char c) {
        if (s.isEmpty()) return s;
        String rest = removeChar(s.substring(1), c);
        return s.charAt(0) == c ? rest : s.charAt(0) + rest;
    }

    // 26. Замена символа на другой
    static String replaceChar(String s, char from, char to) {
        if (s.isEmpty()) return s;
        char first = s.charAt(0) == from ? to : s.charAt(0);
        return first + replaceChar(s.substring(1), from, to);
    }

    // 27. Состоит ли строка из одинаковых символов
    static boolean allSame(String s, int i) {
        if (i >= s.length() - 1) return true;
        if (s.charAt(i) != s.charAt(i + 1)) return false;
        return allSame(s, i + 1);
    }

    // 28. Подсчёт слов (слова разделены пробелами)
    static int countWords(String s, int i, boolean inWord) {
        if (i == s.length()) return 0;
        boolean isSpace = s.charAt(i) == ' ';
        int startsWord = (!isSpace && !inWord) ? 1 : 0;
        return startsWord + countWords(s, i + 1, !isSpace);
    }

    // 29. Частоты символов + проверка анаграммы
    static void charFrequencies(String s, int i, Map<Character, Integer> freq) {
        if (i == s.length()) return;
        freq.merge(s.charAt(i), 1, Integer::sum);
        charFrequencies(s, i + 1, freq);
    }

    static boolean isAnagram(String a, String b) {
        Map<Character, Integer> fa = new HashMap<>();
        Map<Character, Integer> fb = new HashMap<>();
        charFrequencies(a, 0, fa);
        charFrequencies(b, 0, fb);
        return fa.equals(fb);
    }

    // 30. Посимвольное сравнение строк без equals()
    static boolean stringsEqual(String a, String b, int i) {
        if (a.length() != b.length()) return false;
        if (i == a.length()) return true;
        if (a.charAt(i) != b.charAt(i)) return false;
        return stringsEqual(a, b, i + 1);
    }

    // ===================== 31–40. Продвинутые алгоритмы =====================

    // 31. Быстрое возведение в степень, O(log n)
    static long fastPower(long a, int n) {
        if (n == 0) return 1;
        long half = fastPower(a, n / 2);
        return n % 2 == 0 ? half * half : half * half * a;
    }

    // 32. Рекурсивный бинарный поиск
    static int binarySearch(int[] arr, int target, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] < target) return binarySearch(arr, target, mid + 1, hi);
        return binarySearch(arr, target, lo, mid - 1);
    }

    // 33. Сортировка слиянием
    static void mergeSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    static void merge(int[] arr, int lo, int mid, int hi) {
        int[] tmp = new int[hi - lo + 1];
        int i = lo, j = mid + 1, k = 0;
        while (i <= mid && j <= hi) tmp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= hi) tmp[k++] = arr[j++];
        System.arraycopy(tmp, 0, arr, lo, tmp.length);
    }

    // 34. Быстрая сортировка (опорный — последний элемент)
    static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(arr, lo, hi);
        quickSort(arr, lo, p - 1);
        quickSort(arr, p + 1, hi);
    }

    static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (arr[j] < pivot) swap(arr, i++, j);
        }
        swap(arr, i, hi);
        return i;
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 35. Ханойская башня
    static void hanoi(int n, char from, char to, char via) {
        if (n == 0) return;
        hanoi(n - 1, from, via, to);
        System.out.println("Диск " + n + ": " + from + " -> " + to);
        hanoi(n - 1, via, to, from);
    }

    // 36. Все подмножества
    static void subsets(int[] arr, int i, List<Integer> current) {
        if (i == arr.length) {
            System.out.println(current);
            return;
        }
        subsets(arr, i + 1, current);              // не берём arr[i]
        current.add(arr[i]);
        subsets(arr, i + 1, current);              // берём arr[i]
        current.remove(current.size() - 1);
    }

    // 37. Все уникальные перестановки строки
    static void permutations(char[] chars, boolean[] used, StringBuilder current) {
        if (current.length() == chars.length) {
            System.out.println(current);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;
            // пропускаем дубликаты: одинаковый символ ставим только в порядке их следования
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            current.append(chars[i]);
            permutations(chars, used, current);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

    static void printPermutations(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        permutations(chars, new boolean[chars.length], new StringBuilder());
    }

    // 38. Лабиринт (0 — свободно, 1 — стена); путь помечается цифрой 2
    static boolean solveMaze(int[][] maze, int r, int c, int endR, int endC) {
        if (r < 0 || c < 0 || r >= maze.length || c >= maze[0].length) return false;
        if (maze[r][c] != 0) return false;        // стена или уже посещено
        maze[r][c] = 2;
        if (r == endR && c == endC) return true;
        if (solveMaze(maze, r + 1, c, endR, endC)
                || solveMaze(maze, r, c + 1, endR, endC)
                || solveMaze(maze, r - 1, c, endR, endC)
                || solveMaze(maze, r, c - 1, endR, endC)) {
            return true;
        }
        maze[r][c] = 0;                           // возврат (backtracking)
        return false;
    }

    // 39. N ферзей — вывод всех решений
    static int queensSolutions = 0;

    static void solveQueens(int[] queens, int row) {
        int n = queens.length;
        if (row == n) {
            queensSolutions++;
            printBoard(queens);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(queens, row, col)) {
                queens[row] = col;
                solveQueens(queens, row + 1);
            }
        }
    }

    static boolean isSafe(int[] queens, int row, int col) {
        for (int r = 0; r < row; r++) {
            if (queens[r] == col || Math.abs(queens[r] - col) == row - r) return false;
        }
        return true;
    }

    static void printBoard(int[] queens) {
        System.out.println("Решение " + queensSolutions + ":");
        for (int q : queens) {
            StringBuilder line = new StringBuilder();
            for (int c = 0; c < queens.length; c++) line.append(c == q ? "Q " : ". ");
            System.out.println(line);
        }
    }

    // 40. Генератор выражений: между цифрами ставим +, - или *
    // value — значение выражения, last — последнее слагаемое (нужно для приоритета *)
    static void generateExpressions(String digits, int target, int i, String expr, long value, long last) {
        if (i == digits.length()) {
            if (value == target) System.out.println(expr + " = " + target);
            return;
        }
        int d = digits.charAt(i) - '0';
        generateExpressions(digits, target, i + 1, expr + "+" + d, value + d, d);
        generateExpressions(digits, target, i + 1, expr + "-" + d, value - d, -d);
        generateExpressions(digits, target, i + 1, expr + "*" + d, value - last + last * d, last * d);
    }

    static void printExpressions(String digits, int target) {
        int first = digits.charAt(0) - '0';
        generateExpressions(digits, target, 1, String.valueOf(first), first, first);
    }

    // ===================== Демонстрация =====================

    public static void main(String[] args) {
        System.out.print("1. От 1 до 10: ");
        printAscending(10);
        System.out.println();

        System.out.print("2. От 10 до 1: ");
        printDescending(10);
        System.out.println();

        System.out.println("3. Сумма 1..100 = " + sum(100));
        System.out.println("4. 10! = " + factorial(10));
        System.out.println("5. power(2, 10) = " + power(2, 10));
        System.out.println("6. Сумма цифр 583 = " + digitSum(583));
        System.out.println("7. Количество цифр 123456 = " + digitCount(123456));
        System.out.println("8. Произведение цифр 234 = " + digitProduct(234));
        System.out.println("9. Максимальная цифра 38271 = " + maxDigit(38271));
        System.out.println("10. Минимальная цифра 38271 = " + minDigit(38271));
        System.out.println("11. Фибоначчи F(20) = " + fibonacci(20));

        int[] arr = {5, 3, 8, 2, 10, 7, 4};
        System.out.println("\nМассив: " + Arrays.toString(arr));
        System.out.println("12. Сумма = " + arraySum(arr, 0));
        System.out.println("13. Максимум = " + arrayMax(arr, 0));
        System.out.println("14. Минимум = " + arrayMin(arr, 0));
        System.out.println("15. Чётных = " + countEven(arr, 0));
        System.out.println("16. Отсортирован? " + isSorted(arr, 0)
                + "; [1, 2, 3, 5] отсортирован? " + isSorted(new int[]{1, 2, 3, 5}, 0));

        System.out.println("\n17. НОД(48, 18) = " + gcd(48, 18));
        System.out.println("18. НОК(4, 6) = " + lcm(4, 6));
        System.out.println("19. 42 в двоичной = " + toBinary(42));
        System.out.println("20. Сумма квадратов 1..5 = " + sumOfSquares(5));

        System.out.println("\n21. Переворот \"Java\" = " + reverse("Java"));
        System.out.println("22. \"казак\" палиндром? " + isPalindrome("казак", 0, 4)
                + "; \"java\" палиндром? " + isPalindrome("java", 0, 3));
        System.out.println("23. Символ 'a' в \"banana\": " + countChar("banana", 'a', 0));
        System.out.println("24. Гласных в \"Hello, Мир!\": " + countVowels("Hello, Мир!", 0));
        System.out.println("25. Удалить 'a' из \"banana\" = " + removeChar("banana", 'a'));
        System.out.println("26. Заменить 'a' на 'o' в \"banana\" = " + replaceChar("banana", 'a', 'o'));
        System.out.println("27. \"aaaaa\" одинаковые? " + allSame("aaaaa", 0)
                + "; \"aaaba\" одинаковые? " + allSame("aaaba", 0));
        System.out.println("28. Слов в \"  Привет   мир  java \": " + countWords("  Привет   мир  java ", 0, false));

        Map<Character, Integer> freq = new HashMap<>();
        charFrequencies("listen", 0, freq);
        System.out.println("29. Частоты \"listen\": " + freq);
        System.out.println("    \"listen\" и \"silent\" анаграммы? " + isAnagram("listen", "silent")
                + "; \"hello\" и \"world\"? " + isAnagram("hello", "world"));
        System.out.println("30. \"java\" == \"java\"? " + stringsEqual("java", "java", 0)
                + "; \"java\" == \"jaVa\"? " + stringsEqual("java", "jaVa", 0));

        System.out.println("\n31. fastPower(3, 13) = " + fastPower(3, 13));

        int[] sorted = {1, 3, 5, 7, 9, 11, 13};
        System.out.println("32. Бинарный поиск 9 в " + Arrays.toString(sorted) + " -> индекс "
                + binarySearch(sorted, 9, 0, sorted.length - 1)
                + "; поиск 4 -> " + binarySearch(sorted, 4, 0, sorted.length - 1));

        int[] m = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(m, 0, m.length - 1);
        System.out.println("33. Merge Sort: " + Arrays.toString(m));

        int[] q = {10, 7, 8, 9, 1, 5, 3};
        quickSort(q, 0, q.length - 1);
        System.out.println("34. Quick Sort: " + Arrays.toString(q));

        System.out.println("\n35. Ханойская башня, 3 диска:");
        hanoi(3, 'A', 'C', 'B');

        System.out.println("\n36. Подмножества [1, 2, 3]:");
        subsets(new int[]{1, 2, 3}, 0, new ArrayList<>());

        System.out.println("\n37. Перестановки \"ABC\":");
        printPermutations("ABC");
        System.out.println("    Перестановки \"AAB\" (уникальные):");
        printPermutations("AAB");

        int[][] maze = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        System.out.println("\n38. Лабиринт (путь из (0,0) в (4,4) помечен цифрой 2):");
        if (solveMaze(maze, 0, 0, 4, 4)) {
            for (int[] row : maze) System.out.println(Arrays.toString(row));
        } else {
            System.out.println("Путь не найден");
        }

        System.out.println("\n39. Задача о 4 ферзях:");
        solveQueens(new int[4], 0);
        System.out.println("Всего решений: " + queensSolutions);

        System.out.println("\n40. Выражения из \"123\" с результатом 6:");
        printExpressions("123", 6);
        System.out.println("    Выражения из \"2345\" с результатом 26:");
        printExpressions("2345", 26);
    }
}

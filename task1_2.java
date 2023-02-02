import java.util.ArrayList;
import java.util.Random;

public class task1_2
{
    public static void main(String[] args)
    {
        Zadacha1();
        Zadacha2();
    }
    // END MAIN

    static void Zadacha1()
    {
        System.out.println
        ("1) Пусть дан произвольный список целых чисел,\nудалить из него четные числа: \n");
        ArrayList<Integer> list1 = new ArrayList<>();   // Создал список
        Random rand = new Random();                     // Объект Рандом для тренировки ;)

        for (int i = 0; i < 10; i++)
        {
            // Рандомно заполнил массив размером 10, числами 0-51
            list1.add(i, rand.nextInt(51));
        }
        System.out.println("Исходный массив: " + list1);
        for (int i = 0; i < list1.size(); i++)
        {
            if (list1.get(i) % 2 == 0) // удаляю четные числа
            {
                list1.remove(i);
                i--;
            }
        }

        System.out.println("Массив нечетных чисел: " + list1 + "\n");
    }

    static void Zadacha2()
    {
        System.out.println
        ("2) Задан целочисленный список ArrayList." +
        " \nНайти минимальное, максимальное и среднее ариф. из этого списка\n");

        ArrayList<Integer> list2 = new ArrayList<>();   // Создал список
        Random rand = new Random();                     // Объект Рандом для тренировки ;)

        for (int i = 0; i < 10; i++)
        {
            // Рандомно заполнил массив размером 10, числами 0-51
            list2.add(i, rand.nextInt(51));
        }
        System.out.println("Дан массив: " + list2 + "\n");
        int min = list2.get(0);
        int max = list2.get(0);
        int sum = 0;

        for (int i = 0; i < list2.size(); i++)
        {
            max = max < list2.get(i) ? list2.get(i) : max; // Тернарные операции из лекции
            min = min > list2.get(i) ? list2.get(i) : min; // Вроде работают :D
            sum += list2.get(i);
        }

        System.out.println("Максимальное число в массиве : " + max +
                          "\nМинимальное число в массиве : " + min +
                     "\nсреднее арифметическое в массиве : " + sum/list2.size() );

    }

}
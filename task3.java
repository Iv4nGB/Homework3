public class task3
{
    public static void main(String[] args)
     {

        int[] array = new int[] {4,3,2,1,0,-1};
        System.out.println(PrintArray(array));
        array = mergeSort(array);
        System.out.println(PrintArray(array));

    } // END MAIN

    public static int[] mergeSort(int[] array)
    {
        int[] temp;
        int[] massTemp = new int[array.length];

        int size = 1;
        while (size < array.length)
        {                                                       // i = 1(0) - 2(2) - 3(4) - 4(6)... for 1While
            for (int i = 0; i < array.length; i = i + 2 * size) // i = 1(4) - 2(5) - 3(6) - 4(7)... for 2 While
            {
                merge(array, i, array, i + size, massTemp, i, size);
                //        i = 1(0) - 2(2) - 3(4) - 4(6)... for 1While
                //i+size(1) = 1(1) - 2(3) - 3(5) - 4(7)... for 1While
            }

            temp = array;
            array = massTemp;
            massTemp = temp;
            // size = 1
            size = size * 2; // while: 1(1) - 2(2) - 3(4) - 4(8) ...while

            System.out.println(PrintArray(array));
        }
        return array;
    }

    private static void merge
    (int[] mass_1, int mass1_Start, int[] mass_2, int mass2_Start,
     int[] massTemp, int massTemp_Start, int size)
    // переменная size показывает какого размера массивы мы хотим сливать
    {
// mass1_Start номер текущего элемента в первом массиве (указатель)  для for= i = 0 - 2 - 4 - 6
// mass2_Start номер текущего элемента во втором массиве (указатель) for i+size = 1 - 3 - 5 - 7
//massTemp_Start = 0 - 2 - 4 - 6                                      for  size = 1 - 1 - 1 - 1
        int mass1_End = Math.min(mass1_Start + size, mass_1.length);//  mas1End = 1 - 3 - 5 - 7
        // Math.min возвращает минимальное значение из двух аргументов
        int mass2_End = Math.min(mass2_Start + size, mass_2.length);//  mas2End = 2 - 4 - 6 - 8

        if (mass1_Start + size > mass_1.length)
        {// 1(0+1>13) 2(2+1>13) 3(4+1>13) 3(6+1>13) 3(8+1>13) 3(10+1>13) 3(12+1>13) для for
            for (int i = mass1_Start; i < mass1_End; i++)
            {
                massTemp[i] = mass_1[i];
            }
            return;
        }

        int iteration_Count = mass1_End - mass1_Start + mass2_End - mass2_Start;
        // iteration_Count = 1(2) - 2(2)- 3(2) для for
        for (int i = massTemp_Start; i < massTemp_Start + iteration_Count; i++)
        {//1(i = 0-1-2..)-2(i =2-3-4..)< 1(0+2)-2(2+2)-3(4+4?)+1(8+8?)
            if (mass1_Start < mass1_End && (mass2_Start >= mass2_End || mass_1[mass1_Start] < mass_2[mass2_Start]))
        {//1(0)2(2)3(4)4(6)<1(1)2(3)3(5)4(7 && 1(1/2)2(3-4)3(5) >=1(2)2(4)3(6)||mass_1[0][2]=4,2<mass_2[1]=3,1
                massTemp[i] = mass_1[mass1_Start];
                mass1_Start++; //0-1\-2-3-4-5...
               //massTemp[0,3] = mass_2[1] {-,4,-,2}
            }
            else
            { //massTemp[0,2] = mass_2[1,3] {3,-,1,}
                massTemp[i] = mass_2[mass2_Start];
                mass2_Start++; //1(1++) 2(3++) 3(5++) 4(7++)...
            }
        }
    }

    private static String PrintArray(int[] array) // печать массива
    {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < array.length; i++)
        {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
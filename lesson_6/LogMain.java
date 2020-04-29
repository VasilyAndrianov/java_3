package lesson_6;

import java.util.Arrays;

public class LogMain {
    private static final int [] arr = {1, 6, 34, 4, 65, 456, 3, 7, 4, 14, 67, 86};
    private static final int [] mass = {1, 4, 4, 1, 4, 1, 1};
    private static final int [] massVerTwo = {1, 4, 5, 2, 1, 4};
    private static final int FOUR = 4;
    private static final int ONE = 1;

    public static void main(String[] args) {
        ArrEnd(arr);
        CheckArray(mass);
        CheckArray(massVerTwo);
        CheckArrays(mass);
        CheckArrays(massVerTwo);
    }
    
    public static int[] ArrEnd(int[] mass)throws RuntimeException{
        int num = 0;
        String str =  Arrays.toString(mass);
        if (str.indexOf(String.valueOf(4))!= -1) {
            for( int i =  0; i <  mass.length; i++) {
                if (mass[i] ==  4) num =  i;
            }
            int[] arr =  new int[mass.length - num - 1];
            System.arraycopy(mass, num +  1, arr, 0, arr.length);
            System.out.println(Arrays.toString(arr));
            return arr;
        } else {
            throw new RuntimeException();
        }

    }


    //вариант 1
    public static boolean CheckArray(int[] massive){
        boolean one = false, four = false;
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] == ONE) one = true;
            else if (massive[i] == FOUR) four = true;
            else return false;
        }
        return one && four;
    }

    //    вариант 2
    public static boolean CheckArrays(int[] massive){
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] != 1 && massive[i] != 4)
                return false;

        }
        return true;
    }

}



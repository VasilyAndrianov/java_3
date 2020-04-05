import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        int a = 2;
        int b = 9;
        Object[] arr = {1, 5, 12, 43, 234, 3, 23, 27, 99, 10};
        String [] str = {"big", "soul", "black", "apple", "numb"};
        List<Object> listOf = new ArrayList<Object>();
        change(arr, a, b);
        transfor(str, listOf);
        fruitBox();


    }
//1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    public static void change(Object[] arr, int one, int two){
        System.out.println("Version1: " + Arrays.toString(arr));
        Object obj = arr[one];
        arr[one] = arr[two];
        arr[two] = obj;
        System.out.println("Version2: " + Arrays.toString(arr));
        System.out.println();
    }
//2. Написать метод, который преобразует массив в ArrayList;
    public static void transfor(String[] obj, List<Object> listOfObjact){
        Collections.addAll(listOfObjact, obj);
        System.out.println("ArrayList: " + listOfObjact);
        System.out.println();
        return;
    }
//3. Большая задача:
    public static void fruitBox(){
        Box<Apple> boxAp1 = new Box<>(new Apple(), new Apple(), new Apple(), new Apple(), new Apple());
        Box<Apple> boxAp2 = new Box<>();
        Box<Orange> boxOr1 = new Box<>(new Orange(), new Orange(), new Orange(), new Orange());
        Box<Orange> boxOr2 = new Box<>();
        System.out.println("The weight of the box of apples is equal to = " + boxAp1.getWeight());
        System.out.println("The weight of the box of oranges is equal to = " + boxOr1.getWeight());
        System.out.println("The weight of an empty box is equal to = " + boxOr2.getWeight());
        System.out.println();
        System.out.println("These boxes have weight - " + boxAp2.compare(boxOr2));
        System.out.println();
        boxOr1.overflow(boxOr2);
        System.out.println();
        System.out.println("box of apples №1 - " + boxAp1.getBox());
        System.out.println("box of apples №2 - " + boxAp2.getBox());
        System.out.println("box of oranges №1 - " + boxOr1.getBox());
        System.out.println("box of oranges №2 - " + boxOr2.getBox());
    }
}

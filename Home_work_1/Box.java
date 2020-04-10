import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> box;

    public Box(T... fruit){
        box =  new ArrayList<>(Arrays.asList(fruit));
    }

    public ArrayList<T> getBox() {
        return box;
    }

    public void addFruit( T fruit) {
        box.add(fruit);
    }

    public float getWeight() {
        float wtFull = 0;
        for (int i = 0; i < box.size(); i++) {
            wtFull = wtFull += box.get(i).getWeight();
        }
        return wtFull;
    }

    public boolean compare(Box<? extends Fruit> boxWithFruits){
        float f = 0.0f;
        return (getWeight() - boxWithFruits.getWeight()) < f;
    }

    public void overflow(Box<T> emptyBox){
        emptyBox.box.addAll(this.box);
        box.clear();
    }

}

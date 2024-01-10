package tests.lesson_collections;

import java.util.HashSet;
import java.util.Set;

public class SetCollection {
    Set<Integer> set = new HashSet<>(Set.of(111, 222, 333));

    public void addSet(int amount){
        set.add(amount);
        for (Integer i : set){
            System.out.println(i);
        }
    }

    public void searchSet(int amount){
        if(set.contains(amount)){
            System.out.println("Набор содержит " + amount);
        }
        else {
            System.out.println("Набор не содержит " + amount);
        }
    }

    public void removeSetItem(int amount){
        set.remove(amount);
        System.out.println("Элемент удален " + amount);
        System.out.println(set);
    }
}

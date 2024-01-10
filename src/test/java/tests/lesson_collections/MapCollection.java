package tests.lesson_collections;

import java.util.HashMap;

public class MapCollection {
    HashMap<Integer, String> map = new HashMap<>();

    public void addMap(String element){
        int i =0;
        do { map.put(i, element);
            i++;
    }while (i < 10);
        System.out.println(map);
}

public void searchMap(){
        map.replace(3, "Poland");
        map.containsKey(3);
        System.out.println(map);
}

public void removeMap(){
        map.remove(4, "Moscow");
        System.out.println(map.get(4));
}
}

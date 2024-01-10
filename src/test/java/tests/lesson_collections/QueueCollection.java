package tests.lesson_collections;

import java.util.*;

public class QueueCollection {
    Queue<String> stringQueue = new LinkedList<>(List.of("Amigo", "Tom", "Veronika"));

    public void addQueue(String element){
        stringQueue.add(element);
        System.out.println("Добавлен эелемент в очередь " + element);
    }

    public void searchQueue(String element){
        while (stringQueue.contains("Tom")){
            stringQueue.offer(element);
            System.out.println("Если есть Tom, то  " + element);
            break;
        }
        System.out.println(stringQueue);
    }

    public void removeQueueItem(){
        stringQueue.remove();
        System.out.println("Удаляет элемент который был добавлен первым то есть Amigo  " + stringQueue);
    }
}

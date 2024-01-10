package tests.lesson_collections;

import java.util.ArrayList;
import java.util.List;

public class ListCollection {
    ArrayList<Integer> integerList= new ArrayList<>(List.of(1, 2, 3, 4, 5));
    ArrayList<Integer> secondList = new ArrayList<>(List.of(11, 22, 33));

    public void addList(int amount){
        for (int i = integerList.size()+1; i < amount ; i++) {

            System.out.println("Элемент с номером " + i + " добавлен");
            integerList.add(i);
        }
        System.out.println("Добавлено элементов в List: " + amount);
    }

    public void addWithIndex(){
        integerList.add(6, 7);
        System.out.println("Добавлен элемент 7 c индексом 6 в List");
    }

    public void secondList(){
       secondList.addAll(integerList);
        System.out.println("Первое добавление: " + secondList);
        secondList.addAll(1, integerList);
        System.out.println("Второе добавление: " + secondList);
    }

    public void searchList(int element) {
        for (int i = 0; i < secondList.size(); i++) {
            int currentElement = secondList.get(i);
            if (currentElement == element) {
                System.out.println("Элемент найден на позиции рррр" + i);
                break;
            }
        }
    }

    public void getSize(){
        System.out.println(integerList.size() + "вывод элементов");
        System.out.println( integerList + "вывод элементов");
    }

    public void removeElement(int element){
        secondList.remove(element);
        System.out.println(secondList);
        System.out.println("Элемент " + element + " удален");
    }


    public void jj(int element){
        for (int i = secondList.size() - 1; i >= 0; i--) {
            int currentElement = secondList.get(i);
            if (currentElement == element) {
                System.out.println("Элемент найден на позиции " + i);
               break;
            }
        }

    }
}

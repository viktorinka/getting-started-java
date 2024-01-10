package tests.lesson_collections;

public class Main {
    public static void main(String[] args){
        ListCollection list = new ListCollection();
        list.addList(7);
        list.addWithIndex();
        list.getSize();
        list.secondList();
        list.searchList(11);
        list.jj(7);
        list.removeElement(5);

        QueueCollection queue = new QueueCollection();
        queue.addQueue("Henry");
        queue.searchQueue("Jerry");
        queue.removeQueueItem();

        MapCollection map = new MapCollection();
        map.addMap("Moscow");
        map.searchMap();
        map.removeMap();

        SetCollection set = new SetCollection();
        set.addSet(744);
        set.searchSet(744);
        set.removeSetItem(111);
    }
}

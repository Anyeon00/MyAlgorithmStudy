package LinkedList;

import javax.naming.NameClassPair;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ListIterator<Integer> it = linkedList.listIterator();
        for (int i = 0; i < 5; i++) {
            it.add(i);
        }
        while (!linkedList.isEmpty()) {
            System.out.println(linkedList.poll());
        }
    }
}

package week3.Iterator;

import java.util.Iterator;
import java.util.ArrayList;

public class MyStack implements Iterable<String> {

    private ArrayList<String> list = new ArrayList<>();

    // your code
    public void push(String string){
        list.add(string);
    }

    public String pop(){
        return list.remove(list.size()-1);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }

    @Override
    public Iterator<String> iterator() {
        return new StackIterator(list);
    }
}

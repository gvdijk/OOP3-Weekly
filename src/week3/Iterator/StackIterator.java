package week3.Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class StackIterator implements Iterator<String> {

    private ArrayList<String> list;
    private int position = 0;

    public StackIterator(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public String next() {
        String item = list.get(position);
        position++;
        return item;
    }
}

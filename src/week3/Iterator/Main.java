package week3.Iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push("kwik");
        stack.push("kwek");
        stack.push("kwak");

        // your code
        Iterator<String> iterator = stack.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-----------------------------------");

        stack.push("one");
        stack.push("two");
        stack.push("three");

        for(int i = 0;i < stack.size();i++){
            System.out.println(stack.pop());
        }
    }
}

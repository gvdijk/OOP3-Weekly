package week1;

public class Developer {
    String name;
    int age;

    Developer (String name, int age) {
        this.name = name;
        this.age = age;
    }

    int getAge() {
        return this.age;
    }        

    @Override
    public String toString() {
        return("name = " + this.name + " age = " + this.age);
    }
}

package generics_enum;

import java.util.ArrayList;

class Generics {

    public static void main (String[] args) {
        Box<Fruits> b = new Box<>();
        Box<Apple> a = new Box<>();
        Fruits f = new Fruits();
        Toy t = new Toy();
        Apple apple = new Apple();
        a.add(apple);

        b.add(apple);
        b.add(f);
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
}

class Toy {
    @Override
    public String toString () {
        return "TOY";
    }
}

class Fruits {
    public String toString () {
        return "Fruits";
    }
}

class Apple extends Fruits {
    public String toString () {
        return "Apple";
    }
}

class Box <T> {

    ArrayList<T> e = new ArrayList<T>();

    public int size () {
        return e.size();
    }

    void add (T box) {
        e.add(box);
    }

    public String toString () {
        return e.toString();
    }
}
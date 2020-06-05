package generics_enum;

import java.util.ArrayList;
import java.util.Comparator;

public class ExtendsTest<T extends FruitBox> extends ArrayList<T> {
    public ExtendsTest(){
        super();
        FruitBox b = new FruitBox();
        add((T) b);
    }



    @Override
    public String toString () {
        return super.toString();
    }

    public static void main (String[] args) {
        ExtendsTest<? extends FruitBox> e = new ExtendsTest<>();
        System.out.println(e);
    }
}

class FruitBox {

    @Override
    public String toString () {
        return "FruitBox";
    }
}


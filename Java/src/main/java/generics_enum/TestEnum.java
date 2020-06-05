package generics_enum;

enum Fruits {

    WaterMelon(10),
    Apple(1),
    Tomato(1);

    Fruits (int val) {
        this.val = val;
    }

    private final int val;

    public int getVal () {
        return val;
    }
}

public class TestEnum {
    public static void main (String[] args) {

        TestEnum t = new TestEnum();
        Fruits wm = Fruits.WaterMelon;
        Fruits ap = Fruits.Apple;
        Fruits tm = Fruits.Tomato;

        System.out.println(Fruits.WaterMelon.getVal());
    }
}

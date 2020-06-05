package level1;

public class StringBasic_OK {
    public boolean solution (String s) {
        if (s.length() == 4 || s.length() == 6) {
            try {
                Integer.parseInt(s);
                return true;
            } catch (Exception e) {
                return false;
            }
        }else{
            return false;
        }
    }

    public static void main (String[] args) {
        StringBasic_OK s = new StringBasic_OK();
        String t = "1234";
        System.out.println(s.solution(t));
    }
}

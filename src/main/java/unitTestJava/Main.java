package unitTestJava;

public class Main {

    public static void main(String[] args) {

        String kot = "tok";
        StringBuilder reversed = new StringBuilder("kot").reverse();
        System.out.println(kot.equals(reversed.toString()));
        System.out.println(kot==(reversed.toString()));
    }
}

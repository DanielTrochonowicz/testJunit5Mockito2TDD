package unitTestJava;

import org.junit.jupiter.api.Test;

class KalkulatorTest {

    public static void main(String[] args) {

         testKalkulatorAdd();
    }

    @Test
    private static void testKalkulatorAdd(){
        Kalkulator kalkulator = new Kalkulator();

        int result = kalkulator.sum(2,2);

        if (result != 4){
            throw new IllegalStateException("Wrong result, 2+2 is not 4");
        }else {
            System.out.println("Ok");
        }
    }
}
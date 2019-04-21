import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        System.out.println(new Number(26888999).getMultiplicitivePersistence());

        HashMap<Integer, Integer> memo = new HashMap<>();
        for (int i=0; i<2147483647; i++){
            Number.getWithMemoisation(memo, i);
            if (i % 1000000 == 0) {
                System.out.println(i);
            }
        }
    }
}

public class main {
    public static void main(String[] args) {
        System.out.println(new number(26888999).getMultiplicitivePersistence());

        for (int i=0; i<1000000; i++){
            System.out.print(i+": ");
            System.out.println(new number(i).getMultiplicitivePersistence());
        }
    }
}

import java.util.HashMap;

public class Number {
    private int total;
    private int[] array;

    private static int[] totalToArray(int t) {
        int[] out = new int[10];

        String s = Integer.toString(t);
        for (int i=0; i<s.length(); i++) {
            int digit = Character.getNumericValue(s.charAt(i));
            out[digit]++;
        }

        return out;
    }

    private static int arrayToTotal(int[] a) {
        assert a.length == 10;
        String out = "";

        for (int i=0; i<a.length; i++) {
            out += new String(new char[a[i]]).replace("\0", Integer.toString(i));
        }

        return Integer.parseInt(out);
    }

    Number(int t) {
        total = t;
        array = totalToArray(t);
    }

    Number(int[] a) {
        total = arrayToTotal(a);
        array = a;
    }

    public int getMultiplicitivePersistence() {
        int next = 1;
        String s = Integer.toString(total);

        for (int i=0; i<s.length(); i++) {
            int digit = Character.getNumericValue(s.charAt(i));
            next *= digit;
        }

        if (next == total) {
            return 0;
        } else {
            return 1 + new Number(next).getMultiplicitivePersistence();
        }
    }

    public static int getWithMemoisation(HashMap<Integer, Integer> mem, Integer num) {
        if (mem.keySet().contains(num)) {
            return mem.get(num);
        } else {
            int next = 1;
            String s = Integer.toString(num);

            for (int i=0; i<s.length(); i++) {
                int digit = Character.getNumericValue(s.charAt(i));
                next *= digit;
            }

            if (next == num) {
                mem.put(num, 0);
                return 0;
            } else {
                Integer result = 1 + getWithMemoisation(mem, next);
                mem.put(num, result);
                return result;
            }
        }
    }
}

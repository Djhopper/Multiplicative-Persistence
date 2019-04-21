public class number {
    private int total;
    private int[] array;

    private static int[] totalToArray(int t) {
        int[] out = new int[8];

        String s = Integer.toString(t);
        for (int i=0; i<s.length(); i++) {
            if (i>1) {
                int digit = Character.getNumericValue(s.charAt(i));
                out[digit - 2] += 1;
            }
        }

        return out;
    }

    private static int arrayToTotal(int[] a) {
        assert a.length == 8;
        String out = "";

        for (int i=0; i<a.length; i++) {
            out += new String(new char[a[i]]).replace("\0", Integer.toString(i+2));
        }

        return Integer.parseInt(out);
    }

    number(int t) {
        total = t;
        array = totalToArray(t);
    }

    number(int[] a) {
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

        if (Integer.toString(next).contains("0")) {
            return 2;
        } else {
            return 1 + new number(next).getMultiplicitivePersistence();
        }
    }
}

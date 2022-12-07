public class CorteHastes {

    public static void main(String[] args) {
        Integer[] preco = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 50, 60, 70, 80, 90, 100};

        long tempoIni = System.currentTimeMillis();
        System.out.println(CHast(preco, 10));
        System.out.printf("%f ms%n", (System.currentTimeMillis() - tempoIni) / 1000d);


        tempoIni = System.currentTimeMillis();
        System.out.println(CHBottomUp(preco, 10));
        System.out.printf("%f ms%n", (System.currentTimeMillis() - tempoIni) / 1000d);
    }

    private static int CHBottomUp(Integer[] p, int n) {
        Integer[] r = new Integer[n + 1];
        r[0] = 0;
        int q = 0;
        for (int j = 1; j <= n; j++) {
            q = 0;
            for (int i = 1; i <= j; i++) {
                q = Math.max(q, p[i] + r[j - i]);
            }
            r[j] = q;
        }
        return q;
    }

    private static int CHast(Integer[] p, Integer n) {
        if (n == 0) {
            return 0;
        }

        int q = 0;

        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i] + CHast(p, n - i));
        }
        return q;
    }

}

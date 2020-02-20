import java.util.Scanner;

public class labor_strike {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int s_i;
        int strikeC = 0;

        boolean[] strikes = new boolean[m];
        for (int i = 0; i < n; i++) {
            s_i = scan.nextInt();
            if (s_i == 1) {
                System.out.println(m);
                return;
            }
            for (int j = s_i - 1; j < m; j += s_i) {
                int mod = j % 7;
                if (mod == 5 || mod == 6) {
                    continue;
                }
                if (!strikes[j]) {
                    strikes[j] = true;
                    strikeC++;
                }
            }
        }

        System.out.println(strikeC);
    }
}

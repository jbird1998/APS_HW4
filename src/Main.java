import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int[] list;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] lparts = line.split(" ");

        int N = Integer.parseInt(lparts[0]);
        int M = Integer.parseInt(lparts[1]);

        ArrayList<String> output = new ArrayList<>();
        list = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            list[i] = i;
        }
        list[0] = -1;
        list[N + 1] = -1;

        int L, R;
        int newL, newR;
        StringBuilder builder;
        for (int i = 0; i < M; i++) {
            line = scan.nextLine();
            lparts = line.split(" ");
            L = Integer.parseInt(lparts[0]);
            R = Integer.parseInt(lparts[1]);
            if (R < L) {
                int temp = L;
                L = R;
                R = temp;
            }
            newL = L - 1;
            newR = R + 1;
            newL = solve(newL);
            newR = solve(newR);
            if (L == R) {
                if (newR < newL) {
                    list[L] = newR;
                } else {
                    list[L] = newL;
                }
            } else {
                if (L != 0) {
                    list[L] = newR;
                }
                if (R != (N + 1)) {
                    list[R] = newL;
                }
            }
            builder = new StringBuilder(15);
            if (newL < 0) {
                builder.append("* ");
            } else {
                builder.append(newL);
                builder.append(" ");
            }
            if (newR < 0) {
                builder.append("*\n");
            } else {
                builder.append(newR);
                builder.append("\n");
            }
            output.add(builder.toString());
        }
        for (String o: output) {
            System.out.print(o);
        }
    }

    public static int solve(int index) {
        if (index < 0 || list[index] == index) {
            return index;
        }
        list[index] = solve(list[index]);
        return list[index];
    }
}


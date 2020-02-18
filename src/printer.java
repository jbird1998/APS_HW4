import java.util.Scanner;

public class printer {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line1 = scan.nextLine();
        String line2 = scan.nextLine();

        String[] l1parts = line1.split(" ");
        String[] l2parts = line2.split(" ");

        int N = Integer.parseInt(l1parts[0]);
        int M = Integer.parseInt(l1parts[1]);

        int[] arr = new int[N];
        boolean[] bools = new boolean[N];
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(l2parts[i]);
            arr[i] = val;
        }
        int count = 1;
        int index = 0;
        while (index != M || arr[index] != max(arr, bools)) {
            if (arr[index] == max(arr, bools)) {
                bools[index] = true;
                count++;
            }
            index++;
            if (index >= N) {
                index = 0;
            }
            while (bools[index]) {
                index++;
                if (index >= N) {
                    index = 0;
                }
            }
        }
        System.out.println(count);
    }

    public static int max(int[] arr, boolean[] bools) {
        int m = -1;
        for (int i = 0; i < arr.length; i++) {
            if (m < arr[i] && !bools[i]) {
                m = arr[i];
            }
        }
        return m;
    }
}

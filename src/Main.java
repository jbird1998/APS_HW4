import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //TODO: OPtimize (too many timeouts) and investigate wrong answers
        //NOTE: Don't need to increment by T, wait times can be shorter.
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] lparts = line.split(" ");

        int N = Integer.parseInt(lparts[0]);
        int T = Integer.parseInt(lparts[1]);
        int M = Integer.parseInt(lparts[2]);

        int[] arrivals = new int[M];
        String[] directions = new String[M];

        for (int i = 0; i < M; i++) {
            line = scan.nextLine();
            lparts = line.split(" ");
            arrivals[i] = Integer.parseInt(lparts[0]);
            directions[i] = lparts[1];
        }

        int[] times = new int[M];
        boolean[] visited = new boolean[M];
        int index = 0;
        String currentDir = "left";
        int time = 0;
        int tripCount;
        boolean changeDir;
        while (index < M) {
            tripCount = 0;
            changeDir = false;
            for (int i = 0; i < M; i++) {
                if (!visited[i] && arrivals[i] <= time) {
                    changeDir = true;
                    if (directions[i].equals(currentDir) && tripCount <= N) {
                        visited[i] = true;
                        times[i] = time + T;
                        tripCount++;
                        index++;
                    }
                }
            }
            if (changeDir) {
                if (currentDir.equals("left")) {
                    currentDir = "right";
                } else {
                    currentDir = "left";
                }
            }
            time += T;
        }
        for (int a: times) {
            System.out.println(a);
        }
    }
}

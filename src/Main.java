import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //TODO: Optimize (too many timeouts) and investigate wrong answers
        //NOTE: Don't need to increment by T, wait times can be shorter.
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] lparts = line.split(" ");

        int N = Integer.parseInt(lparts[0]);
        int T = Integer.parseInt(lparts[1]);
        int M = Integer.parseInt(lparts[2]);

        int[] arrivals = new int[M];
        char[] directions = new char[M];

        for (int i = 0; i < M; i++) {
            line = scan.nextLine();
            lparts = line.split(" ");
            arrivals[i] = Integer.parseInt(lparts[0]);
            directions[i] = lparts[1].charAt(0);
        }

        int[] times = new int[M];
        boolean[] visited = new boolean[M];
        int index = 0;
        char currentDir = 'l';
        int time = 0;
        int tripCount;
        boolean changeDir;
        boolean earliestNotVisitedSet = false;
        int earliestNotVisited = 0;
        while (index < M) {
            //System.out.println(earliestNotVisited + " t: " + time);
            tripCount = 0;
            changeDir = false;
            for (int i = earliestNotVisited; i < M; i++) {
                if (!visited[i] && arrivals[i] <= time) {
                    changeDir = true;
                    if (directions[i] == currentDir && tripCount < N) {
                        visited[i] = true;
                        //System.out.println("VISITED");
                        times[i] = time + T;
                        tripCount++;
                        index++;
                    }
                }
                if (!visited[i] && !earliestNotVisitedSet) {
                    earliestNotVisitedSet = true;
                    earliestNotVisited = i;
                }
               //System.out.println("\t v: " + visited[i]);
            }
            if (changeDir) {
                if (currentDir == 'l') {
                    currentDir = 'r';
                } else {
                    currentDir = 'l';
                }
                time += T;
            } else {
//                if (time - arrivals[earliestNotVisited] < T && 0 < time - arrivals[earliestNotVisited]) {
//                    time = arrivals[earliestNotVisited];
//                } else {
                    time++;
                //
            }
            earliestNotVisitedSet = false;
        }
        for (int a: times) {
            System.out.println(a);
        }
    }
}

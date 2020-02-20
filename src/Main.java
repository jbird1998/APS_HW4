import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String skip = scan.nextLine();

        HashMap<Integer, Integer> union = new HashMap<>();
        ArrayList<ArrayList<Integer>> queue = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        String line;
        String[] lparts;
        int index = -1;
        int totalListsPopped = 0;
        for (int i = 0; i < n; i++) {
            //TODO: Scan and parse groups
            line = scan.nextLine();
            lparts = line.split(" ");
            int k = Integer.parseInt(lparts[0]);
            int first = Integer.parseInt(lparts[1]);
            union.put(first, first);
            int key;
            for (int j = 2; j <= k; j++) {
                key = Integer.parseInt(lparts[j]);
                union.put(key, first);
            }
        }
        line = scan.nextLine();
        while (line.charAt(0) != 'S') {
            if (line.charAt(1) == 'u') { // push operation
                lparts = line.split(" ");
                int key = Integer.parseInt(lparts[1]);
                try {
                    int found = find(union, key);
                    int place = union.get(found);
                    if (place > 0) { // this indicates we haven't yet added an element of this group
                        union.replace(found, index);
                        index--;
                        ArrayList<Integer> node = new ArrayList<>();
                        node.add(key);
                        queue.add(node);
                    } else {
                        place = -1 * place - 1; // the index of the group
                        ArrayList<Integer> node = queue.get(place - totalListsPopped);
                        node.add(key);
                    }
                } catch (NullPointerException e) {
                    ArrayList<Integer> node = new ArrayList<>();
                    node.add(key);
                    queue.add(node);                            
                }
            } else { // pop operation
                if (queue.size() != 0) {
                    ArrayList<Integer> node = queue.get(0);
                    int num = node.get(0);
                    output.add(num);
                    if (node.size() > 1) {
                        node.remove(0);
                    } else { // last node present in group
                        try {
                            int found = find(union, num);
                            union.replace(found, found);
                        } catch (NullPointerException e) {
                            // uh yeah, catch.
                        }
                        queue.remove(0);
                        totalListsPopped++;
                    }
                }
            }
            line = scan.nextLine();
        }
        for (int o: output) {
            System.out.println(o);
        }
    }

    public static int find(HashMap<Integer, Integer> map, int k) {
        int v = map.get(k);
        if (k == v || v < 0) {
            return k;
        }
        int x = find(map, v);
        map.replace(k, x);
        return x;
    }
}

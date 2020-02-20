import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class dud_ruthless_war {

    public static void main(String[] args) throws IOException {
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] lparts = line.split(" ");

        int N = Integer.parseInt(lparts[0]);
        int M = Integer.parseInt(lparts[1]);

        SinglyLinkedList list = new SinglyLinkedList();
        //ArrayList<String> output = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int L, R;
        Node left = null, right = null;
        for (int i = 0; i < M; i++) {
            line = scan.nextLine();
            lparts = line.split(" ");
            L = Integer.parseInt(lparts[0]);
            R = Integer.parseInt(lparts[1]);
            left = list.get(L);
            right = list.getAfter(R, left);
            Node newL = null, newR = null;
            if (left != null) {
                newL = list.before;
            }
            if (right != null) {
                newR = right.next;
            }
            if (left != null && newL != null) {
                newL.next = newR;
            } else {
                list.head = newR;
            }
            if (newL == null && newR == null) {
                output.write("* *\n");
                list.head = null;
                list.before = null;
            } else {
                StringBuilder builder = new StringBuilder(15);
                if (newL == null) {
                    builder.append("* ");
                } else {
                    builder.append(newL.value);
                    builder.append(" ");
                }
                if (newR == null) {
                    builder.append("*");
                } else {
                    builder.append(newR.value);
                }
                builder.append("\n");
                output.write(builder.toString());
            }
        }

        output.flush();
//        for (String o: output) {
//            System.out.println(o);
//        }
    }

    public static class Node {
        int value;
        Node next;

        public Node(int v) {
            this.value = v;
        }
    }

    public static class SinglyLinkedList {
        Node head;
        Node before = null;

        public SinglyLinkedList() {}

        public Node get(int index) {
            this.before = null;
            Node temp = head;
            while (temp != null) {
                if (temp.value == index) {
                    return temp;
                }
                before = temp;
                temp = temp.next;
            }
            return null;
        }

        public Node getAfter(int index, Node after) {
            Node temp = after;
            while (temp != null) {
                if (temp.value == index) {
                    return temp;
                }
                temp = temp.next;
            }
            return null;
        }

        public void add(int i) {
            Node node = new Node(i);
            if (head == null) {
                head = node;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
}

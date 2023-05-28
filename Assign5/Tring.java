import java.util.Scanner;

class Tring {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();

        // Decides the number of nodes forming the ring
        int token = 0;

        for (int i = 0; i < n; i++)
            System.out.print(" " + i);
        System.out.println(" " + 0);

        try {
            while (true) {
                System.out.print("Enter sender: ");
                int s = sc.nextInt();
                System.out.print("Enter receiver: ");
                int r = sc.nextInt();
                System.out.print("Enter Data: ");
                String d = sc.next();

                System.out.print("Token passing:");
                 //current token not equal to sender, increment i by 1 and j by j+1%n
         
                for (int i = token, j = token; (i % n) != s; i++, j = (j + 1) % n) {
                System.out.print(" " + j + "->");
                }
                System.out.println(" " + s);

                System.out.println("Sender " + s + " sending data: " + d);

                // start forwarding from node after sender until it becomes equal to receiver and increment  by i+1%n
                for (int i = (s + 1) % n; i != r; i = (i + 1) % n) {
                System.out.println("Data " + d + " forwarded by " + i);
                }
                System.out.println("Receiver " + r + " received data: " + d);
                token = s;
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}

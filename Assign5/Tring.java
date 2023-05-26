import java.util.Scanner;

class Tring {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int n = scan.nextInt();

        int token = 0;
        int ch, flag;

        for (int i = 0; i < n; i++) {
            System.out.print(" " + i);
        }
        System.out.println(" " + 0);

        do {
            System.out.print("Enter sender: ");
            int s = scan.nextInt();
            System.out.print("Enter receiver: ");
            int r = scan.nextInt();
            System.out.print("Enter Data: ");
            int data = scan.nextInt();

            System.out.print("Token passing:");
            for (int i = token, j = token; (i % n) != s; i++, j = (j + 1) % n) {
                System.out.print(" " + j + "->");
            }
            System.out.println(" " + s);

            System.out.println("Sender " + s + " sending data: " + data);

            for (int i = (s + 1) % n; i != r; i = (i + 1) % n) {
                System.out.println("Data " + data + " forwarded by " + i);
            }

            System.out.println("Receiver " + r + " received data: " + data);

            token = s;

            flag = 0;
            do {
                try {
                    if (flag == 1)
                        System.out.println("Invalid input! Please try again.");

                    System.out.print("Do you want to send again? Enter 1 for Yes and 0 for No: ");
                    ch = scan.nextInt();

                    if (ch != 1 && ch != 0)
                        flag = 1;
                    else
                        flag = 0;
                } catch (Exception e) {
                    System.out.println("Invalid input! Please try again.");
                    scan.nextLine(); // Clear input buffer
                    ch = -1; // Set an invalid value to repeat the loop
                }
            } while (ch != 1 && ch != 0);

        } while (ch == 1);

        System.out.println("Token ring program terminated.");
    }
}

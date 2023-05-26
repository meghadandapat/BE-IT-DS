import java.util.Scanner;

public class BullyAlgorithm {
    static int[] state = new int[5];
    static int coordinator;

    public static void up(int up) {
        if (state[up - 1] == 1) {
            System.out.println("Process " + up + " is already up.");
        } else {
            state[up - 1] = 1;
            System.out.println("Process " + up + " initiated an election.");

            // Send election messages to higher-numbered processes
            for (int i = up + 1; i <= 5; i++) {
                if (state[i - 1] == 1) {
                    sendMessage(up, i, "ELECTION");
                }
            }

            // Receive alive messages from lower-numbered processes
            for (int i = up - 1; i >= 1; i--) {
                if (state[i - 1] == 1) {
                    System.out.println("Alive message received from process " + i + " by process " + up);
                    break;
                }
            }

            // Set the coordinator to the highest-numbered process that responded
            coordinator = up;
            System.out.println("Process " + coordinator + " is the coordinator.");
        }
    }

    public static void down(int down) {
        if (state[down - 1] == 0) {
            System.out.println("Process " + down + " is already down.");
        } else {
            state[down - 1] = 0;
            System.out.println("Process " + down + " is down.");

            // If the coordinator process is down, start a new election
            if (coordinator == down) {
                for (int i = 1; i <= 5; i++) {
                    if (state[i - 1] == 1) {
                        up(i);
                        break;
                    }
                }
            }
        }
    }

    public static void sendMessage(int sender, int receiver, String message) {
        System.out.println("Message sent from process " + sender + " to process " + receiver + ": " + message);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        coordinator = 5;

        do {
            System.out.println("---------");
            System.out.println("1. Up a process.");
            System.out.println("2. Down a process.");
            System.out.println("3. Exit.");
            System.out.println("---------");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Bring up a process: ");
                    int up = sc.nextInt();
                    up(up);
                    break;
                case 2:
                    System.out.println("Bring down a process: ");
                    int down = sc.nextInt();
                    down(down);
                    break;
            }
        } while (choice != 3);
    }
}





import java.util.Scanner;

/**
 *
 * @author prasad
 */
public class Bully {

    /**
     * @param args the command line arguments
     */
    static boolean state[]  = new boolean[5];
    int coordinator;
    public static void up(int up)
    {
        if(state[up-1]==true)
        {
            System.out.println("process"+up+"is already up");
        }
        else
        {
            state[up-1] = true;
            System.out.println("process "+up+"held election");
            for(int i=up;i<5;i++)
            {
                System.out.println("election message sent from process"+up+"to process"+(i+1));
            }
            for(int i=up+1;i<=5;i++)
            {
                if(state[i-1]==true)
                {
                   System.out.println("alive message send from process"+i+"to process"+up);
                   break;
                }
            }
        }
    }
    public static void down(int down)
    {
        if(state[down-1]==false)
        {
            System.out.println("process "+down+"is already dowm.");
        }
        else
        {
            state[down-1] = false;
            
        }
    }
    
    public static void mess(int mess)
    {
        if(state[mess-1]==true)
        {
            if(state[4]==true)
            {
                System.out.println("0K");
            }
            else
            {
                if(state[4]==false)
                {
                System.out.println("process"+mess+"election");
                for(int i=mess;i<5;i++)
                {
                    System.out.println("election send from process"+mess+"to process "+(i+1));
                }
            
            for(int i=5;i>=mess;i--)
            {
                if(state[i-1]==true)
                {
                    System.out.println("Coordinator message send from process"+i+"to all");
                    break;
                }
            }
            }
        }
    }
        else
        {
            System.out.println("Prccess"+mess+"is down");
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int choice;
        for(int i=0;i<5;i++)
        {
            state[i] = true;
        }
        System.out.println("5 active process are:");
        System.out.println("Process up  = p1 p2 p3 p4 p5");
        System.out.println("Process 5 is coordinator");
        
        do
        {
            System.out.println(".........");
            System.out.println("1 up a process.");
            System.out.println("2.down a process");
            System.out.println("3 send a message");
            System.out.println("4.Exit");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                {
                    System.out.println("bring proces up");
                    int up = sc.nextInt();
                    if(up==5)
                    {
                        System.out.println("process 5 is co-ordinator");
                        state[4] = true;
                        
                    }
                    else
                    {
                        up(up);
                    }
                }
                break;
                case 2:
                {
                    System.out.println("bring down any process.");
                    int down = sc.nextInt();
                    down(down);
                }
                break;
                case 3:
                {
                    System.out.println("which process will send message");
                    int mess = sc.nextInt();
                    mess(mess);
                }
                break;
                
            }
            
        }
        while(choice!=4);
    }
    
}

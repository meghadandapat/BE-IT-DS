import java.io.*;
import java.lang.*;
 
class Tring {
 public static void main(String args[]) throws Throwable {
  DataInputStream dis = new DataInputStream(System.in);
  System.out.println("Enter the num of nodes:");
  int n = Integer.parseInt(dis.readLine());
  // Decides the number of nodes forming the ring
  int token = 0;
  int ch = 1;
  for (int i = 0; i < n; i++)
   System.out.print(" " + i);
  System.out.println(" " + 0);
  try {
   while (ch == 1) {
    System.out.println("Enter sender:");
    int s = Integer.parseInt(dis.readLine());
    System.out.println("Enter receiver:");
    int r = Integer.parseInt(dis.readLine());
    System.out.println("Enter Data:");
    String d = dis.readLine();
    System.out.print("Token passing:");
    for (int i = token; i != s; i++)
     System.out.print(" " + i + "->");
    System.out.println(" " + s);
    System.out.println("Sender " + s + "sending data: " + d);
    for (int i = s + 1; i != r; i = (i + 1) % n)
     System.out.println("data  " + d + " forwarded by " + i);
    System.out.println("Receiver " + r + "received data: " + d);
    token = s;
 
   }
  } catch (Exception e) {
  }
 }
}

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception{
        
        //Creating a port for communication
        ServerSocket ss = new ServerSocket(5555);
        System.out.println("Server Initiated, Waiting for Client to Connect...");

        //Binding Client and Server on port 5555
        Socket s = ss.accept();
        System.out.println("Client Connected");

        //Reading input from KeyBoard
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //OutputStream object to write to clients
        OutputStream ostream = s.getOutputStream();

        //PrintWriter object to send the data to the outputstream 
        PrintWriter pw = new PrintWriter(ostream,true);

        //InputStream objects to recieve from Client
        InputStream istream = s.getInputStream();

        //Reading receieved message from client
        BufferedReader recieve = new BufferedReader(new InputStreamReader(istream));

        //Client Message and Server Message objects
        String servermessage = "";
        String clientmessage = "";

        while(true)
        {
            //Read the inputstream of the client from the socket
            clientmessage = recieve.readLine();
            System.out.println("Client: "+clientmessage);

            //if the message is bye end the communication here
            if(clientmessage.equals("bye"))
            {
                break;
            }
            
            //Server writing its message
            System.out.print("Server: ");
            servermessage = br.readLine();

            //print writer object sending the message to the socket through outputstream
            pw.println(servermessage);
            if(servermessage.equals("bye"))
            {
                break;
            }
        }

        //closing all the streams and sockets
        s.close();
        ss.close();
        istream.close();
        ostream.close();

        System.out.println("Connection Terminated");
    }    
}




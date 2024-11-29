import java.io.*;
import java.net.*;

public class Main {
    public static void main(String args[]) throws IOException
    {
        // create a socket to connect to the server running  at port number 9090
        Socket socket = new Socket("10.130.1.124", 31124);
       
        // Setup output stream to send data to the server
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
       
        // Setup input stream to receive data from the server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Send message to the server
        out.println("ciaoooo galielo galidiego");

        // Receive response from the server
        String response = in.readLine();
        System.out.println("Server says: " + response);
        
        // Chiusura della comunicazione
        out.println("exit");

        // Close the socket
        socket.close();
    }
}


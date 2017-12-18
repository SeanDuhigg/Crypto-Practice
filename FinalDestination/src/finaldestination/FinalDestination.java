package finaldestination;
import java.net.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author Homework
 */
//This program just acts as a destination for a crowds message. 
//It will wait on port 55005 and give you the output of the message sent
//and send back a confirmation message
public class FinalDestination {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Socket socket;
       
        try{
           
            int port = 55005;
            ServerSocket incSocket = new ServerSocket(port);
            System.out.println("Server listening on port 55005");
            while(true){
                socket = incSocket.accept();
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
            

                // Get the message from the sender
                String message = br.readLine();       
                System.out.println("Anonymous message: "+message);
                
               
                
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                PrintWriter pw = new PrintWriter(osw, true);
                pw.println("Received!");
                System.out.println("Message confirmed to sender");
                pw.flush();
                pw.close();
                socket.close();
            }
           
        }catch(Exception e){e.printStackTrace();}
        
       
    }
}  
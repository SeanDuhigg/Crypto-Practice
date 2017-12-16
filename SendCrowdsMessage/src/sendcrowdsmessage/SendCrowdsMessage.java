package sendcrowdsmessage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author Sean
 */
public class SendCrowdsMessage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int portNumber;
        String hostName = "127.0.0.1";
        Socket myClientSocket;
        System.out.println("Enter the hostname of the Computer to connect: 127.0.0.1 ");
        //Scanner scanner = new Scanner(System.in);
        //String hostName = scanner.nextLine();

        System.out.println("Enter the port number:  ");
        Scanner scannerPort = new Scanner(System.in);
        portNumber = scannerPort.nextInt();
        
        System.out.println("Enter a message that includes destination in the format message/host/port");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        
        try{

            myClientSocket = new Socket(hostName, portNumber);   //connect
            OutputStream os = myClientSocket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            
            bw.write(message);
            bw.flush();
            bw.close();
            
            InputStream is = myClientSocket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            

                // Get the message from the sender
            message = br.readLine();
            System.out.println(message);

        }catch(Exception e){}
        
    }
       
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdsblender;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;
/**
 *
 * @author Sean
 */
public class CrowdsBlender {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        int portNumber;
        Socket myClientSocket;
        ServerSocket myServerSocket;
        
        System.out.print("Enter the socket of this Server: ");
        Scanner scanner = new Scanner(System.in);
        portNumber = scanner.nextInt();    
        
        
        try{
    
            myServerSocket = new ServerSocket(portNumber);
            myClientSocket = myServerSocket.accept();
            
            InputStream is = myClientSocket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            PrintWriter out = new PrintWriter(myClientSocket.getOutputStream(), true);
            //BufferedReader in = new BufferedReader(new InputStreamReader(myClientSocket.getInputStream())); 
            
            String message = br.readLine();
            
            System.out.println("Message created from client "+ message);
            scanner = new Scanner(System.in);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
    }
    
}

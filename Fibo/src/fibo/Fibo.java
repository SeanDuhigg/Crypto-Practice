
package fibo;
import java.util.*;
/**
 *
 * @author Sean
 */
public class Fibo {

   
    public static void main(String[] args) {
        System.out.print("Give me a value to iterate the fibonacci sequence up to:");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(fib(n));
      
    }
    
    //Dynamic programming iterative method to calculate fibonacci sequence values
    //I'm starting at 1 rather than 0 but both are mathematically correct
    public static int fib(int n){
        int[] fib = new int[n+2];
        
        fib[0]=1;
        fib[1]=1;
        
        for(int x=2;x<=n;x++){
            fib[x]=fib[x-1]+fib[x-2];
        //System.out.print(" "+fib[x]);
        }
        
        return fib[n-1];
    }
    
}

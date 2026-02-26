import java.net.*;
import java.io.*;

public class IPFinder {
    public static void main(String[] args) {
        String host;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter hostname: ");
        try {
            host = br.readLine();
            InetAddress address = InetAddress.getByName(host);
            System.out.println(address.toString());
        } catch (UnknownHostException e) {
            System.out.println("Error: " + e);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

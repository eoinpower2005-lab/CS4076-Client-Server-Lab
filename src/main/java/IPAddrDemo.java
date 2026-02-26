import java.net.*;

public class IPAddrDemo {
    public static void main(String[] args) {
        System.out.println("Looking up the IP address of the local host");
        try {
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("IP address of this machine: " + localAddress.getHostAddress());
        } catch (Exception e) {
            System.out.println("Error - unable to resolve local host");
        }
    }
}

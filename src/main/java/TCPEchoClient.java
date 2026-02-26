import java.io.*;
import java.net.*;

public class TCPEchoClient {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader sInput = null;
        PrintWriter sOutput = null;
        BufferedReader keyboardInput = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 1234);
            System.out.println("Connected to server");
            sInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            sOutput = new PrintWriter(socket.getOutputStream(), true);
            keyboardInput = new BufferedReader(new InputStreamReader(System.in));

            String message;
            while (true) {
                message = keyboardInput.readLine();
                if (message.equals("quit")) {
                    break;
                }
                sOutput.println(message);
                String response = sInput.readLine();
                System.out.println(response);
            }
            System.out.println("Connection closed.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (keyboardInput != null) {
                    keyboardInput.close();
                }
                if (sInput != null) {
                    sInput.close();
                }
                if (sOutput != null) {
                    sOutput.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

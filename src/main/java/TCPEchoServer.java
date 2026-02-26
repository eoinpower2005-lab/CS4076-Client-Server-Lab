import java.io.*;
import java.net.ServerSocket;
import java.net.*;

public class TCPEchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket servSock = new ServerSocket(1234);
            System.out.println("Listening on port 1234");

            while (true) {
                Socket socket = servSock.accept();
                Thread t = new Thread(new Runnable() {
                    public void run() {
                        try {
                            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

                            String message;
                            while ((message = input.readLine()) != null) {
                                System.out.println("Client message: " + message);
                                output.println("Echo: " + message);
                            }
                            System.out.println("Client Disconnected.");
                            socket.close();
                        } catch (IOException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                });
                t.start();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
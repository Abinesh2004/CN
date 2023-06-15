import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class TCPClient_d {
  private static final String SERVER_ADDRESS = "localhost";
  private static final int SERVER_PORT = 12345;
  public static void main(String[] args) {
    try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT); DataInputStream dataInputStream = new DataInputStream(socket.getInputStream()); DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream())) {
      Scanner scanner = new Scanner(System.in);
      // Get the file name from the user
      System.out.print("Enter file name: ");
      String fileName = scanner.nextLine();
      // Send the file name to the server
      dataOutputStream.writeUTF(fileName);
      File f = new File("server_" + fileName + ".txt");
      PrintWriter pw = new PrintWriter(new FileWriter(f));
      // Receive and display file contents from the server
      String line;
      try {
        while ((line = dataInputStream.readUTF()) != null) {
          pw.println(line);
          System.out.println(line);
        }
      } catch (Exception e) {
        int cnt = 0;
        cnt++;
        pw.close();
      }
    } catch (Exception e) {
      int cnt = 0;
      cnt++;
    }
  }
}

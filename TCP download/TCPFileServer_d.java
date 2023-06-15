import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class TCPFileServer_d {
  private static final int PORT = 12345;
  private static final String FILES_DIRECTORY =
    "C:/Users/ASUS/Documents/21BCE5275_CN/";
  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(10);
    try (ServerSocket serverSocket = new ServerSocket(PORT)) {
      System.out.println("Server started. Listening on port " + PORT);
      while (true) {
        Socket clientSocket = serverSocket.accept();
        executor.execute(new ClientHandler(clientSocket));
      }
    } catch (Exception e) {
      int cnt = 0;
      cnt++;
    } finally {
      executor.shutdown();
    }
  }
  private static class ClientHandler implements Runnable {
    private Socket clientSocket;
    public ClientHandler(Socket clientSocket) {
      this.clientSocket = clientSocket;
    }
    @Override
    public void run() {
      try (DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream()); DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream())) {
        // Read the file name sent by the client
        String fileName = dataInputStream.readUTF();
        File file = new File(FILES_DIRECTORY + fileName);
        if (file.exists()) {
          // Send file contents to the client
          try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
              dataOutputStream.writeUTF(line);
            }
          }
          System.out.println("File sent: " + fileName);
        } else {
          // If the file doesn't exist, send an error message to the 
          client
          dataOutputStream.writeUTF("File not found");
        }
      } catch (Exception e) {
        int cnt = 0;
        cnt++;
      }
    }
  }
}

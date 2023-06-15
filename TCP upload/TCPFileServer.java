import java.io.*;
import java.net.*;
import java.util.*;
class Child implements Runnable
{
  Socket cs;
  int count;
  Child(Socket c,int co){
  cs = c;
  count = co;
}
  public void run(){
    try{
    DataInputStream dis;
    File f=new File("client"+count+".txt");
    PrintWriter pw=new PrintWriter(new FileWriter(f));
    dis = new DataInputStream(cs.getInputStream());
    String st;
    try
    {
      while((st=dis.readUTF())!=null)
      {
      pw.println(st);
      }
    }
    catch(Exception e)
    {
    System.out.println("File received from client"+count);
    }
    pw.close();
  }
  catch(Exception e){
  int cnt = 0;
  cnt++;
  }
  }
}
class TCPFileServer
{
  public static void main(String str[]) throws Exception
  {
  int count=0;
  ServerSocket ss=new ServerSocket(10000);
  Socket cs;
  Child c;
  System.out.println("The Server has started.\n");
  while(true)
  {
  cs=ss.accept();
  ++count;
  c = new Child(cs,count);
  Thread t = new Thread(c);
  t.start();
  System.out.println("client"+count+" connected");
  }
}

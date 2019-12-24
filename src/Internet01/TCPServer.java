package Internet01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author:wangxue
 * @date:2019/12/8 17:08
 */
public class TCPServer {
    private static final int PORT=9999;
    public static void main(String[] args) throws IOException {
        //创建服务端
        ServerSocket server=new ServerSocket(PORT);
        //接收客户端
        //阻塞式方法
        Socket socket=server.accept();
        //输入流
        InputStream inputStream=socket.getInputStream();
        InputStreamReader isr=new InputStreamReader(inputStream);
        BufferedReader br=new BufferedReader(isr);
        //输出流
        OutputStream os=socket.getOutputStream();
        PrintWriter pw=new PrintWriter(os,true);
        String s=null;
        //readLine()也是阻塞式方法
        while((s=br.readLine())!=null){
            System.out.println(s);
            pw.println("已经收到数据"+s);
        }
        br.close();
        isr.close();
        inputStream.close();
        server.close();
    }
}

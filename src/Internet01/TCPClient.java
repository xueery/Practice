package Internet01;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/8 17:15
 */
public class TCPClient {
    private static final String HOST="localHost";
    private static final int PORT=9999;
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket(HOST,PORT);
        //输出流
        OutputStream os=socket.getOutputStream();
        PrintWriter pw=new PrintWriter(os,true);
        //输入流
        InputStream is=socket.getInputStream();
        //字节字符转换流
        InputStreamReader isr=new InputStreamReader(is);
        BufferedReader br=new BufferedReader(isr);
        //pw.println("Hello");
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s=scanner.nextLine();
            pw.println(s);
            String content=br.readLine();
            System.out.println(content);
        }
        pw.close();
        os.close();
        socket.close();
    }
}

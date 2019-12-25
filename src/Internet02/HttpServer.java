package Internet02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:wangxue
 * @date:2019/12/11 21:02
 */
public class HttpServer {
    private static final int PORT=9999;
    //获取处理器的核数
    private static final int COUNT=Runtime.getRuntime().availableProcessors();
    //创建线程池（使用处理器核数作为运行的线程数）
    //处理的任务量和线程数量、CPU、内存等资源都相关，一般推荐禹处理器核数相同的线程
    private static final ExecutorService EXE= Executors.newFixedThreadPool(COUNT);
    public static void main(String[] args) {
        try {
            ServerSocket server=new ServerSocket(PORT);
            while (true){
                Socket socket=server.accept();
                EXE.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            InputStream is=socket.getInputStream();
                            InputStreamReader isr=new InputStreamReader(is);
                            BufferedReader br=new BufferedReader(isr);
                            //处理请求行
                            String requestLine=br.readLine();
                            String[] requestLines=requestLine.split(" ");
                            Request request=new Request();
                            request.setMethod(requestLines[0]);
                            request.setUrl(requestLines[1]);
                            request.setVersion(requestLines[2]);
                            //处理请求头
                            String requestHeader;
                            while((requestHeader=br.readLine())!=null && requestHeader.length()!=0){
                                String[] header=requestHeader.split(":");
                                request.addHeader(header[0],header[1].trim());
                            }
                            System.out.println(request);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

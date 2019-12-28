package Internet03;


import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:wangxue
 * @date:2019/12/15 16:40
 */
public class Request {
    private String method;//请求方法
    private String url;//请求url
    private String version;//请求版本
    private Map<String,String> headers=new HashMap<>();//请求头
    private Map<String,String> parameters=new HashMap<>();//请求参数?
    //添加请求头
    public void addHeader(String key,String value){
        headers.put(key,value);
    }

    //获取请求头
    public String getHeader(String key){
        return headers.get(key);
    }

    @Override
    public String toString() {
        return "Request{" +
                " \nmethod='" + method + '\'' +
                ",\n url='" + url + '\'' +
                ",\n version='" + version + '\'' +
                ",\n headers=" + headers +
                ",\n parameters=" + parameters +
                '}';
    }

    public void parseParameters(String parameters){
        String[] ps=parameters.split("&");
        for(String p:ps){
            String[] array=p.split("=");
            addParameter(array[0],array[1]);
        }
    }


    //添加请求参数
    public void addParameter(String key,String value){
        parameters.put(key,value);
    }

    //获取请求参数
    public String getParameter(String key){
        return parameters.getOrDefault(key,null);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, String> getHeraders() {
        return headers;
    }

    public void setHeraders(Map<String, String> heraders) {
        this.headers = heraders;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}

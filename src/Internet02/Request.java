package Internet02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:wangxue
 * @date:2019/12/11 21:22
 */
public class Request {
    private String method;//请求方法
    private String url;//请求路径
    private String version;//请求http版本号
    private Map<String,String> headers=new HashMap<>();//请求头

    /**
     * 将请求头的信息存入map
     * @param key
     * @param values
     */
    public void addHeader(String key,String values){
        headers.put(key,values);
    }

    /**
     * 根据请求头的名称获取值
     * @param key
     */
    public String getHeader(String key){
       return headers.get(key);
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

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", version='" + version + '\'' +
                ", headers=" + headers +
                '}';
    }
}

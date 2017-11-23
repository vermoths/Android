package com.first.vermoths.logintoserver;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Vermoths on 2017/5/9.
 */

public class LoginService {
    //使用HttpURLConnection   GET方式提交数据
    public static String loginByGet(String username, String password) {
        try {
            //拼装URL 注意为了防止乱码 这里需要将参数进行编码
            String path = "http://192.168.204.2:8080/web/LoginServlet?username="
                    + URLEncoder.encode(username, "UTF-8")
                    + "&password="
                    + URLEncoder.encode(password);
            //创建URL实例
            URL url = new URL(path);
            //获取HttpURLConnection对象
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);        //设置超时时间
            conn.setRequestMethod("GET");        //设置访问方式
            int code = conn.getResponseCode(); //拿到返回的状态码
            if (code == 200) {                    // 请求成功
                InputStream is = conn.getInputStream();
                String text = StreamTools.readInputStream(is);
                return text;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //使用HttpURLConnection  POST方式提交数据
    public static String loginByPost(String username, String password) {
        try {
            //要访问的资源路径
            String path = "http://192.168.204.2:8080/web/LoginServlet";
            //创建URL的实例
            URL url = new URL(path);
            //获取HttpURLConnection对象
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置超时时间
            conn.setConnectTimeout(5000);
            //指定请求方式
            conn.setRequestMethod("POST");
            //准备数据 将参数编码
            String data = "username=" + URLEncoder.encode(username)
                    + "&password=" + URLEncoder.encode(password);
            //设置请求头
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", data.length() + "");
            //将数据写给服务器
            conn.setDoOutput(true);
            //得到输出流
            OutputStream os = conn.getOutputStream();
            os.write(data.getBytes());           //将数据写入输出流中
            int code = conn.getResponseCode(); //那到服务器返回的状态码
            if (code == 200) {
                //得到服务器返回的输入流
                InputStream is = conn.getInputStream();
                //将输入流转换成字符串
                String text = StreamTools.readInputStream(is);
                return text;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}

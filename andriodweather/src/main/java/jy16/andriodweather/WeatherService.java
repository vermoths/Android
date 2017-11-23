package jy16.andriodweather;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Vermoths on 2017/10/20.
 */

public class WeatherService {
//    //解析xml文件返回天气集合
//    public static List<WeatherInfo> getInfosFormXML(InputStream is)
//        throws Exception{
//        //获取解析器pull
//        XmlPullParser parser= Xml.newPullParser();
//        //初始化解析器，开始解析
//        parser.setInput(is,"UTF-8");
//        List<WeatherInfo> weatherInfos = null;
//        WeatherInfo weatherInfo = null;
//
//        //获取事件类型
//        int type=parser.getEventType();
//        //while循环判断xml文档有没有结束
//
//        while (type!=XmlPullParser.END_DOCUMENT){
//            switch (type){
//                //用来判断节点类型，不同类型写入不同的集合值
//                case XmlPullParser.START_TAG:
////                    //解析到全局开始的标签 infos 根节点
//                    if("infos".equals(parser.getName())){
//                        weatherInfos = new ArrayList<WeatherInfo>();
//                    }else if("city".equals(parser.getName())){
//                        weatherInfo = new WeatherInfo();
//                        String idStr = parser.getAttributeValue(0);
//                        weatherInfo.setId(idStr);
//                    }else if("temp".equals(parser.getName())){
//                        //parset.nextText()得到该tag节点中的内容
//                        String temp = parser.nextText();
//                        weatherInfo.setTemp(temp);
//                    }else if("weather".equals(parser.getName())){
//                        String weather = parser.nextText();
//                        weatherInfo.setWeather(weather);
//                    }else if("name".equals(parser.getName())){
//                        String name = parser.nextText();
//                        weatherInfo.setName(name);
//                    }else if("pm".equals(parser.getName())){
//                        String pm = parser.nextText();
//                        weatherInfo.setPm(pm);
//                    }else if("wind".equals(parser.getName())){
//                        String wind = parser.nextText();
//                        weatherInfo.setWind(wind);
//                    }
//                    break;
//                case XmlPullParser.END_TAG:
//                    //说明城市标签处理结束
//                    if("city".equals(parser.getName())){
//                        weatherInfos.add(weatherInfo);
//                        weatherInfo=null;
//                    }
//                    break;
//            }
//            type=parser.next();
//        }
//return  weatherInfos;

//    }
//解析Json文件并返回天气集合
public static List<WeatherInfo> getInfosFormJson(InputStream is)
       throws Exception{
    byte[] buffer = new byte[is.available()];
    is.read(buffer);
    String json=new String(buffer,"utf-8");
//使用GSON库进行解析
    Gson gson=new Gson();
    Type listType=new TypeToken<List<WeatherInfo>>(){}.getType();
    List<WeatherInfo> weatherInfos = gson.fromJson(json,listType);
    return  weatherInfos;
       }


}

package com.first.vermoths.plant;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vermoths on 2017/3/15.
 */

public class Util {
    // 返回植物信息的集合
    public static List<PlantInfo> getPlantInfos(InputStream is) throws Exception {
        // 得到pull解析器
        XmlPullParser parser = Xml.newPullParser();
        // 初始化解析器,第一个参数代表包含xml的数据
        parser.setInput(is, "utf-8");
        List<PlantInfo> plantInfos = null;
        PlantInfo plantInfo = null;
        // 得到当前事件的类型
        int type = parser.getEventType();
        // END_DOCUMENT文档结束标签
        while (type != XmlPullParser.END_DOCUMENT) {
            switch (type) {
                // 一个节点的开始标签
                case XmlPullParser.START_TAG:
                    // 解析到全局开始的标签 infos 根节点
                    if ("plants".equals(parser.getName())) {
                        plantInfos = new ArrayList<PlantInfo>();
                    } else if ("plantsInfo".equals(parser.getName())) {
                        plantInfo = new PlantInfo();
                    } else if ("name".equals(parser.getName())) {
                        // parset.nextText()得到该tag节点中的内容
                        String name = parser.nextText();
                        plantInfo.setPlantName(name);
                    } else if ("content".equals(parser.getName())) {
                        String content = parser.nextText();
                        plantInfo.setPlantContent(content);
                    }
                    break;
                // 一个节点结束的标签
                case XmlPullParser.END_TAG:

                    if ("plantsInfo".equals(parser.getName())) {

                        plantInfos.add(plantInfo);
                        plantInfo = null;
                    }
                    break;
            }
            // 只要不解析到文档末尾，就解析下一个条目。得到下一个节点的事件类型

            type = parser.next();
        }
        return plantInfos;
    }

}

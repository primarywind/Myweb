package com.myweb.util;

import java.text.DecimalFormat;

/**
 * 
 * @author huleiwind
 * @version $Id: HandlerPath.java, v 0.1 2015-12-6 下午6:01:39 huleiwind Exp $
 */
public class HandlerPath {
    private static String webappsPath = System.getProperty("catalina.home");
    public static String  hostPath    = "http://localhost:8080";

    public static String getHostSimulateAuthorLogoPath() {
        return webappsPath + "/webapps/Myweb/upload/picture/";
    }

    public static String getPicturePath() {
        return "/Myweb/upload/picture/";
    }

    public static String FormetFileSize(long fileS) {//转换文件大小
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }
}
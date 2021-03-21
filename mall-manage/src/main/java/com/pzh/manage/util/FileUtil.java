package com.pzh.manage.util;

import com.pzh.manage.common.ResultMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
    private static final Logger lOGGER = LoggerFactory.getLogger(FileUtil.class);

    public static ResultMsg uploadFile(MultipartFile file, String baseUrl, String fileUrl) throws IOException {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        fileUrl += df.format(new Date()) + "/";
        //生成上传目录
        File fileDir = new File(baseUrl + fileUrl);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        String ext = FileUtil.getExtension(file.getOriginalFilename());
        String curTimeMillis = String.valueOf(System.currentTimeMillis());
        String fileName = curTimeMillis + "." + ext;

        try {
            // 上传文件
            File storeFile = new File(baseUrl + fileUrl + fileName);
            file.transferTo(storeFile);

            return new ResultMsg(0, fileUrl + fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(-1, "error");
        }
    }

    /**
     * 获取文件扩展
     * @param fileName
     * @return
     */
    public static String getExtension(String fileName) {
        int newEnd = fileName.length();
        int i = fileName.lastIndexOf('.', newEnd);
        if (i != -1) {
            return fileName.substring(i + 1, newEnd).toLowerCase();
        }
        return null;
    }
    
    public static void downloadFile(HttpServletRequest request, HttpServletResponse response, String filePathWithName, String fileName) {
        lOGGER.info("文件下载...");
    }

}

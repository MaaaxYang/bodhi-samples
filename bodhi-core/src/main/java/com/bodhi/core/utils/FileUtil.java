package com.bodhi.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @program: bodhi-samples
 * @description:
 * @author: Maxxx.Yg
 * @create: 2019-02-25 22:50
 **/
public class FileUtil {

    public static byte[] readClass(String name) throws Exception{
        URL clazzURL =Thread.currentThread().getContextClassLoader().getResource(name);
        byte[] bytes= null;

        File file = new File(clazzURL.toURI());
        if (file.exists()){
            FileInputStream is = new FileInputStream(file);
            bytes=new byte[(int)file.length()];
            try {
                is.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bytes;
    }
}

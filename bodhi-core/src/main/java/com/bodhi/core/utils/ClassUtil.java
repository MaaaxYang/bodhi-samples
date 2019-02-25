package com.bodhi.core.utils;

import com.bodhi.core.MyClassLoader;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @program: bodhi-samples
 * @description:
 * @author: Maxxx.Yg
 * @create: 2019-02-25 22:15
 **/
public class ClassUtil {

    public static <T> T loadClassByFilePath(String filePath,String className) throws Exception{
        URL url = new File(filePath).toURI().toURL();
        URLClassLoader loader = new URLClassLoader(new URL[]{url});
        Class clz = Class.forName(className,true,loader);
        T obj = (T) clz.newInstance();
        return obj;
    }

    public static <T> T loadClassByApi(String className) throws Exception{
        MyClassLoader loader = new MyClassLoader();
        Class clz = Class.forName(className,true,loader);
        T obj = (T) clz.newInstance();
        return obj;
    }

}

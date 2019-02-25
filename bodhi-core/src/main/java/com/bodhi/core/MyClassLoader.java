package com.bodhi.core;

import com.bodhi.core.utils.OKHttpUtil;

import java.io.IOException;

/**
 * @program: bodhi-samples
 * @description:
 * @author: Maxxx.Yg
 * @create: 2019-02-25 22:43
 **/
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        byte[] clazzBytes = null;
        try {
            clazzBytes = OKHttpUtil.getClassFile(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        clazz = defineClass(name,clazzBytes,0,clazzBytes.length);
        if (clazz==null){
            clazz = super.findClass(name);
        }
        return clazz;
    }

}


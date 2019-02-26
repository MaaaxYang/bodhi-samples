package com.bodhi.core;

import com.bodhi.core.utils.JavaSerializer;
import com.bodhi.core.utils.OKHttpUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: bodhi-samples
 * @description:
 * @author: Maxxx.Yg
 * @create: 2019-02-26 13:49
 **/
public class MapClassloader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class mainClass = null;
        Map<String,byte[]> map = new HashMap<>();
        byte[] mapBytes = null;
        try {
            mapBytes = OKHttpUtil.getClassMap(name);
            map = JavaSerializer.deSerialize(mapBytes,new HashMap<String,byte[]>().getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Map.Entry<String,byte[]> entry : map.entrySet()){
            System.out.println(entry.getKey()+ " loading..");
            Class clazz = defineClass(entry.getKey(),entry.getValue(),0,entry.getValue().length);
            if (name.equals(entry.getKey())){
                mainClass = clazz;
            }
        }
        if (mainClass==null){
            mainClass = super.findClass(name);
        }
        return mainClass;
    }

}

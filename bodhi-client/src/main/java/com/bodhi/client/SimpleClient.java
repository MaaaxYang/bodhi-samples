package com.bodhi.client;

import com.bodhi.core.ICar;
import com.bodhi.core.utils.ClassUtil;

/**
 * @program: bodhi-samples
 * @description:
 * @author: Maxxx.Yg
 * @create: 2019-02-25 22:14
 **/
public class SimpleClient {

    public static void main2(String[] args) throws Exception{
        ClassUtil.loadClassByApi("com.bodhi.server.Driver");
        ICar car = ClassUtil.loadClassByApi("com.bodhi.server.Benz");
        car.run();
    }

    public static void main(String[] args) throws Exception{
        Object obj = ClassUtil.loadClassByFilePath(
                "/Users/yanghaoran/coding/bodhi/lib/bodhi-server-1.0-SNAPSHOT.jar",
                "com.bodhi.server.Driver");
        Class cls = obj.getClass();
    }
}

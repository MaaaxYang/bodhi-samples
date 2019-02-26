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

    public static void main1(String[] args) throws Exception{
        ClassUtil.loadClassByApi("com.bodhi.server.Driver");
        ICar car = ClassUtil.loadClassByApi("com.bodhi.server.Benz");
        car.run();
    }

    public static void main(String[] args) throws Exception{
        ICar car = ClassUtil.loadClassPackageByApi("com.bodhi.server.Benz");
        car.run();
    }

    public static void main2(String[] args) throws Exception{
        Object obj = ClassUtil.loadClassByFilePath(
                "/Users/yanghaoran/coding/bodhi/lib/hmily-core.jar",
                "org.dromara.hmily.core.logo.HmilyLogo");
        Class cls = obj.getClass();
    }
}

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

    public static void main(String[] args) throws Exception{
        ClassUtil.loadClassByApi("com.bodhi.server.Driver");
        ICar car = ClassUtil.loadClassByApi("com.bodhi.server.Benz");
        car.run();
    }
}

package com.bodhi.server;

import com.bodhi.core.ICar;

/**
 * @program: bodhi-samples
 * @description:
 * @author: Maxxx.Yg
 * @create: 2019-02-25 22:12
 **/
public class Benz implements ICar {

    @Override
    public void run() {
        Driver driver = new Driver();
        driver.drive();
        System.out.println("Benz Car run ...");
    }
}

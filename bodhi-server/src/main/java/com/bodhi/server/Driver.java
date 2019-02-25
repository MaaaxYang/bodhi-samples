package com.bodhi.server;

import java.io.Serializable;

/**
 * @program: bodhi-samples
 * @description:
 * @author: Maxxx.Yg
 * @create: 2019-02-25 22:54
 **/
public class Driver implements Serializable {

    private static final long serialVersionUID = -7992529427882334772L;

    public void drive(){
        System.out.println("驾驶员驾驶一辆汽车");
    }

}

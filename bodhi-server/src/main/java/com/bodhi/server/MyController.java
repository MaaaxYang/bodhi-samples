package com.bodhi.server;

import com.bodhi.core.utils.FileUtil;
import com.bodhi.core.utils.JavaSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: bodhi-samples
 * @description:
 * @author: Maxxx.Yg
 * @create: 2019-02-25 22:48
 **/
@RestController
@RequestMapping("/my")
public class MyController {

    @GetMapping("/class/{name}")
    public void getClass(@PathVariable String name, HttpServletResponse response) throws Exception{
        name = name.replace(".","/")+".class";
        response.getOutputStream().write(FileUtil.readClass(name));
    }


    @GetMapping("/class/map/{code}")
    public void getClassMap(@PathVariable String code, HttpServletResponse response)throws Exception
    {

        if ("com.bodhi.server.Benz".equals(code)){
            Map<String,byte[]> map = new HashMap<>();
            String benzName = Benz.class.getCanonicalName().replace(".","/")+".class";
            map.put(Benz.class.getCanonicalName(),FileUtil.readClass(benzName));

            String driverName = Driver.class.getCanonicalName().replace(".","/")+".class";
            map.put(Driver.class.getCanonicalName(),FileUtil.readClass(driverName));

            response.getOutputStream().write(JavaSerializer.serialize(map));
        }

    }


}

package com.bodhi.server;

import com.bodhi.core.utils.FileUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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

}

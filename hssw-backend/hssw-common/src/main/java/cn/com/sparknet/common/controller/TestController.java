package cn.com.sparknet.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.sparknet.common.util.StringUtil;
import cn.com.sparknet.common.service.DashboardService;

@Controller
@RequestMapping("/TestController")
public class TestController {

    /**
     * test
     * @param
     * @return stringTest
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/stringTest")
    public String stringTest(HttpServletRequest request, HttpServletResponse response){
        //echarts - line
        //获取getJSON方法传递的参数callBack
        String stringTest = "aaa";
        //查询所有错误类型
        return stringTest;
    }
}

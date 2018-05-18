package cn.com.sparknet.common.controller;

import cn.com.sparknet.common.json.EditJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.sparknet.common.util.StringUtil;
import cn.com.sparknet.common.service.DashboardService;

@Controller
@RequestMapping("/DashboardController")
public class DashboardController {

    @Resource
    private DashboardService dashboardService;

    /**
     * data of line， 首页echarts - line 省级数据加载
     * @param request
     * @return url with json
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/jsonLine")
    public String jsonLine(HttpServletRequest request, HttpServletResponse response){
        //echarts - line
        //获取getJSON方法传递的参数callBack
        String errorType = StringUtil.nullToEmpty(request.getParameter("errorType"));
        //查询所有错误类型
        return dashboardService.jsonLine(errorType);
    }

    /**
     * data of line， 首页echarts - line 省级数据加载
     * @param request
     * @return url with json
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

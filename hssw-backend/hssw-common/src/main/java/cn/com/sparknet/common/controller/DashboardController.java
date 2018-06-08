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

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

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
        response.setHeader("Access-Control-Allow-Origin", "*");

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

    /**
     * time now
     * @param request
     * @return url with json
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("getClockTime")
    public EditJson getClockTime(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Map<String, Object> map = new HashMap<>(2);
        map.put("datetime", dateFormat.format(calendar.getTime()));
        map.put("timestamp", calendar.getTime());
        EditJson editJson = new EditJson();
        editJson.setSuccess(true);
        editJson.setBean(map);
        return editJson;
    }

    /**
     * 查询fixList
     *
     * @param request
     * @return url with json
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/fixList")
    public EditJson fixList(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        String userId = session.getAttribute("USER_ID").toString();

        return dashboardService.fixList(userId);
    }

    /**
     * 查询hotlineList
     *
     * @param request
     * @return url with json
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/hotlineList")
    public EditJson hotlineList(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        return dashboardService.hotlineList();
    }

    /**
     * 查询hotline详情
     *
     * @param request
     * @return url with json
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/hotlineDetail")
    public EditJson hotlineDetail(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        String hotlineNo = StringUtil.nullToEmpty(request.getParameter("hotlineNo"));

        return dashboardService.hotlineDetail(hotlineNo);
    }

    /**
     * 插入fixList
     *
     * @param request
     * @return url with json
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/insertFixList")
    public EditJson insertFixList(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
//        String userId = session.getAttribute("USER_ID").toString();

        String hotlineTitle = StringUtil.nullToEmpty(request.getParameter("hotlineTitle"));
        String hotlineContent = StringUtil.nullToEmpty(request.getParameter("hotlineContent"));
        String fixPerson = StringUtil.nullToEmpty(request.getParameter("fixPerson"));
        String fixPhone = StringUtil.nullToEmpty(request.getParameter("fixPhone"));
        String fixArea = StringUtil.nullToEmpty(request.getParameter("fixArea"));
        String fixAddr = StringUtil.nullToEmpty(request.getParameter("fixAddr"));

        return dashboardService.insertFixList(hotlineTitle, hotlineContent, fixPerson, fixPhone, fixArea, fixAddr);
    }

    /**
     * 上传图片
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/savePicture")
    public EditJson savePicture(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            String pic_1 = StringUtil.nullToEmpty(request.getParameter("filePath_1"));
            String pic_2 = StringUtil.nullToEmpty(request.getParameter("filePath_2"));
            String pic_3 = StringUtil.nullToEmpty(request.getParameter("filePath_3"));
            String pic_4 = StringUtil.nullToEmpty(request.getParameter("filePath_4"));
            String pic_5 = StringUtil.nullToEmpty(request.getParameter("filePath_5"));
            String pic_6 = StringUtil.nullToEmpty(request.getParameter("filePath_6"));
            String pic_7 = StringUtil.nullToEmpty(request.getParameter("filePath_7"));
            String pic_8 = StringUtil.nullToEmpty(request.getParameter("filePath_8"));
            String pic_9 = StringUtil.nullToEmpty(request.getParameter("filePath_9"));

            Map<String, String> map = new HashMap<>();
            map.put("filePath_1", URLDecoder.decode(URLDecoder.decode(pic_1,"UTF-8"),"UTF-8"));
            map.put("filePath_2", URLDecoder.decode(URLDecoder.decode(pic_2,"UTF-8"),"UTF-8"));
            map.put("filePath_3", URLDecoder.decode(URLDecoder.decode(pic_3,"UTF-8"),"UTF-8"));
            map.put("filePath_4", URLDecoder.decode(URLDecoder.decode(pic_4,"UTF-8"),"UTF-8"));
            map.put("filePath_5", URLDecoder.decode(URLDecoder.decode(pic_5,"UTF-8"),"UTF-8"));
            map.put("filePath_6", URLDecoder.decode(URLDecoder.decode(pic_6,"UTF-8"),"UTF-8"));
            map.put("filePath_7", URLDecoder.decode(URLDecoder.decode(pic_7,"UTF-8"),"UTF-8"));
            map.put("filePath_8", URLDecoder.decode(URLDecoder.decode(pic_8,"UTF-8"),"UTF-8"));
            map.put("filePath_9", URLDecoder.decode(URLDecoder.decode(pic_9,"UTF-8"),"UTF-8"));

//            String filePath_1 = URLDecoder.decode(URLDecoder.decode(pic_1,"UTF-8"),"UTF-8");
//            String filePath_2 = URLDecoder.decode(URLDecoder.decode(pic_2,"UTF-8"),"UTF-8");
//            String filePath_3 = URLDecoder.decode(URLDecoder.decode(pic_3,"UTF-8"),"UTF-8");
//            String filePath_4 = URLDecoder.decode(URLDecoder.decode(pic_4,"UTF-8"),"UTF-8");
//            String filePath_5 = URLDecoder.decode(URLDecoder.decode(pic_5,"UTF-8"),"UTF-8");
//            String filePath_6 = URLDecoder.decode(URLDecoder.decode(pic_6,"UTF-8"),"UTF-8");
//            String filePath_7 = URLDecoder.decode(URLDecoder.decode(pic_7,"UTF-8"),"UTF-8");
//            String filePath_8 = URLDecoder.decode(URLDecoder.decode(pic_8,"UTF-8"),"UTF-8");
//            String filePath_9 = URLDecoder.decode(URLDecoder.decode(pic_9,"UTF-8"),"UTF-8");

            String userID = (String) request.getSession().getAttribute("USER_ID");

            EditJson editJson = new EditJson();
            editJson.setSuccess(true);
            editJson.setBean(map);

            for(String str:map.values()){
                dashboardService.savePicture(userID, str); // 依次上传每个图片
            }

            return editJson;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(),e);
        }
    }
}

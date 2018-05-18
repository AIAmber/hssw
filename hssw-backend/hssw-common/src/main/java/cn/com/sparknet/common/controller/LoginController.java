package cn.com.sparknet.common.controller;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.sparknet.common.json.EditJson;
import cn.com.sparknet.common.service.LoginService;
import cn.com.sparknet.common.util.StringUtil;

/**
 * 系统登录
 * @author chenxy
 *
 */
@Controller
@RequestMapping("/LoginController")
public class LoginController {

    @Resource
    private LoginService loginService;

    /**
     * 登录系统
     */
    @ResponseBody
    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session=request.getSession();
        if (!"POST".equals(request.getMethod())) {
            this.sendRedirect(false, "来自不安全的网站登录", session, request, response);
        }else{
            //解决会话标识未更新漏洞
            if(null!=session){
                session.invalidate();
            }
            Cookie[] cookies=request.getCookies();
            if(null!=cookies){
                cookies[0].setMaxAge(0);
            }
            session=request.getSession(true);
            //账号校验
            String username=StringUtil.nullToEmpty(request.getParameter("u"));
            String password=StringUtil.nullToEmpty(request.getParameter("p"));

            EditJson editJson=loginService.loginSystem(request, session, username, password);
//                //从数据库查询用户所具体的权限
//                List<Map<String,Object>> moduleList = moduleService.findModuleByUserName(username);
//                session.setAttribute("moduleTreeList", moduleList);
//                String userId = (String) request.getSession().getAttribute("USER_ID");
//                //查询用户所具有的区域权限信息
//                List<Map<String,Object>> areaList = moduleService.getAreaByUserId(userId);
//                session.setAttribute("areaList", areaList);
            if(editJson.isSuccess()){
                this.sendRedirect(true, null, session, request, response);
            }else{
                this.sendRedirect(false, editJson.getBean().toString(), session, request, response);
            }
        }
    }

    /**
     * 注销系统
     * @param request
     * @param response
     */
    @RequestMapping("/loginOut")
    public void loginOut(HttpServletRequest request, HttpServletResponse response){
        try{
            HttpSession session=request.getSession();
            if(null!=session){
                session.removeAttribute("sessionBean");
                session.invalidate();
            }
            response.sendRedirect(request.getContextPath()+"/login/login.html");
        }catch(Exception e){
            throw new RuntimeException(e.getMessage(),e);
        }
    }

    /**
     * 用户会话查询
     * @param request
     * @param response
     * @return editJson
     */
    @ResponseBody
    @RequestMapping("/session")
    public EditJson session(HttpServletRequest request, HttpServletResponse response){
        EditJson editJson = new EditJson();
        Map<String, Object> sessionMap = new HashMap<String, Object>();
        HttpSession session=request.getSession();
        String userName = session.getAttribute("USER_NAME").toString();

        sessionMap.put("id", session.getAttribute("USER_ID"));
        sessionMap.put("name", session.getAttribute("NAME"));
        sessionMap.put("username", session.getAttribute("USER_NAME"));

        editJson.setBean(sessionMap);
        if (null!=userName){
            editJson.setSuccess(true);
        }

        return editJson;
    }

    /**
     * 页面跳转
     */
    private void sendRedirect(boolean success,String errorinfo,HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(success){
            //跳转到首页
            session.removeAttribute("errorinfo");
            response.sendRedirect(request.getContextPath()+"/index.jsp#/home");
        }else{
            //跳转到登录页
            session.setAttribute("errorinfo", "<img src=\""+request.getContextPath()+"/login/images/error.png\"/> "+errorinfo);
            response.sendRedirect(request.getContextPath()+"/login/login.html");
        }
    }

}

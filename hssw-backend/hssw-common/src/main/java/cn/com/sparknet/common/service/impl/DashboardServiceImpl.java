package cn.com.sparknet.common.service.impl;

import cn.com.sparknet.common.json.EditJson;
import cn.com.sparknet.common.service.DashboardService;
import cn.com.sparknet.common.dao.DashboardDao;
import cn.com.sparknet.common.util.InputStreamUtil;
import cn.com.sparknet.common.util.JsonUtil;

import cn.com.sparknet.common.util.StringUtil;
import cn.com.sparknet.common.util.UUIDUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


@Service
public class DashboardServiceImpl implements DashboardService{

    @Resource
    private DashboardDao dashboardDao;
    /**
     * data of line， 首页echarts - line 省级数据加载
     * @param
     * @return json
     * @throws Exception
     */
    @Override
    public String jsonLine(String errorType) {
        // Json - line
        Map<String, Integer> map = new HashMap<String, Integer>();
        // 计算同一错误出现的次数
        for (Map<String, Object> obj:dashboardDao.listLine()) {
            // obj.values()和obj.values().toString() -> "[String]"
            // objString -> "String"
            String objString = obj.values().toString();
            objString = objString.substring(1, objString.length()-1);

            if (map.containsKey(objString)) {
                map.put(objString, map.get(objString).intValue() + 1);
            } else {
                map.put(objString, 1);
            }
        }

        String json = null;
        // 将数据转换成Json格式
        try {
            json = JsonUtil.mapToJson(map);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(),e);
        }

        return json;
    }

    /**
     * 修改图片
     */
    @Override
    public EditJson savePicture(String userId, String filePath) {
        EditJson editJson=new EditJson();
        InputStream is = null;
        try{
            //修改人员头像
            if(StringUtil.isNotEmpty(userId)){
                if(StringUtil.isEmpty(filePath)){
                    dashboardDao.savePicture(userId,null);
                }else{
                    File file = new File(filePath);
                    if(file.exists()){
                        is = new FileInputStream(file);
                        dashboardDao.savePicture(userId, InputStreamUtil.InputStreamToByte(is));
                    }
                }
                editJson.setSuccess(true);
            }
        }catch(Exception e){
            editJson.setSuccess(false);
            throw new RuntimeException(e.getMessage(),e);
        }finally{
            if(null != is){
                try {
                    is.close();
                    is = null;
                } catch (IOException e) {
                    throw new RuntimeException(e.getMessage(),e);
                }
            }
        }
        return editJson;
    }

    /**
     * 查询fixList
     *
     * @param
     * @return json
     * @throws Exception
     */
    @Override
    public EditJson fixList(String userId){
        EditJson editJson = new EditJson();
        editJson.setBean(dashboardDao.fixList(userId));
        editJson.setSuccess(true);

        return editJson;
    }

    /**
     * 插入insertFixList
     *
     * @param
     * @return json
     * @throws Exception
     */
    @Override
    public EditJson insertFixList(String hotlineTitle, String hotlineContent, String fixPerson, String fixPhone, String fixArea, String fixAddr){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
        Calendar calendar = Calendar.getInstance();

        String hotlineId = UUIDUtil.getNextValue();
        String hotlineNo = dateFormat.format(calendar.getTime());
        System.out.println(hotlineNo);
        dashboardDao.insertFixList(hotlineId, hotlineNo, hotlineTitle, hotlineContent, fixPerson, fixPhone, fixArea, fixAddr);

        EditJson editJson = new EditJson();
        editJson.setBean("添加事件成功!");
        editJson.setSuccess(true);

        return editJson;
    }
}

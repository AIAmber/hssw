package cn.com.sparknet.common.service.impl;

import cn.com.sparknet.common.service.DashboardService;
import cn.com.sparknet.common.dao.DashboardDao;
import cn.com.sparknet.common.util.JsonUtil;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}

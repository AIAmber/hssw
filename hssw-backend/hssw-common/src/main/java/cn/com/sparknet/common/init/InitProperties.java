package cn.com.sparknet.common.init;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import cn.com.sparknet.common.util.CacheUtil;
import cn.com.sparknet.common.util.ConfigUtil;

/**
 * 初始化属性配置文件
 * @author chenxy
 *
 */
@Component
public class InitProperties {
	
	private final static String CONFIG_CACHE_NAME = "ConfigCache";
	
	private List<String> configFileNames=new ArrayList<String>();
	
	public InitProperties(){
		configFileNames.add("log4j.properties");
		configFileNames.add("config/common.properties");
		configFileNames.add("config/manage.properties");
	}
	
	@PostConstruct
	private void init() {
        try {
        	//将所有上方已配置的属性文件加入至缓存
        	Map map=null;
        	CacheUtil cacheUtil=CacheUtil.getInstance();
        	cacheUtil.addCache(CONFIG_CACHE_NAME);
        	for(String name:configFileNames){
        		map=new ConfigUtil(name).getAllProperty();
        		if(null!=map){
        			cacheUtil.addElement(CONFIG_CACHE_NAME, map);
        		}
        	}
        } catch (Exception e) {
        	throw new RuntimeException(e.getMessage(),e);
        }
	}

}

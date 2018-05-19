package cn.com.sparknet.common.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.sparknet.common.json.EditJson;
import cn.com.sparknet.common.service.TestService;
import cn.com.sparknet.common.util.StringUtil;

/*
 * 
 * 		功能模块 对应图表
 * 
		综合运行
			生产制水
				图表1 源水压力
				图表2 源水瞬间流量
				图表3 水厂1#瞬间流量
				图表4 水厂2#瞬间流量
				图表5 源水压力、流量
				图表6 出水瞬时流量
				图表7 水厂1#日出水流量
				图表8 水厂1#月出水流量
				图表9 水厂2#日出水流量
				图表10 水厂2#月出水流量
			管网
				图表11 材质
				图表12 类型
				图表13 口径
		运行总览
			数据列表
				图表14 水厂
				图表15 大表
				图表16 二供
		制水生产
			实时数据
				图表17 源水
				图表18 出水
				图表19 泵房
			趋势曲线
				图表20 源水流量、压力对比分析
				图表21 源水压力、浊度对比分析
				图表22 源水累计流量统计
			数据报表
				图表23 数据报表
		压力监测
			实时压力
				“图表24” 菜单列表   //带引号，不知道算不算表
				图表25 曲线图
				图表26 报表
		流量监测
			实时流量
				“图表27” 菜单列表
				图表28 曲线图
				图表29 报表
		泵站监测
			泵站实时监测
				“图表30” 菜单列表
				图表31 实时数据
				图表32 水泵运行数据
				图表33 压力曲线
		用水分析
				
		远程抄表
				“图表35” 菜单列表 城区
				“图表36” 菜单列表 小区
				“图表37” 菜单列表 单元
				“图表38” 菜单列表 户
				图表39 某户
		二次供水
				“图表35” 菜单列表
		实时数据
				图表36 
		趋势曲线
				图表37 
		数据报表
				图表38
		报警信息
				图表39
	*/


/*
 * SpringMVC框架中的Controller层，负责接收前端的HTTP请求，并作出响应，返回需要的数据
 * @param URL http://carrott.iok.la/hssw-common/Test
 * @return null
 */
@Controller
@RequestMapping("/Test")
public class TestController {

	//声明一个Services层实例
	@Resource
	private TestService testService;
	
	
	/**
     * time now
     * @param request
     * @return url with json
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("getClockTime")
    public EditJson getClockTime(HttpServletRequest request) {
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

	//Module One : Comprehensive Operation
    
	/*
	 * Table One
	 * The water pressure of SourceWater station '源水压力'
	 * @RequestMapping SourceWaterPress_Json
	 * @param request response
	 * @return Json[data_times '时间',press '压力']
	 */
	@ResponseBody
	@RequestMapping("/SourceWaterPress")
	public EditJson SourceWaterPress(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return testService.SourceWaterPress_JsonData(); 
	}
	
	/*
	 * Table Two
	 * The water instantaneous flow of SourceWater station '源水瞬时流量'
	 * @RequestMapping SourceWaterFlow_Json
	 * @param request response
	 * @return Json[data_times '时间',flow '流量']
	 */
	@ResponseBody
	@RequestMapping("/SourceWaterFlow")
	public EditJson SourceWaterFlow(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return testService.SourceWaterFlow_JsonData(); 
	}
	
	/*
	 * Table Three
	 * The water instantaneous flow of appointed station '指定站点的瞬时流量'
	 * Appointed station = "WaterWorks_One_Instantaneous_Flow" or "WaterWorks_Two_Instantaneous_Flow"
	 * @RequestMapping WaterStationFlow_Json?address=address
	 * @Post address '站点名称'
	 * @param request response
	 * @return Json[data_times '时间',flow '流量']
	 */
	@ResponseBody
	@RequestMapping("/WaterStationFlow")
	public EditJson WaterStationFlow(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String address = StringUtil.nullToEmpty(request.getParameter("address"));
		return testService.WaterStationFlow_JsonData(address); 
	}
	
	
	/*
	 * Table Five
	 * The water pressure and water instantaneous flow of SourceWater station '源水压力和源水瞬时流量'
	 * @RequestMapping SourceWaterPressFlow_Json
	 * @param request response
	 * @return Json[data_times '时间',press '压力',flow '流量']
	 */
	@ResponseBody
	@RequestMapping("/SourceWaterPressFlow")
	public EditJson SourceWaterPressFlow(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return testService.SourceWaterPressFlow_JsonData(); 
	}
	
	
	/*
	 * Table Six
	 * The water instantaneous flow of OutWater station
	 * @RequestMapping OutInstantFlow_Json
	 * @param request response
	 * @return Json[FLOW_DATETIME '时间' ,FLOW_STATION '流量所属站' ,FLOW_TOTAL '累计流量']
	 */
	@ResponseBody
	@RequestMapping("/OutInstantFlow")
	public EditJson OutInstantFlow(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return testService.OutInstantFlow_JsonData(); 
	}
	
	/*
	 * Table Seven
	 *
	 */
	@ResponseBody
	@RequestMapping("/OutDayFlow")
	public EditJson OutDayFlow(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String address = StringUtil.nullToEmpty(request.getParameter("address"));
		return testService.OutDayFlow_JsonData(address); 
	}
	
	
	/*
	 * Table Eight
	 */
	@ResponseBody
	@RequestMapping("/OutMonthFlow")
	public EditJson OutMonthFlow(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String address = StringUtil.nullToEmpty(request.getParameter("address"));
		return testService.OutMonthFlow_JsonData(address); 
	}
	
	/*
	 * Table Eleven
	 */
	@ResponseBody
	@RequestMapping("/PipeMaterial")
	public EditJson PipeMaterial(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String dataType = StringUtil.nullToEmpty(request.getParameter("dataType"));
		return testService.PipeMaterial_JsonData(dataType); 
	}
	
	/********************************************运行总览模块***********************************************/
	
	/*
	 * 图表14 
	 */
	@ResponseBody
	@RequestMapping("/WaterWorks")
	public EditJson WaterWorks(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String dataType = StringUtil.nullToEmpty(request.getParameter("dataType"));
		switch (dataType) {
		case "水厂":
			return testService.WaterWorks_JsonData();
		case "大表":
			return testService.BigMeter_JsonData();
		case "二供":
			return testService.SecondSupply_JsonData();
		default:
			return null;
		}
		
	}

	/********************************************制水生产模块***********************************************/
	
	//实时数据
	
	/*
	 * 图表17  
	 * address=源水 or 水厂出水 or 水厂泵房
	 */
	@ResponseBody
	@RequestMapping("/WaterProduction")
	public EditJson WaterProduction(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String address = StringUtil.nullToEmpty(request.getParameter("address"));
		return testService.WaterProduction_JsonData(address);
	}
	
	
	//趋势曲线
	
	/*
	 * 表20
	 */
	@ResponseBody
	@RequestMapping("/SourceWaterFlowPress")
	public EditJson SourceWaterFlowPress(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String time = StringUtil.nullToEmpty(request.getParameter("time"));
		return testService.SourceWaterFlowPress_JsonData(time);
	}
	
	/*
	 * 表21
	 */
	@ResponseBody
	@RequestMapping("/SourceWaterPressTurbidity")
	public EditJson SourceWaterPressTurbidity(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String time = StringUtil.nullToEmpty(request.getParameter("time"));
		return testService.SourceWaterPressTurbidity_JsonData(time);
	}
	
	/*
	 * 表22
	 */
	@ResponseBody
	@RequestMapping("/SourceWaterDayTotalFlow")
	public EditJson SourceWaterDayTotalFlow(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String time = StringUtil.nullToEmpty(request.getParameter("time"));
		return testService.SourceWaterDayTotalFlow_JsonData(time);
	}
	

	/*
	 * 表23
	 */
	@ResponseBody
	@RequestMapping("/WaterWorksHistoryData")
	public EditJson WaterWorksHistoryData(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String time = StringUtil.nullToEmpty(request.getParameter("time"));
		return testService.WaterWorksHistoryData_JsonData(time);
	}
	
	
	/********************************************压力监测模块**********************************************************/
	
	
	/*
	 * 
	 */
	@ResponseBody
	@RequestMapping("/WaterPress_Realtime")
	public EditJson WaterPress_Realtime(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return testService.WaterPress_RealTime_JsonData();
	}
	
	/*
	 * 表25
	 */
	@ResponseBody
	@RequestMapping("/WaterPress")
	public EditJson WaterPress(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String address = StringUtil.nullToEmpty(request.getParameter("address"));
		String startTime = StringUtil.nullToEmpty(request.getParameter("startTime"));
		String endTime = StringUtil.nullToEmpty(request.getParameter("endTime"));
		return testService.WaterPress_JsonData(address,startTime,endTime);
	}
	
	/********************************************流量监测模块**********************************************************/
	
	
	/*
	 * 
	 */
	@ResponseBody
	@RequestMapping("/WaterFlow_Realtime")
	public EditJson WaterFlow_Realtime(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return testService.WaterFlow_Realtime_JsonData();
	}
	
	/*
	 * 表28
	 */
	@ResponseBody
	@RequestMapping("/WaterFlow")
	public EditJson WaterFlow(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String address = StringUtil.nullToEmpty(request.getParameter("address"));
		String startTime = StringUtil.nullToEmpty(request.getParameter("startTime"));
		String endTime = StringUtil.nullToEmpty(request.getParameter("endTime"));
		return testService.WaterFlow_JsonData(address,startTime,endTime);
	}
	
	/********************************************泵站监测模块**********************************************************/
	
	/*
	 * 
	 */
	@ResponseBody
	@RequestMapping("/PumpStation")
	public EditJson PumpStation(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return testService.PumpStation_JsonData();
	}
	
	/*
	 * 表31
	 */
	@ResponseBody
	@RequestMapping("/PumpStationNewData")
	public EditJson PumpStationNewData(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String address = StringUtil.nullToEmpty(request.getParameter("address"));
		return testService.PumpStationNewData_JsonData(address);
	}
	
	
	
	
	/*
	 * 表33
	 */
	@ResponseBody
	@RequestMapping("/PumpStationPress")
	public EditJson PumpStationPress(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String address = StringUtil.nullToEmpty(request.getParameter("address"));
		return testService.PumpStationPress_JsonData(address);
	}


	/********************************************用水分析模块**********************************************************/
	
	/*
	 * 表34
	 */
	@ResponseBody
	@RequestMapping("/AnalyzeWaterUsed")
	public EditJson AnalyzeWaterUsed(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return testService.AnalyzeWaterUsed_JsonData();
	}


	/********************************************远程抄表模块**********************************************************/
	
	@ResponseBody
	@RequestMapping("/UserWaterMeter_List_Area")
	public EditJson UserWaterMeter_List_Area(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return testService.UserWaterMeter_List_Area_JsonData();
	}
	
	@ResponseBody
	@RequestMapping("/UserWaterMeter_List_Community")
	public EditJson UserWaterMeter_List_Community(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String areaName = StringUtil.nullToEmpty(request.getParameter("areaName"));
		return testService.UserWaterMeter_List_Community_JsonData(areaName);
	}
	
	@ResponseBody
	@RequestMapping("/UserWaterMeter_List_Building")
	public EditJson UserWaterMeter_List_Building(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String communityName = StringUtil.nullToEmpty(request.getParameter("communityName"));
		return testService.UserWaterMeter_List_Building_JsonData(communityName);
	}
	
	@ResponseBody
	@RequestMapping("/UserWaterMeter_List_Room")
	public EditJson UserWaterMeter_List_Room(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String buildingName = StringUtil.nullToEmpty(request.getParameter("buildingName"));
		return testService.UserWaterMeter_List_Room_JsonData(buildingName);
	}
	
	
	/*
	 * 表39
	 */
	@ResponseBody
	@RequestMapping("/UserWaterMeter")
	public EditJson UserWaterMeter(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String address = StringUtil.nullToEmpty(request.getParameter("roomId"));
		return testService.UserWaterMeter_JsonData(address);
	}
	
	/********************************************二次供水模块**********************************************************/
	
	@ResponseBody
	@RequestMapping("/SecondWaterSupply_List")
	public EditJson SecondWaterSupply_List(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return testService.SecondWaterSupply_List_JsonData();
	}

	/*
	 * 表41
	 */
	@ResponseBody
	@RequestMapping("/SecondWaterSupplyNewData")
	public EditJson SecondWaterSupplyNewData(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String address = StringUtil.nullToEmpty(request.getParameter("address"));
		return testService.SecondWaterSupplyNewData_JsonData(address);
	}

	
	/*
	 * 表42 
	 */
	@ResponseBody
	@RequestMapping("/SecondWaterSupplyHistoryData_Days")
	public EditJson SecondWaterSupplyHistoryData_Days(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String address = StringUtil.nullToEmpty(request.getParameter("address"));
		String startTime = StringUtil.nullToEmpty(request.getParameter("startTime"));
		String endTime = StringUtil.nullToEmpty(request.getParameter("endTime"));
		return testService.SecondWaterSupplyHistoryData_Days_JsonData(address,startTime,endTime);
	}

	@ResponseBody
	@RequestMapping("/SecondWaterSupplyHistoryData_Day")
	public EditJson SecondWaterSupplyHistoryData_Day(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String address = StringUtil.nullToEmpty(request.getParameter("address"));
		String time = StringUtil.nullToEmpty(request.getParameter("time"));
		return testService.SecondWaterSupplyHistoryData_Day_JsonData(address,time);
	}
}

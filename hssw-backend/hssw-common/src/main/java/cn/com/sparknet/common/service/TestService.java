package cn.com.sparknet.common.service;


import cn.com.sparknet.common.json.EditJson;

public interface TestService {
	
	/***************************************************综合运行模块******************************************************************/
	
	/*
	 * 图表1 两个水厂瞬时流量和时间
	 */
	public EditJson SourceWaterPress_JsonData();
	
	/*
	 * 图表2
	 */
	public EditJson SourceWaterFlow_JsonData();
	/*
	 * 图表3 图表4
	 */
	public EditJson WaterStationFlow_JsonData(String address);
	/*
	 * 图表5
	 */
	public EditJson SourceWaterPressFlow_JsonData();
	/*
	 * 图表6
	 */
	public EditJson OutInstantFlow_JsonData();
	/*
	 * 图表7
	 */
	public EditJson OutDayFlow_JsonData(String address);
	/*
	 * 图表8
	 */
	public EditJson OutMonthFlow_JsonData(String address);
	/*
	 * 图表11
	 */
	public EditJson PipeMaterial_JsonData(String dataType);

	/***************************************************运行总览模块******************************************************************/
	/*
	 * 图表14
	 */
	public EditJson WaterWorks_JsonData();
	public EditJson BigMeter_JsonData();
	public EditJson SecondSupply_JsonData();


	/***************************************************制水生产模块******************************************************************/
	/*
	 * 图表17
	 * 模块      制水生产
	 * 子模块   实时数据
	 * 图表名   源水
	 * @return Json格式数据
	 */
	public EditJson WaterProduction_JsonData(String address);
	
	
	/*
	 * 图表20
	 */
	public EditJson SourceWaterFlowPress_JsonData(String time);
	
	/*
	 * 图表21
	 */
	public EditJson SourceWaterPressTurbidity_JsonData(String time);
	
	/*
	 * 图表22
	 */
	public EditJson SourceWaterDayTotalFlow_JsonData(String time);
	/*
	 * 图表23
	 */
	public EditJson WaterWorksHistoryData_JsonData(String time);
	
	/***************************************************压力监测模块******************************************************************/
	public EditJson WaterPress_RealTime_JsonData();
	/*
	 * 图表25
	 */
	public EditJson WaterPress_JsonData(String address, String startTime, String endTime);
	/***************************************************流量监测模块******************************************************************/
	public EditJson WaterFlow_Realtime_JsonData();
	/*
	 * 图表28
	 */
	public EditJson WaterFlow_JsonData(String address, String startTime, String endTime);
	/***************************************************泵站监测模块******************************************************************/
	public EditJson PumpStation_JsonData();
	/*
	 * 图表31
	 */
	public EditJson PumpStationNewData_JsonData(String address);
	
	/*
	 * 图表33
	 */
	public EditJson PumpStationPress_JsonData(String address);
	/***************************************************用水分析模块******************************************************************/
	
	/*
	 * 图表34
	 */
	public EditJson AnalyzeWaterUsed_JsonData();
	/***************************************************远程抄表模块******************************************************************/
	public EditJson UserWaterMeter_List_Area_JsonData();
	public EditJson UserWaterMeter_List_Community_JsonData(String areaName);
	public EditJson UserWaterMeter_List_Building_JsonData(String communityName);
	public EditJson UserWaterMeter_List_Room_JsonData(String buildingName);
	/*
	 * 图表39
	 */
	public EditJson UserWaterMeter_JsonData(String address);
	/***************************************************二次供水模块******************************************************************/
	public EditJson SecondWaterSupply_List_JsonData();
	/*
	 * 图表41
	 */
	public EditJson SecondWaterSupplyNewData_JsonData(String address);
	/*
	 * 图表42
	 */
	public EditJson SecondWaterSupplyHistoryData_Days_JsonData(String address, String startTime, String endTime);

	public EditJson SecondWaterSupplyHistoryData_Day_JsonData(String address, String time);
}

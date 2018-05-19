package cn.com.sparknet.common.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.sparknet.common.dao.TestDao;
import cn.com.sparknet.common.json.EditJson;
import cn.com.sparknet.common.service.TestService;

@Service
public class TestServiceImp implements TestService {
	
	@Resource
	private TestDao testDao;
	
	
	//综合运行模块
	
	/*
	 * 
	 */
	@Override
	public EditJson SourceWaterPress_JsonData() {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.SourceWaterPress_Data());
		editJson.setSuccess(true);
		return editJson;
	}
	/*
	 * 图表2
	 */
	@Override
	public EditJson SourceWaterFlow_JsonData() {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.SourceWaterFlow_Data());
		editJson.setSuccess(true);
		return editJson;
	}
	/*
	 * 图表3 图表4
	 */
	@Override
	public EditJson WaterStationFlow_JsonData(String address) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.WaterStationFlow_Data(address));
		editJson.setSuccess(true);
		return editJson;
	}

	/*
	 * 图表5
	 */
	@Override
	public EditJson SourceWaterPressFlow_JsonData() {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.SourceWaterPressFlow_Data());
		editJson.setSuccess(true);
		return editJson;
	}
	/*
	 * 图表6
	 */
	@Override
	public EditJson OutInstantFlow_JsonData() {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.OutInstantFlow_Data());
		editJson.setSuccess(true);
		return editJson;
	}
	/*
	 * 图表7
	 */
	@Override
	public EditJson OutDayFlow_JsonData(String address) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.OutDayFlow_Data(address));
		editJson.setSuccess(true);
		return editJson;
	}
	/*
	 * 图表8
	 */
	@Override
	public EditJson OutMonthFlow_JsonData(String address) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.OutMonthFlow_Data(address));
		editJson.setSuccess(true);
		return editJson;
	}
	
	/*
	 * 图表11
	 */
	@Override
	public EditJson PipeMaterial_JsonData(String dataType) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.PipeMaterial_Data(dataType));
		editJson.setSuccess(true);
		return editJson;
	}
	

	/***************************************************运行总览模块******************************************************************/
	
	/*
	 * 图表14
	 */
	@Override
	public EditJson WaterWorks_JsonData() {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.WaterWorks_Data());
		editJson.setSuccess(true);
		return editJson;
	}
	
	@Override
	public EditJson BigMeter_JsonData() {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.BigMeter_Data());
		editJson.setSuccess(true);
		return editJson;
	}
	
	@Override
	public EditJson SecondSupply_JsonData() {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.SecondSupply_Data());
		editJson.setSuccess(true);
		return editJson;
	}


	/***************************************************制水生产模块******************************************************************/
	
	/*
	 * 图表17  
	 * 模块      制水生产
	 * 子模块   实时数据
	 * 图表名   源水
	 * 服务层实现 调用EditJson封装Dao层数据
	 * @return Json格式数据
	 */
	@Override
	public EditJson WaterProduction_JsonData(String address) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.WaterProduction_Data(address));
		editJson.setSuccess(true);
		return editJson;
	}
	
	/*
	 * 图表20
	 */
	@Override
	public EditJson SourceWaterFlowPress_JsonData(String time) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.SourceWaterFlowPress_Data(time));
		editJson.setSuccess(true);
		return editJson;
	}
	/*
	 * 图表21
	 */
	@Override
	public EditJson SourceWaterPressTurbidity_JsonData(String time) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.SourceWaterPressTurbidity_Data(time));
		editJson.setSuccess(true);
		return editJson;
	}
	/*
	 * 图表22
	 */
	@Override
	public EditJson SourceWaterDayTotalFlow_JsonData(String time) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.SourceWaterDayTotalFlow_Data(time));
		editJson.setSuccess(true);
		return editJson;
	}
	/*
	 * 图表23
	 */
	@Override
	public EditJson WaterWorksHistoryData_JsonData(String time) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.WaterWorksHistoryData_Data(time));
		editJson.setSuccess(true);
		return editJson;
	}

	/***************************************************压力监测模块******************************************************************/
	public EditJson WaterPress_RealTime_JsonData() {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.WaterPress_RealTime_Data());
		editJson.setSuccess(true);
		return editJson;
	}
	/*
	 * 图表25
	 */
	@Override
	public EditJson WaterPress_JsonData(String address, String startTime, String endTime) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.WaterPress_Data(address,startTime,endTime));
		editJson.setSuccess(true);
		return editJson;
	}
	/***************************************************流量监测模块******************************************************************/
	public EditJson WaterFlow_Realtime_JsonData() {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.WaterFlow_Realtime_Data());
		editJson.setSuccess(true);
		return editJson;
	}
	/*
	 * 图表28
	 */
	@Override
	public EditJson WaterFlow_JsonData(String address, String startTime, String endTime) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.WaterFlow_Data(address,startTime,endTime));
		editJson.setSuccess(true);
		return editJson;
	}
	/***************************************************泵站监测模块******************************************************************/
	public EditJson PumpStation_JsonData() {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.PumpStation_Data());
		editJson.setSuccess(true);
		return editJson;
	}
	/*
	 * 图表31
	 */
	@Override
	public EditJson PumpStationNewData_JsonData(String address) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.PumpStationNewData_Data(address));
		editJson.setSuccess(true);
		return editJson;
	}

	/*
	 * 图表33
	 */
	@Override
	public EditJson PumpStationPress_JsonData(String address) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.PumpStationPress_Data(address));
		editJson.setSuccess(true);
		return editJson;
	}
	/***************************************************用水分析模块******************************************************************/
	
	/*
	 * 图表34
	 */
	@Override
	public EditJson AnalyzeWaterUsed_JsonData() {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.AnalyzeWaterUsed_Data());
		editJson.setSuccess(true);
		return editJson;
	}
	/***************************************************远程抄表模块******************************************************************/
	public EditJson UserWaterMeter_List_Area_JsonData() {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.UserWaterMeter_List_Area_Data());
		editJson.setSuccess(true);
		return editJson;
	}
	public EditJson UserWaterMeter_List_Community_JsonData(String areaName) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.UserWaterMeter_List_Community_Data(areaName));
		editJson.setSuccess(true);
		return editJson;
	}
	public EditJson UserWaterMeter_List_Building_JsonData(String communityName) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.UserWaterMeter_List_Building_Data(communityName));
		editJson.setSuccess(true);
		return editJson;
	}
	public EditJson UserWaterMeter_List_Room_JsonData(String buildingName) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.UserWaterMeter_List_Room_Data(buildingName));
		editJson.setSuccess(true);
		return editJson;
	}
	
	/*
	 * 图表39
	 */
	@Override
	public EditJson UserWaterMeter_JsonData(String address) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.UserWaterMeter_Data(address));
		editJson.setSuccess(true);
		return editJson;
	}
	/***************************************************二次供水模块******************************************************************/
	public EditJson SecondWaterSupply_List_JsonData() {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.SecondWaterSupply_List_Data());
		editJson.setSuccess(true);
		return editJson;
	}
	/*
	 * 图表41
	 */
	@Override
	public EditJson SecondWaterSupplyNewData_JsonData(String address) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.SecondWaterSupplyNewData_Data(address));
		editJson.setSuccess(true);
		return editJson;
	}
	/*
	 * 图表42
	 */
	public EditJson SecondWaterSupplyHistoryData_Days_JsonData(String address,String startTime,String endTime) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.SecondWaterSupplyHistoryData_Days_Data(address,startTime,endTime));
		editJson.setSuccess(true);
		return editJson;
	}
	
	public EditJson SecondWaterSupplyHistoryData_Day_JsonData(String address,String time) {
		EditJson editJson = new EditJson();
		editJson.setBean(testDao.SecondWaterSupplyHistoryData_Day_Data(address,time));
		editJson.setSuccess(true);
		return editJson;
	}
}

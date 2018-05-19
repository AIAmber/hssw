package cn.com.sparknet.common.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

	@Resource
	private BaseDao baseDao;
	
	//综合运行模块
	
	 /*
	  * 图表1 
	  */
	public List<Map<String, Object>> SourceWaterPress_Data() {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT evalue '压力' FROM hssw.t_hssw_realtime WHERE station_info =\"源水压力\";");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), new Object[]{});
        return list;
    }
	
	/*
	 * 图表2
	 */
	public List<Map<String, Object>> SourceWaterFlow_Data() {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT evalue '瞬时流量' FROM hssw.t_hssw_realtime WHERE station_info = \"源水流量\";");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), new Object[]{});
        return list;
    }
	/*
	 * 图表3 图表4
	 */
	public List<Map<String, Object>> WaterStationFlow_Data(String address) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT evalue '瞬时流量' FROM hssw.t_hssw_realtime WHERE station_name = ?;");
        params.add(address);
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
	/*
	 * 图表5
	 */
	public List<Map<String, Object>> SourceWaterPressFlow_Data() {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT date_format(inserttime,'%Y-%m-%d %H:%i:%S') as '时间',station_info '名称',evalue '值' FROM hssw.t_hssw_history WHERE (station_info =\"源水压力\" OR station_info =\"源水流量\") AND inserttime like ?;");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        params.add(dateFormat.format(calendar.getTime()).toString()+"%");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
	/*
	 * 图表6
	 */
	public List<Map<String, Object>> OutInstantFlow_Data() {
		StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT date_format(inserttime,'%Y-%m-%d %H:%i:%S') as '时间',station_info '站点名',evalue '值' FROM hssw.t_hssw_history WHERE (station_info =\"水厂#1\" OR station_info =\"水厂#2\" ) AND inserttime=?;");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        params.add(dateFormat.format(calendar.getTime()).toString()+"%");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
	/*
	 * 图表7
	 */
	public List<Map<String, Object>> OutDayFlow_Data(String address) {
		StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        params.add(address);
        params.add(dateFormat.format(calendar.getTime()).toString()+"%");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
	/*
	 * 图表8
	 */
	public List<Map<String, Object>> OutMonthFlow_Data(String address) {
		StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        Calendar calendar = Calendar.getInstance();
        params.add(address);
        params.add(dateFormat.format(calendar.getTime()).toString()+"%");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
	
	/*
	 * 图表11
	 */
	public List<Map<String, Object>> PipeMaterial_Data(String dataType) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT data_type '类型',data_name '名称',value '值' FROM test.pipe WHERE data_type = ?;");
        params.add(dataType);
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }

	/***************************************************运行总览模块******************************************************************/

	/*
	 * 图表14
	 */
	public List<Map<String, Object>> WaterWorks_Data() {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT station_info '测压点',evalue '压力值' FROM hssw.t_hssw_realtime WHERE remake =\"水厂\" ;");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(),new Object[]{});
        return list;
    }
	public List<Map<String, Object>> BigMeter_Data() {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT station_info '测压点',evalue '压力值' FROM hssw.t_hssw_realtime WHERE remake =\"大表\" ;");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(),new Object[]{});
        return list;
    }
	public List<Map<String, Object>> SecondSupply_Data() {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT station_name '站点名称',evalue '压力值' FROM hssw.t_hssw_realtime WHERE remake =\"二供\" AND station_info =\"进水压力\" ;");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(),new Object[]{});
        return list;
    }


	/***************************************************制水生产模块******************************************************************/
	
	/*
	 * 图表17 18 19 
	 * 
	 */
	public List<Map<String, Object>> WaterProduction_Data(String address) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT station_info '数据名称',evalue '值' FROM hssw.t_hssw_realtime WHERE station_name = ?;");
        params.add(address);
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
	
	
	
	/*
	 * 图表20
	 */
	public List<Map<String, Object>> SourceWaterFlowPress_Data(String time) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT date_format(inserttime,'%Y-%m-%d %H:%i:%S') as '时间',station_info '名称',evalue '值' FROM hssw.t_hssw_history WHERE (station_info =\"源水流量\" OR station_info =\"源水压力\") AND inserttime LIKE ?;"); 
		params.add(time+"%");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
	/*
	 * 图表21
	 */
	public List<Map<String, Object>> SourceWaterPressTurbidity_Data(String time) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT date_format(inserttime,'%Y-%m-%d %H:%i:%S') as '时间',station_info '名称',evalue '值' FROM hssw.t_hssw_history WHERE (station_info =\"源水压力\" OR station_info =\"源水浊度\") AND inserttime LIKE ?;"); 
        params.add(time+"%");
		List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
	/*
	 * 图表22
	 */
	public List<Map<String, Object>> SourceWaterDayTotalFlow_Data(String time) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
	/*
	 * 图表23
	 */
	public List<Map<String, Object>> WaterWorksHistoryData_Data(String time) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT date_format(inserttime,'%Y-%m-%d %H:%i:%S') as '时间',station_info '名称',evalue '值' FROM hssw.t_hssw_history WHERE (station_info =\"源水流量\" OR station_info =\"源水压力\" OR station_info =\"源水浊度\" OR station_info =\"源水累计流量\") AND (inserttime LIKE '%00:00' AND inserttime LIKE ?);");
        params.add(time+"%");
		List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }

/***************************************************压力监测模块******************************************************************/
	public List<Map<String, Object>> WaterPress_RealTime_Data() {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT station_name '站点名称',evalue '压力值',updatetime '时间' FROM hssw.t_hssw_realtime WHERE remake=\"压力监测\";");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), new Object[]{});
        return list;
    }
	/*
	 * 图表25
	 */
	public List<Map<String, Object>> WaterPress_Data(String address, String startTime, String endTime) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT date_format(inserttime,'%Y-%m-%d %H:%i:%S') as '时间',evalue '压力值' FROM hssw.t_hssw_history WHERE station_name=? AND station_info=\"进水压力\" AND inserttime BETWEEN ? AND ? AND inserttime LIKE '%00:00';");
        params.add(address);
        params.add(startTime+" 00:00:00");
        params.add(endTime+" 23:59:59");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
	/***************************************************流量监测模块******************************************************************/
	public List<Map<String, Object>> WaterFlow_Realtime_Data() {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT station_name '站点名称',evalue '流量值',updatetime '时间' FROM hssw.t_hssw_realtime WHERE remake=\"流量监测\";");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), new Object[]{});
        return list;
    }
	/*
	 * 图表28
	 */
	public List<Map<String, Object>> WaterFlow_Data(String address, String startTime, String endTime) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT date_format(inserttime,'%Y-%m-%d %H:%i:%S') as '时间',evalue '流量值' FROM hssw.t_hssw_history WHERE station_name=? AND \"瞬时流量\" AND inserttime BETWEEN ? AND ? AND inserttime LIKE '%00:00';");
        params.add(address);
        params.add(startTime+" 00:00:00");
        params.add(endTime+" 23:59:59");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
	/***************************************************泵站监测模块******************************************************************/
	public List<Map<String, Object>> PumpStation_Data() {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT DISTINCT(station_name) AS '站点名称' FROM hssw.t_hssw_realtime WHERE reamke=\"泵站\";");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), new Object[]{});
        return list;
    }
	/*
	 * 图表31
	 */
	public List<Map<String, Object>> PumpStationNewData_Data(String address) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT station_info '名称', evalue '值' FROM hssw.t_hssw_realtime WHERE station_name=?;");
        params.add(address);
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }

	/*
	 * 图表33
	 */
	public List<Map<String, Object>> PumpStationPress_Data(String address) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT date_format(inserttime,'%Y-%m-%d %H:%i:%S') as '时间',station_info '名称',evalue '值' FROM hssw.t_hssw_history WHERE inserttime LIKE ? AND station_name = ? AND (station_info = \"出水口压力\" OR station_info = \"入水口压力\");");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        params.add(dateFormat.format(calendar.getTime()).toString()+"%");
        params.add(address);
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
	/***************************************************用水分析模块******************************************************************/
	
	/*
	 * 图表34
	 */
	public List<Map<String, Object>> AnalyzeWaterUsed_Data() {
        StringBuffer sql = new StringBuffer();
        sql.append("");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), new Object[]{});
        return list;
    }
	
	/***************************************************远程抄表模块******************************************************************/
	public List<Map<String, Object>> UserWaterMeter_List_Area_Data() {
        StringBuffer sql = new StringBuffer();
        sql.append("select DISTINCT(area) AS '地点' FROM hssw.t_hssw_family");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), new Object[]{});
        return list;
    }
	
	public List<Map<String, Object>> UserWaterMeter_List_Community_Data(String areaName) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("select DISTINCT(community) AS '地点' FROM hssw.t_hssw_family WAERE area=?;");
        params.add(areaName);
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
	
	public List<Map<String, Object>> UserWaterMeter_List_Building_Data(String communityName) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("select DISTINCT(building) AS '地点' FROM hssw.t_hssw_family WAERE community=?;");
        params.add(communityName);
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
	
	public List<Map<String, Object>> UserWaterMeter_List_Room_Data(String buildingName) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT id '户号',room_id '房号' FROM hssw.t_hssw_family WAERE building=?;");
        params.add(buildingName);
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
	
	/*
	 * 图表39
	 */
	public List<Map<String, Object>> UserWaterMeter_Data(String address) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT station_info '名称',evalue '值' FROM hssw.t_hssw_realtime WHERE station_id =?;");
        params.add(address);
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
	/***************************************************二次供水模块******************************************************************/
	public List<Map<String, Object>> SecondWaterSupply_List_Data() {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT DISTINCT(station_name) AS '地点' FROM hssw.t_hssw_realtime WHERE remake=\"二供\";");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), new Object[]{});
        return list;
    }
	/*
	 * 图表41
	 */
	public List<Map<String, Object>> SecondWaterSupplyNewData_Data(String address) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT station_info '名称',evalue '值' FROM hssw.t_hssw_realtime WHERE station_name= ?;");
        params.add(address);
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(),params.toArray());
        return list;
    }
	/*
	 * 图表42
	 */
	public List<Map<String, Object>> SecondWaterSupplyHistoryData_Days_Data(String address, String startTime, String endTime) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT date_format(inserttime,'%Y-%m-%d %H:%i:%S') as '时间',station_info '名称',evalue '值' FROM hssw.t_hssw_history WHERE station_name = ? AND inserttime BETWEEN ? AND ? AND ( station_info =\"进水压力\" OR station_info=\"出水压力\" OR station_info LIKE \"%泵电流\" OR station_info = \"频率\" );");
        params.add(address);
        params.add(startTime+" 00:00:00");
        params.add(endTime+" 23:59:59");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
	
	public List<Map<String, Object>> SecondWaterSupplyHistoryData_Day_Data(String address, String time) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("SELECT date_format(inserttime,'%Y-%m-%d %H:%i:%S') as '时间',station_info '名称',evalue '值' FROM hssw.t_hssw_history WHERE station_name = ? AND inserttime LIKE ?  station_info =\"进水压力\" ;");
        params.add(address);
        params.add(time+"%");
        List<Map<String , Object>> list =baseDao.findListBySql(sql.toString(), params.toArray());
        return list;
    }
}


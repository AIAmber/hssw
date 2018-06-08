package cn.com.sparknet.common.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class DashboardDao {

    @Resource
    private BaseDao baseDao;

    /**
     * data of line, 便于统计异常出现的次数, {normal:xxx; error:xxx}
     *
     * @param
     * @return List
     * @throws Exception
     */
    public List<Map<String, Object>> listLine() {
        // data - pie
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT STATE FROM T_NCLK_EXAMROOM ");

        return baseDao.findListBySql(sql.toString(), new Object[]{});
    }

    /**
     * 保存或者修改图片
     *
     * @param userId
     * @param photo
     * @return
     * @throws IOException
     */
    public int savePicture(String userId, byte[] photo) throws IOException {
        String sql = "UPDATE T_HSSW_USER SET PHOTO = ? WHERE USER_ID = ? ";
        return baseDao.updateBySql(sql, new Object[]{photo, userId});
    }

    /**
     * 查询fixList
     *
     * @param userId
     * @return
     * @throws IOException
     */
    public List<Map<String, Object>> fixList(String userId){
//        String sql="UPDATE T_HSSW_USER SET PHOTO = ? WHERE USER_ID = ? ";
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT h.HL_NO, h.HL_TITLE, h.HL_CONTENT, h.HL_AREA, h.HL_ADDR, h.STATE, h.DEAL_TIME, h.CREATE_TIME, h.HL_FPERSON, h.HL_FPHONE ");
        sql.append(" FROM t_hssw_hotline h, t_hssw_user_hl uh, t_hssw_user u ");
        sql.append(" WHERE u.USER_ID = uh.USER_ID AND uh.USER_HL_ID = h.HL_ID AND u.USER_ID = ?; ");

        return baseDao.findListBySql(sql.toString(), new Object[]{userId});
    }

    /**
     * 查询hotlineList
     *
     * @param
     * @return
     * @throws IOException
     */
    public List<Map<String, Object>> hotlineList(){
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT h.HL_NO, h.HL_TITLE FROM t_hssw_hotline h");

        return baseDao.findListBySql(sql.toString(), new Object[]{});
    }

    /**
     * 查询hotlineList
     *
     * @param
     * @return
     * @throws IOException
     */
    public List<Map<String, Object>> hotlineDetail(String hotlineNo){
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT h.HL_NO, h.HL_TITLE, h.HL_CONTENT, h.HL_AREA, h.HL_ADDR, h.STATE, h.DEAL_TIME, h.CREATE_TIME, h.HL_FPERSON, h.HL_FPHONE ");
        sql.append(" FROM t_hssw_hotline h");
        sql.append(" WHERE h.HL_NO = ?");

        return baseDao.findListBySql(sql.toString(), new Object[]{hotlineNo});
    }

    /**
     * 插入fixList
     *
     * @param hotlineId
     * @return
     * @throws IOException
     */
    public void insertFixList(String hotlineId, String hotlineNo, String hotlineTitle, String hotlineContent, String fixPerson, String fixPhone,
                              String fixArea, String fixAddr){
//        String sql="INSERT INTO T_NCLK_USER_AUTH(USER_AUTH_ID,USER_ID,MODULE_ID) VALUES(?,?,?) ";
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append(" INSERT INTO `hssw`.`t_hssw_hotline` ");
        sql.append(" (`HL_ID`,`HL_NO`,`HL_TITLE`,`HL_CONTENT`,`HL_FPERSON`,`HL_FPHONE`,`HL_AREA`,`HL_ADDR`,`STATE`) ");
        sql.append(" VALUES(?,?,?,?,?,?,?,?,?); ");
        params.add(hotlineId);
        params.add(hotlineNo);
        params.add(hotlineTitle);
        params.add(hotlineContent);
        params.add(fixPerson);
        params.add(fixPhone);
        params.add(fixArea);
        params.add(fixAddr);
        params.add("A");

        baseDao.updateBySql(sql.toString(), params.toArray());
    }

}

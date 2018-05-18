package cn.com.sparknet.common.dao;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

/**
 * 系统登录
 * @author wuyl
 *
 */
@Repository
public class LoginDao {

    @Resource
    private BaseDao baseDao;

    /**
     * 查询用户
     */
    public Map<String,Object> findUser(String username) throws Exception {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT USER_ID,NAME,USER_NAME,USER_PASSWORD,LOGIN_ERROR_COUNT,STATE,LOGIN_DATE,LOCK_DATE FROM T_HSSW_USER WHERE USER_NAME = ? ");
        return baseDao.findMapBySql(sql.toString(),new Object[]{username});
    }

    /**
     * 更新用户登录信息
     */
    public void updateUserLoginInfo(String userId,long loginErrorCount,String state,Date lockDate) throws Exception {
        String hql="UPDATE T_HSSW_USER SET LOGIN_DATE = ?,LOGIN_ERROR_COUNT=?,STATE=?,LOCK_DATE=? WHERE USER_ID=?";
        baseDao.updateBySql(hql, new Object[]{new Date(),loginErrorCount,state,lockDate,userId});
    }

    /**
     * 查询数据库当前时间
     */
    public Map<String,Object> selectDataBaseCurrentTime() throws Exception {
        String hql="SELECT NOW() AS DATABASETIME ";
        return baseDao.findMapBySql(hql,new Object[]{});
    }

}


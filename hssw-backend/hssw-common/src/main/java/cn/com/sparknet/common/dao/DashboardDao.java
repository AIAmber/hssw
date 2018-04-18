package cn.com.sparknet.common.dao;

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
}

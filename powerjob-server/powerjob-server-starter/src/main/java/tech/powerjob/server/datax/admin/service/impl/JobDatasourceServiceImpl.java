package tech.powerjob.server.datax.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import tech.powerjob.server.datax.admin.entity.JobDatasource;
import tech.powerjob.server.datax.admin.mapper.JobDatasourceMapper;
import tech.powerjob.server.datax.admin.service.JobDatasourceService;
import tech.powerjob.server.datax.admin.tool.query.BaseQueryTool;
import tech.powerjob.server.datax.admin.tool.query.HBaseQueryTool;
import tech.powerjob.server.datax.admin.tool.query.MongoDBQueryTool;
import tech.powerjob.server.datax.admin.tool.query.QueryToolFactory;
import tech.powerjob.server.datax.admin.util.AESUtil;
import tech.powerjob.server.datax.admin.util.JdbcConstants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by jingwk on 2020/01/30
 */
@Service
@Transactional(readOnly = true)
public class JobDatasourceServiceImpl extends ServiceImpl<JobDatasourceMapper, JobDatasource> implements JobDatasourceService {

//    @Resource
    @Autowired
    private JobDatasourceMapper jobDatasourceMapper;

    @Override
    public Boolean  dataSourceTest(JobDatasource jobDatasource) throws IOException {
        if (JdbcConstants.HBASE.equals(jobDatasource.getDatasource())) {
            return new HBaseQueryTool(jobDatasource).dataSourceTest();
        }
        String userName = AESUtil.decrypt(jobDatasource.getJdbcUsername());
        //  判断账密是否为密文
        if (userName == null) {
            jobDatasource.setJdbcUsername(AESUtil.encrypt(jobDatasource.getJdbcUsername()));
        }
        String pwd = AESUtil.decrypt(jobDatasource.getJdbcPassword());
        if (pwd == null) {
            jobDatasource.setJdbcPassword(AESUtil.encrypt(jobDatasource.getJdbcPassword()));
        }
        if (JdbcConstants.MONGODB.equals(jobDatasource.getDatasource())) {
            return new MongoDBQueryTool(jobDatasource).dataSourceTest(jobDatasource.getDatabaseName());
        }
        BaseQueryTool queryTool = QueryToolFactory.getByDbType(jobDatasource);
        return queryTool.dataSourceTest();
    }

    @Override
    public int update(JobDatasource datasource) {
        return jobDatasourceMapper.update(datasource);
    }

    @Override
    public List<JobDatasource> selectAllDatasource() {
        return jobDatasourceMapper.selectList(null);
    }

}
package tech.powerjob.server.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import tech.powerjob.server.web.entity.JobDatasource;

/**
 * jdbc数据源配置表数据库访问层
 *
 * @author zhouhongfa@gz-yibo.com
 * @version v1.0
 * @since 2019-07-30
 */
@Mapper
public interface JobDatasourceMapper extends BaseMapper<JobDatasource> {
    int update(JobDatasource datasource);

}
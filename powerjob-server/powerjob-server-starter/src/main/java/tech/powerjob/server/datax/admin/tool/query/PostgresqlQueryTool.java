package tech.powerjob.server.datax.admin.tool.query;

import tech.powerjob.server.datax.admin.entity.JobDatasource;

import java.sql.SQLException;

/**
 * TODO
 *
 * @author zhouhongfa@gz-yibo.com
 * @ClassName PostgresqlQueryTool
 * @Version 1.0
 * @since 2019/8/2 11:28
 */
public class PostgresqlQueryTool extends BaseQueryTool implements QueryToolInterface {
    public PostgresqlQueryTool(JobDatasource jobDatasource) throws SQLException {
        super(jobDatasource);
    }

}

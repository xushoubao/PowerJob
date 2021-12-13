package tech.powerjob.server.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tech.powerjob.server.web.entity.JobGroup;

import java.util.List;

/**
 * Created by xuxueli on 16/9/30.
 */
@Mapper
public interface JobGroupMapper {

    List<JobGroup> findAll();

    List<JobGroup> find(@Param("appName") String appName,
                        @Param("title") String title,
                        @Param("addressList") String addressList);

    int save(JobGroup jobGroup);
    List<JobGroup> findByAddressType(@Param("addressType") int addressType);

    int update(JobGroup jobGroup);

    int remove(@Param("id") int id);

    JobGroup load(@Param("id") int id);
}

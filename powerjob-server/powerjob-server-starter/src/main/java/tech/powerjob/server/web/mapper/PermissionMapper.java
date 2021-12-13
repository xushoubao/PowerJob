package tech.powerjob.server.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tech.powerjob.server.web.entity.JobPermission;

import java.util.List;

@Mapper
@Repository
public interface PermissionMapper {

    List<JobPermission> findAll();

    List<JobPermission> findByAdminUserId(int userId);
}
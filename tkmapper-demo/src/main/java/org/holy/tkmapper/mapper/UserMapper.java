package org.holy.tkmapper.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.holy.tkmapper.common.magger.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @Description //TODO
 * @Author holyl
 * @Date 2019/9/2 15:28
 * @Version 1.0.0
 */
@Mapper
@Repository
public interface UserMapper<T> extends BaseMapper<T> {
}

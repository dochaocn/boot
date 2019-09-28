package com.dc.plus.mapper;

import com.dc.plus.entity.BhError;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dc.plus.entity.Error;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 * 反馈错误信息表 Mapper 接口
 * </p>
 *
 * @author Dc
 * @since 2019-09-26
 */
public interface BhErrorMapper extends BaseMapper<BhError> {

    @Select("select REQ_ID,ERROR_TYPE,ERROR_CODE from bh_error where req_id = #{reqId}")
    @Results(id="errorMap", value={
            @Result(column="REQ_ID", property="req", id=true),
            @Result(column="ERROR_TYPE", property="type")})
//    @ResultMap("errorMap")
    Error selectReport(@Param("reqId")String reqId);
}

package com.bsb.rps.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bsb.rps.entity.BhTotalCust;

import java.util.Map;

/**
 * <p>
 * 个人信息全量表 Mapper 接口
 * </p>
 *
 * @author Dc
 */
public interface BhTotalCustMapper extends BaseMapper<BhTotalCust> {

    void deleteCust(Map<String, String> param);

    void insertCust(Map<String, String> param);
}

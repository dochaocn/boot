package com.bsb.rps.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bsb.rps.entity.BhTotalCredit;

import java.util.Map;

/**
 * <p>
 * 授信信息全量表 Mapper 接口
 * </p>
 *
 * @author Dc
 */
public interface BhTotalCreditMapper extends BaseMapper<BhTotalCredit> {

    void insertCredit(Map<String, String> param);

    void deleteCredit(Map<String, String> param);
}

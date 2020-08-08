package com.bsb.rps.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bsb.rps.entity.BhTotalLoan;

import java.util.Map;

/**
 * <p>
 * 借据信息全量表 Mapper 接口
 * </p>
 *
 * @author Dc
 */
public interface BhTotalLoanMapper extends BaseMapper<BhTotalLoan> {

    void deleteLoan(Map<String, String> param);

    void insertLoan(Map<String, String> param);
}

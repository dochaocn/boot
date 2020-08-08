package com.bsb.rps.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bsb.rps.entity.BhSysProd;
import com.bsb.rps.mapper.BhSysProdMapper;
import com.bsb.rps.service.IBhSysProdService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品表 服务实现类
 * </p>
 *
 * @author Dc
 */
@Service
public class BhSysProdServiceImpl extends ServiceImpl<BhSysProdMapper, BhSysProd> implements IBhSysProdService {

    @Override
    @Cacheable(value = "prod", key = "#prodSubNo")
    public BhSysProd getByProdSubNo(String prodSubNo) {
        QueryWrapper<BhSysProd> wrapper = new QueryWrapper<>();
        wrapper.eq("PROD_SUB_NO", prodSubNo);
        return this.getOne(wrapper);
    }

}

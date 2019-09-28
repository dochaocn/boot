package com.bsb.rps.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bsb.rps.entity.BhSysProd;
import com.bsb.rps.mapper.BhSysProdMapper;
import com.bsb.rps.service.IBhSysProdService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public BhSysProd selectOneByProdSubNo(String prodSubNo) {
        QueryWrapper<BhSysProd> wrapper = new QueryWrapper<>();
        wrapper.eq("prod_sub_no", prodSubNo);
        return this.getOne(wrapper);
    }

    @Override
    public List<BhSysProd> selectAll() {
        return this.list();
    }

    @Override
    public List<BhSysProd> selectPage(Page<BhSysProd> iPage) {
        QueryWrapper<BhSysProd> wrapper = new QueryWrapper<>();
        wrapper.eq("LOOP_STATUS", "N");
        return this.page(iPage, wrapper).getRecords();
    }
}

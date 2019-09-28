package com.bsb.rps.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bsb.rps.entity.BhSysProd;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 产品表 服务类
 * </p>
 *
 * @author Dc
 */
public interface IBhSysProdService extends IService<BhSysProd> {

    BhSysProd selectOneByProdSubNo(String prodSubNo);

    List<BhSysProd> selectAll();

    List<BhSysProd> selectPage(Page<BhSysProd> iPage);
}

package com.bsb.rps.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bsb.rps.entity.BhSysProd;

/**
 * <p>
 * 产品表 服务类
 * </p>
 *
 * @author Dc
 */
public interface IBhSysProdService extends IService<BhSysProd> {

    BhSysProd getByProdSubNo(String prodSubNo);

}

package com.bsb.rps.service.impl;

import com.bsb.rps.entity.BhLogError;
import com.bsb.rps.mapper.BhLogErrorMapper;
import com.bsb.rps.service.IBhLogErrorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 反馈错误信息表 服务实现类
 * </p>
 *
 * @author Dc
 */
@Service
public class BhLogErrorServiceImpl extends ServiceImpl<BhLogErrorMapper, BhLogError> implements IBhLogErrorService {

}

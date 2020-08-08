package com.dc.plus.service.impl;

import com.dc.plus.entity.BhError;
import com.dc.plus.mapper.BhErrorMapper;
import com.dc.plus.service.IBhErrorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 反馈错误信息表 服务实现类
 * </p>
 *
 * @author Dc
 * @since 2019-09-26
 */
@Service
public class BhErrorServiceImpl extends ServiceImpl<BhErrorMapper, BhError> implements IBhErrorService {

}

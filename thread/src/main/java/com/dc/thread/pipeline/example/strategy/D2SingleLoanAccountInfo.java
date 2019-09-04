package com.dc.thread.pipeline.example.strategy;

import org.springframework.stereotype.Component;

/**
 * 单笔贷款账户数据信息（对应数据接口 D2：单笔贷款账户数据上报接口）
 * 包含如下数据项内容：
 * 请求记录唯一编号,姓名,身份证号码,手机号码,贷款编号,原贷款编号,贷款担保类型,贷款用途,
 * 贷款申请时间,账户开立时间,贷款放款时间,贷款到期日期,贷款金额,还款总期数,账单日类型,
 * 每期还款周期,账单日列表,首次还款日,逾期宽限期,设备信息,设备类型,设备IMEI/MEID,
 * MAC 地址,IP 地址,设备操作系统标签,信息获取时间戳,数据操作标识
 *
 * @author dc
*/

@Component
public class D2SingleLoanAccountInfo extends AbstractReportStrategy {

    @Override
    public boolean isThis(Object object) {
        return false;
    }

    @Override
    public void execute(Object object) {

    }
}

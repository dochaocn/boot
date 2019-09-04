package com.dc.thread.pipeline.example.strategy;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 循环授信账户数据信息（对应数据接口 X2：循环授信账户数据上报接口）
 * 包含如下数据项内容：
 * 请求记录唯一编号,姓名,身份证号码,手机号码,
 * 授信账户操作代码,循环授信账户编号,授信担保类型,授信申请时间,授信账户开立时间,授信到期日期,
 * 授信额度,授信账户状态,固定账单日,固定还款日,逾期宽限期,授信账户信息变动时间,
 * 设备信息,设备类型,设备MEI/MEID,MAC 地址,IP 地址,设备操作系统标签,信息获取时间戳,数据操作标识
 *
 * @author dc
 */

@Component
public class X2LoopLoanAccountInfo extends AbstractReportStrategy {

    @Override
    public boolean isThis(Object object) {
        String str = (String) object;
        return "X2LoopLoanAccountInfo".equals(str);
    }

    @Override
    public void execute(Object object) {
        super.simplePipeline.process(object);
    }

    @PostConstruct
    public void buildStage() {
        super.stageList.add(super.stageOne);
        super.stageList.add(super.stageTwo);
        super.stageList.add(super.stageThree);
        super.stageList.add(super.stageFour);
        super.useAsyncOrSync();
    }
}

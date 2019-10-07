package com.bsb.rps.handler.impl.step;

import com.bsb.rps.dto.MachiningRecord;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class D3AndCL2RepayFlow extends AbstractStep {

    @Override
    public MachiningRecord doProcess(MachiningRecord record) {
        return record;
    }
}

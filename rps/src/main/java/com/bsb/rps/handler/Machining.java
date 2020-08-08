package com.bsb.rps.handler;

import com.bsb.rps.dto.MachiningRecord;

import javax.validation.constraints.NotNull;

public interface Machining {

    boolean judge(@NotNull MachiningRecord record);

    void process(@NotNull MachiningRecord record);

}

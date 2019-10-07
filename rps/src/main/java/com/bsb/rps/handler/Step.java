package com.bsb.rps.handler;

import com.bsb.rps.dto.MachiningRecord;

import javax.validation.constraints.NotNull;

/**
 * 对处理阶段的抽象。
 * 负责对输入进行处理，并将输出作为下一处理阶段的输入
 *
 * @author Dc
 */
public interface Step {

    void setNextStep(@NotNull Step step);

    void process(@NotNull MachiningRecord input);
}

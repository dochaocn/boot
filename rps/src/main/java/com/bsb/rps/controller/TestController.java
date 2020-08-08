package com.bsb.rps.controller;

import com.bsb.rps.handler.HandlerClient;
import com.bsb.rps.imports.ImportClient;
import com.bsb.rps.manager.ProcessDateManager;
import com.bsb.rps.validate.ValidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class TestController {

    @Resource
    private ValidateService validateService;
    @Resource
    private HandlerClient handlerClient;
    @Resource
    private ImportClient importClient;

    @RequestMapping(value = "/handler", method = RequestMethod.GET)
    public void importAndHandler(String processDate) {
        processDate = "2019-10-01";
        log.info("已提交，执行中...");
        ProcessDateManager.setProcessDate(processDate);
        importClient.startImport();
        handlerClient.startHandler();
    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public void validate() {
        log.info("已提交，执行中...");
        validateService.startValidate();
    }

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public void report() {
        log.info("已提交，执行中...");
    }

}

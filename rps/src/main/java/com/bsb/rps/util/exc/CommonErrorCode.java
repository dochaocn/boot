package com.bsb.rps.util.exc;

public enum CommonErrorCode implements ErrorCode {

    /**
     * 前3位固定为系统码：COM  第4,5位为子系统码：BL 第6位表示日志级别：W/E/F   第7位系统错误类型：B业务类型/S系统类型    最后三位：A公共错误码/B批量错误码/数字则为普通错误码+序号
     * W 业务告警，warn日志，E业务异常，error日志，F明业务异常，但非常严重，需要报警，error日志
     */

    /***
     * 公用错误码
     */

    ALARM("COMCCF0000"),//报警
    SUCCESS("COMCC00000"), // 处理成功
    UNKHOWN_ERROR("COMCCES999"), // 未知错误
    ERROR_NULL_RECORD("COMCCWB888"), // 查无此记录

    /***
     * WB--业务WARN--公用错误码--COMCCWBA01-COMCCWBA99
     */
    //参数异常
    NULL_PROPERTIES("COMCCWBA01"), // 参数【{0}】为空
    ERROR_PARAM_FORMAT("COMCCWBA02"), // 参数【{0}】格式错误
    ERROR_PARAM_VALUE("COMCCWBA03"), // 参数【{0}】错误
    ERROR_PARAM_LENGTH("COMCCWBA04"), // 参数【{0}】长度错误
    ERROR_PARAM_NOT_MATCH("COMCCWBA05"), // {0}不匹配
    ERROR_PARAM_SHOULD_MORETHAN_ZERO("COMCCWBA06"), // 参数【{0}】应大于0
    ERROR_PARAM_X_SHOULD_MORETHAN_OR_EQUAL_Y("COMCCWBA07"), //{0}应大于或等于{1}
    ERROR_PARAM_FORBIT_MODIFY("COMCCWBA08"), // {0}不能修改
    ERROR_PARAM_SHOULD_MORETHAN_OR_EQUAL_ZERO("COMCCWBA09"), // 参数【{0}】应大于或等于0
    ERROR_NOT_EXISTS("COMCCWBA10"), // {0}不存在
    ERROR_STRING_PARSE("COMCCWBA11"),//解析字符串{0}时错误
    ERROR_DATA_DUPLICATE("COMCCWBA12"),//{0}数据超过一条

    /***
     * EB--业务ERROR--公用错误码--COMCCEBA01-COMCCEBA99
     */
    //文件操作异常
    ERROR_FILE_NAME_FORMAT("COMCCEBA01"),//{0}文件名格式错误
    ERROR_FILE_CREATE("COMCCEBA02"),//创建{0}文件失败
    ERROR_FILE_WRITE("COMCCEBA03"),//写入{0}文件失败
    ERROR_FILE_UPLOAD("COMCCEBA04"),//上传{0}文件失败
    ERROR_FILE_DOWNLOAD("COMCCEBA05"),//下载{0}文件失败
    ERROR_FILE_WRITE_HEADER("COMCCEBA06"),//写入{0}文件头失败
    ERROR_FILE_NOT_FIND("COMCCEBA07"),//没有找到{0}文件
    ERROR_FILE_NO_FIND_REMOTE_FILE("COMCCEBA08"),//远程服务器未找到{0}文件
    ERROR_FILE_FLUSH("COMCCEBA09"),//{0}文件flush出现异常
    ERROR_FILE_PARSE("COMCCEBA10"),//解析{0}文件失败
    ERROR_FILE_FORMAT("COMCCEBA11"),//{0}文件格式不正确
    ERROR_FILE_HEADER_FORMAT("COMCCEBA12"),//{0}文件头格式不正确

    /***
     * ES--系统ERROR--公用错误码--COMCCESA01-COMCCESA99
     */
    //数据库操作异常
    ERROR_TABLE_INSERT("COMCCESA01"),//写入{0}表失败
    ERROR_TABLE_UPDATE("COMCCESA02"),//更新{0}表失败
    ERROR_TABLE_QUERY("COMCCESA03"),//查询{0}失败
    ERROR_DATABASE_INVOKE_PROC("COMCCESA04"),//调用存储过程{0}失败
    ERROR_DATABASE_ACCESS("COMCCESA05")//数据库访问异常
    ;


    private String code;

    private CommonErrorCode(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }

}

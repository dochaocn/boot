package com.bsb.rps.util.exc;

import java.text.MessageFormat;

/**
 *
 * <b>类说明：</b>Service层统一抛出的异常
 *
 * <p>
 * <b>详细描述：</b>
 *
 * @author costin_law
 * @since 2014-5-5
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 6514891174875747380L;


    /** 异常错误码 **/
    private String code;

    /** 异常描述 **/
    private String msg;
    /** 扩展异常描述（包括msg） **/
    private String extMsg;

    /**
     * ServiceException构造方法，有format字符组
     * @param errorCode 错误码
     * @param param     format字符组
     * @param extMsg    扩展信息，给出具体的错误值信息等
     */
    public ServiceException(ErrorCode errorCode, String param[], String ... extMsg) {
        super(null==errorCode ? "" : errorCode.getCode());
        init(errorCode, param,extMsg);
    }

    private void init(ErrorCode errorCode, Object param[], String... extMsg) {
        this.code = null==errorCode ? "" : errorCode.getCode();
        String msgPatten = Property.getProperty(errorCode.getCode());
        msgPatten = (msgPatten== null ? "" : msgPatten);
        this.msg = null==errorCode ? "" : MessageFormat.format(msgPatten,param);
        StringBuilder builder = new StringBuilder(100);
        builder.append(this.msg);
        if(null != extMsg){
            for(String ext : extMsg ){
                builder.append("[").append(ext).append("]");
            }
        }
        this.extMsg = builder.toString();
    }

    /**
     *
     * @param code  错误码
     * @param msg 描述信息
     */
    public ServiceException(String code, String msg) {
        super(code+":"+msg);
        this.code = code;
        this.msg = msg;
    }

    /**
     * 带Exception的构造方法，传format字符数组
     * @param errorCode 错误码基类
     * @param e  异常
     * @param extMsg    扩展信息，给出具体的错误值信息等
     */
    public ServiceException(ErrorCode errorCode, Throwable e,String param[] , String ...extMsg ) {
        super(null==errorCode ? "" : errorCode.getCode(), e);
        init(errorCode, param, extMsg);
    }

    /**
     *
     * @param code 错误码
     * @param msg 描述信息
     * @param e  异常
     */
	/*public ServiceException(String code, String msg,Throwable e) {
		super(code+":"+msg, e);
		this.code = code;
		this.msg = msg;
	}*/

    /**
     *
     *
     * 方法说明：异常错误码
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     *
     * 方法说明：异常描述信息
     *
     * @return
     */
    public String getMsg() {
        return msg;
    }

    public String getExtMsg() {
        return extMsg;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + ","+extMsg;
    }



}

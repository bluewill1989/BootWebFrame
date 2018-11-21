package com.wzn.bootwebframe.common.util;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2017/11/8.
 */
@Getter
@Setter
public class BusinessException extends Exception {

    public static final String ERROR01 = "0001";
    public static final String ERROR01_INFO = "系统内部错误";
    private String errCode;
    private String errInfo;
    private Object[] errParams;
    private String errDetailInfo;
    private String respCode;
    private static final long serialVersionUID = 6068482856957638175L;
    public static final String TRACE_PREFIX = "***exception_logger_prefix***";
    public static final String KEY_DELIMIT = "|";

    public BusinessException() {
        this("0001", "系统内部错误");
    }

    public BusinessException(String errInfo) {
        this("0001", errInfo);
    }

    public BusinessException(String errCode, String errInfo) {
        this(errCode, errInfo, errInfo);
    }

    public BusinessException(String errCode, String errInfo, String errDetailInfo) {
        super(errInfo);
        this.errCode = errCode;
        this.errInfo = errInfo;
        this.errDetailInfo = errDetailInfo;
    }

    public BusinessException(String errCode, String errInfo, String errDetailInfo, Throwable cause) {
        super(errInfo, cause);
        this.errCode = errCode;
        this.errInfo = errInfo;
        this.errDetailInfo = errDetailInfo;
    }

    public BusinessException(String errInfo, Throwable cause) {
        this("0001", errInfo, cause);
    }

    public BusinessException(String errCode, String errInfo, Throwable cause) {
        this(errCode, errInfo, errInfo, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public static BusinessException newBusinessExceptionByCode(String errCode) {
        BusinessException ex = new BusinessException();
        ex.setErrCode(errCode);
        return ex;
    }

    public static BusinessException newBusinessExceptionByCode(String errCode, Exception e) {
        BusinessException ex = new BusinessException(e);
        ex.setErrCode(errCode);
        return ex;
    }

    public static BusinessException newBusinessExceptionByCodeAndParams(String errCode, Object[] params) {
        BusinessException ex = new BusinessException();
        ex.setErrCode(errCode);
        ex.setErrParams(params);
        return ex;
    }
}

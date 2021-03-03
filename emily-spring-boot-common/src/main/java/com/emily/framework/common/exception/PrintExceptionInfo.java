package com.emily.framework.common.exception;

import com.emily.framework.common.utils.constant.CharacterUtils;
import com.emily.framework.common.utils.log.LoggerUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @program: spring-parent
 * @description: 获取打印异常日志信息
 * @create: 2020/08/24
 */
public class PrintExceptionInfo {
    /**
     * @Description 打印错误日志信息
     * @Version 1.0
     */
    public static String printErrorInfo(Throwable e) {
        String message = e.toString();
        StackTraceElement[] elements = e.getStackTrace();
        for (int i = 0; i < elements.length; i++) {
            StackTraceElement element = elements[i];
            if (i == 0) {
                message = StringUtils.join(element.toString(), " ", message);
            } else {
                message = StringUtils.join(message, CharacterUtils.ENTER, element.toString());
            }
        }
        return message;
    }

    /**
     * 获取异常堆栈信息并记录到error文件中
     * @param e
     * @param isRecord 是否记录到error文件
     * @return
     */
    public static String printErrorInfo(Throwable e, boolean isRecord) {
        String errorMssg = printErrorInfo(e);
        if (isRecord) {
            LoggerUtils.error(PrintExceptionInfo.class, errorMssg);
        }
        return errorMssg;
    }
}

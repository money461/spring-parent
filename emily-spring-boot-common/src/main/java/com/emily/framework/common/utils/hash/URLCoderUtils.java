package com.emily.framework.common.utils.hash;

import com.emily.framework.common.enums.AppHttpStatus;
import com.emily.framework.common.exception.BusinessException;
import com.emily.framework.common.utils.constant.CharsetUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @description: URL编码解码工具类 application/x-www-form-rulencoded MIME字符串之间的转换
 * @create: 2020/07/29
 */
public class URLCoderUtils {
    /**
     * URL数据编码，默认UTF8
     *
     * @param content 数据类型
     * @return
     */
    public static String decode(String content) {
        return decode(content, CharsetUtils.UTF_8);
    }

    /**
     * URL数据解码
     *
     * @param content 数据字符串
     * @param enc     编码
     * @return
     */
    public static String decode(String content, String enc) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        try {
            return URLDecoder.decode(content, enc);
        } catch (UnsupportedEncodingException e) {
            throw new BusinessException(AppHttpStatus.ILLEGAL_ARGUMENT_EXCEPTION);
        }
    }

    /**
     * URL数据编码，默认UTF8
     *
     * @param content 数据类型
     * @return
     */
    public static String encode(String content) {
        return encode(content, CharsetUtils.UTF_8);
    }

    /**
     * URL数据编码
     *
     * @param content 数据字符串
     * @param enc     编码
     * @return
     */
    public static String encode(String content, String enc) {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        try {
            return URLEncoder.encode(content, enc);
        } catch (UnsupportedEncodingException e) {
            throw new BusinessException(AppHttpStatus.ILLEGAL_ARGUMENT_EXCEPTION);
        }
    }

}

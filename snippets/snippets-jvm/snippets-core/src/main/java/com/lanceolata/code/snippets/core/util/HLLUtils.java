package com.lanceolata.code.snippets.core.util;

import com.lanceolata.code.snippets.core.model.HLL;

/**
 * HLL工具类
 */
public class HLLUtils {
    /**
     * 字符串转HLL
     *
     * @param str
     * @return
     */
    public static HLL toHLL(String str) {
        return new HLL().update(str);
    }
}

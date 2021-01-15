package com.lanceolata.code.snippets.core.util.crypto;

import com.lanceolata.code.snippets.core.util.BytesUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestHmacSha1Utils {
    private static String key = "lanceolata";
    private static String content = "com.lanceolata.common.util.TestHmacSha1Utils";
    private static String result = "62616efd4f918e104dd1b18f207e34ddf1182671";

    @Test
    public void testEncrypt() throws Exception {
        byte[] bytes = HmacSha1Utils.encrypt(content.getBytes(), key.getBytes());
        String res = BytesUtils.encodeHexString(bytes);
        Assert.assertEquals(result, res);
    }
}

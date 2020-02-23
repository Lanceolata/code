package com.lanceolata.coding.snippets.common.java.utils.bitmap;

import com.googlecode.javaewah.EWAHCompressedBitmap;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EWAHCompressedBitmapUtils {
    public static byte[] serialize(EWAHCompressedBitmap bitmap) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.serialize(new DataOutputStream(bos));
        return bos.toByteArray();
    }

    public static EWAHCompressedBitmap deserialize(byte[] bytes) throws IOException {
        EWAHCompressedBitmap bitmap = new EWAHCompressedBitmap();
        bitmap.deserialize(new DataInputStream(new ByteArrayInputStream(bytes)));
        return bitmap;
    }

    public static List<Integer> toList(EWAHCompressedBitmap bitmap) {
        return bitmap.toList();
    }

    public static Set<Integer> toSet(EWAHCompressedBitmap bitmap) {
        Set<Integer> set = new HashSet<>();
        Iterator<Integer> it = bitmap.iterator();
        while (it.hasNext()) {
            set.add(it.next());
        }
        return set;
    }
}

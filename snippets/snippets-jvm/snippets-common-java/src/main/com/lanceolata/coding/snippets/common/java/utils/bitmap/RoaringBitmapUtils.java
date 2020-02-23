package com.lanceolata.coding.snippets.common.java.utils.bitmap;

import org.roaringbitmap.RoaringBitmap;

import java.io.*;
import java.util.*;

public class RoaringBitmapUtils {
    public static byte[] serialize(RoaringBitmap bitmap) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.serialize(new DataOutputStream(bos));
        return bos.toByteArray();
    }

    public static RoaringBitmap deserialize(byte[] bytes) throws IOException {
        RoaringBitmap bitmap = new RoaringBitmap();
        bitmap.deserialize(new DataInputStream(new ByteArrayInputStream(bytes)));
        return bitmap;
    }

    public static List<Integer> toList(RoaringBitmap bitmap) {
        List<Integer> res = new ArrayList<>(bitmap.getCardinality());
        Iterator<Integer> it = bitmap.iterator();
        while (it.hasNext()) {
            res.add(it.next());
        }
        return res;
    }

    public static Set<Integer> toSet(RoaringBitmap bitmap) {
        Set<Integer> res = new HashSet<>();
        Iterator<Integer> it = bitmap.iterator();
        while (it.hasNext()) {
            res.add(it.next());
        }
        return res;
    }
}

package com.lanceolata.code.snippets.core.util;

import com.google.gson.*;
import java.util.List;

/**
 * Gson工具类
 */
public final class GsonUtils {
    private GsonUtils() {}

    /**
     * 默认Gson
     */
    public static final Gson gson = new Gson();
//    private static final Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create();
//    private static final Gson gson = new GsonBuilder().serializeNulls().create();

    /**
     * json转对象
     *
     * @param jsonStr
     * @param classOfT
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String jsonStr, Class<T> classOfT) {
        if (jsonStr == null) {
            return null;
        }
        return gson.fromJson(jsonStr, classOfT);
    }

    /**
     * 对象转json
     *
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static class Builder {
        private JsonObject obj = new JsonObject();

        public Builder add(String key, Number number) {
            this.obj.addProperty(key, number);
            return this;
        }

        public Builder add(String key, String string) {
            this.obj.addProperty(key, string);
            return this;
        }

        public Builder add(String key, Character character) {
            this.obj.addProperty(key, character);
            return this;
        }

        public Builder add(String key, Boolean bool) {
            this.obj.addProperty(key, bool);
            return this;
        }

        public Builder add(String key, JsonElement jsonElement) {
            this.obj.add(key, jsonElement);
            return this;
        }

        public Builder add(String key, List list) {
            this.obj.add(key, GsonUtils.gson.toJsonTree(list));
            return this;
        }

        public Builder add(String key, Object value) {
            this.obj.add(key, GsonUtils.gson.toJsonTree(value));
            return this;
        }

        public JsonObject build() {
            return this.obj;
        }
    }
}

package com.lanceolata.code.snippets.common.java.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lanceolata.code.snippets.common.java.exception.JsonException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonUtils {
    public static String beanToString(Object object) {
        return object == null ? null : getGson(false).toJson(object);
    }

    public static String beanToStringNulls(Object object) {
        return object == null ? null : getGson(true).toJson(object);
    }

    public static JsonObject stringToJson(String jsonString) throws JsonException {
        if (jsonString == null) {
            return null;
        } else {
            try {
                return (new JsonParser()).parse(jsonString).getAsJsonObject();
            } catch (RuntimeException var2) {
                throw new JsonException("String parse to JsonObject exception", var2);
            }
        }
    }

    public static JsonObject beanToJson(Object object) throws JsonException {
        if (object == null) {
            return null;
        } else {
            try {
                return (new JsonParser()).parse(getGson(true).toJson(object)).getAsJsonObject();
            } catch (RuntimeException var2) {
                throw new JsonException("Bean to JsonObject Exception", var2);
            }
        }
    }

    public static JsonArray stringToJsonArray(String jsonString) throws JsonException {
        if (jsonString == null) {
            return null;
        } else {
            try {
                return (new JsonParser()).parse(jsonString).getAsJsonArray();
            } catch (RuntimeException var2) {
                throw new JsonException("String to JsonArray Exception", var2);
            }
        }
    }

    public static JsonArray listToJsonArray(List list) {
        return list == null ? null : (new JsonParser()).parse(getGson(true).toJson(list)).getAsJsonArray();
    }

    public static JsonObject getJsonObject() {
        return new JsonObject();
    }

    public static Gson getGson(boolean serializeNulls) {
        Gson gson = new Gson();
        return serializeNulls ? gson.newBuilder().serializeNulls().create() : gson;
    }

    public static <T> List<T> stringToList(String jsonString, Class<T[]> clazz) throws JsonException {
        if (jsonString == null) {
            return null;
        } else {
            try {
                return new ArrayList(Arrays.asList((Object[])getGson(true).fromJson(jsonString, clazz)));
            } catch (RuntimeException var3) {
                throw new JsonException("string to List exception", var3);
            }
        }
    }

    public static <T> T stringToBean(String jsonString, Class<T> clazz) throws JsonException {
        try {
            return getGson(true).fromJson(jsonString, clazz);
        } catch (RuntimeException var3) {
            throw new JsonException("String to Bean Exception", var3);
        }
    }

    public static class Builder {
        private JsonObject json = JsonUtils.getJsonObject();

        public Builder() {
        }

        public JsonUtils.Builder add(String key, Number number) {
            this.json.addProperty(key, number);
            return this;
        }

        public JsonUtils.Builder add(String key, String string) {
            this.json.addProperty(key, string);
            return this;
        }

        public JsonUtils.Builder add(String key, Character character) {
            this.json.addProperty(key, character);
            return this;
        }

        public JsonUtils.Builder add(String key, Boolean bool) {
            this.json.addProperty(key, bool);
            return this;
        }

        public JsonUtils.Builder add(String key, JsonElement jsonElement) {
            this.json.add(key, jsonElement);
            return this;
        }

        public JsonUtils.Builder add(String key, List list) {
            this.json.add(key, JsonUtils.listToJsonArray(list));
            return this;
        }

        public JsonUtils.Builder add(String key, Object value) {
            this.json.add(key, (new JsonParser()).parse(JsonUtils.getGson(true).toJson(value)).getAsJsonObject());
            return this;
        }

        public JsonObject build() {
            return this.json;
        }
    }
}

package io.leangen.graphql.spqr.spring.autoconfigure;

import org.springframework.web.context.request.NativeWebRequest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultGlobalContext {

    private final NativeWebRequest nativeRequest;
    private final Map<String, Object> extensions;

    public DefaultGlobalContext(NativeWebRequest request) {
        this.nativeRequest = request;
        this.extensions = new ConcurrentHashMap<>();
    }

    public NativeWebRequest getNativeRequest() {
        return nativeRequest;
    }

    @SuppressWarnings("unchecked")
    public <T> T getExtension(String key) {
        return (T) extensions.get(key);
    }

    @SuppressWarnings("unchecked")
    public <T> T setExtension(String key, T value) {
        return (T) extensions.put(key, value);
    }
}

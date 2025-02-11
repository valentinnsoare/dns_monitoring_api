package io.valentinsoare.rianamonitoringapi.util;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import io.valentinsoare.rianamonitoringapi.response.ErrorMessage;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.TreeMap;

import static java.util.concurrent.TimeUnit.MINUTES;

@Component
public class QueryCache {
    private Cache<String, TreeMap<String, Object>> paramsCache;
    private Cache<String, String> zoneSoaCache;
    private Cache<String, String> nameserversCache;
    private Cache<String, ErrorMessage> errorCache;

    private void initializeQueryCache() {
        this.nameserversCache = Caffeine.newBuilder()
                .expireAfterAccess(60, MINUTES)
                .maximumSize(12)
                .build();

        this.paramsCache = Caffeine.newBuilder()
                .expireAfterAccess(60, MINUTES)
                .maximumSize(50)
                .build();

        this.zoneSoaCache = Caffeine.newBuilder()
                .expireAfterAccess(60, MINUTES)
                .maximumSize(250)
                .build();

        this.errorCache = Caffeine.newBuilder()
                .expireAfterAccess(15, MINUTES)
                .maximumSize(500)
                .build();
    }

    @PostConstruct
    public void init() {
        initializeQueryCache();
    }

    public TreeMap<String, Object> getOrCreate(String cacheKey, CacheValueProvider valueProvider) {
        return paramsCache.get(cacheKey, valueProvider::provide);
    }

    public String getZoneSoaRequest(String fqdn) {
        return zoneSoaCache.getIfPresent(fqdn);
    }

    public void putZoneSoaRequest(String fqdn, String zoneSoaRequest) {
        zoneSoaCache.put(fqdn, zoneSoaRequest);
    }

    public void removeZoneSoaRequest(String fqdn) {
        zoneSoaCache.invalidate(fqdn);
    }

    public String getNameserverCache(String name) {
        return nameserversCache.getIfPresent(name);
    }

    public void putNameserverCache(String name, String externalDnsAnswer) {
        nameserversCache.put(name, externalDnsAnswer);
    }

    public void removeNameserverCache(String name) {
        nameserversCache.invalidate(name);
    }

    public ErrorMessage getErrorCache(String key) {
        return errorCache.getIfPresent(key);
    }

    public void putErrorCache(String key, ErrorMessage errorMessage) {
        errorCache.put(key, errorMessage);
    }

    public void removeErrorCache(String key) {
        errorCache.invalidate(key);
    }

    public void clearParamsCache() {
        paramsCache.invalidateAll();
    }

    public void clearZoneSoaCache() {
        zoneSoaCache.invalidateAll();
    }

    public void clearNameserversCache() {
        nameserversCache.invalidateAll();
    }

    public void clearErrorCache() {
        errorCache.invalidateAll();
    }

    @FunctionalInterface
    public interface CacheValueProvider {
        TreeMap<String, Object> provide(String key);
    }
}

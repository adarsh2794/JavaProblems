package com.infa.market.cache.helpers;

import com.infa.market.cache.invalidations.LRUImpl;
import com.infa.market.cache.invalidations.MRUImpl;
import com.infa.market.cache.models.CacheEvictionPolicies;

@SuppressWarnings("unchecked")
public class InitializeCacheFactory<K, V> {
	@SuppressWarnings("rawtypes")
	private static volatile InitializeCacheFactory infraCache = null;
	private int DEFAULT_CACHE_SIZE = 30;
	private DefaultCache<K, V> cache = null;

	private InitializeCacheFactory() {

	}

	private InitializeCacheFactory(int size) {
		DEFAULT_CACHE_SIZE = size;
	}

	public InitializeCacheFactory<K, V> initCache(CacheEvictionPolicies policy) {
		if (policy == CacheEvictionPolicies.LRU)
			cache = new LRUImpl<K, V>(DEFAULT_CACHE_SIZE);
		else if (policy == CacheEvictionPolicies.MRU)
			cache = new MRUImpl<K, V>(DEFAULT_CACHE_SIZE);
		else
			throw new IllegalArgumentException("Invalid Eviction policy");
		return infraCache;
	}

	public static <K, V> InitializeCacheFactory<K, V> getInstance() {
		if (infraCache == null) {
			synchronized (InitializeCacheFactory.class) {
				if (infraCache == null)
					infraCache = new InitializeCacheFactory<K, V>();
			}
		}
		return infraCache;
	}
	
	public DefaultCache<K, V> getCache() {
		return cache;
	}
	
	public static <K, V> InitializeCacheFactory<K, V> getInstance(int cacheSize) {
		if (infraCache == null) {
			synchronized (InitializeCacheFactory.class) {
				if (infraCache == null)
					infraCache = new InitializeCacheFactory<K, V>(cacheSize);
			}
		}
		return infraCache;
	}
}

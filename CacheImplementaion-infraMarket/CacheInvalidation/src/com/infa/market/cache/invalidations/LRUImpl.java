package com.infa.market.cache.invalidations;

import com.infa.market.cache.helpers.DefaultCache;

public class LRUImpl<K, V> extends DefaultCache<K, V> {

	public LRUImpl(int sizeOfCache) {
		super(sizeOfCache);
	}

	@Override
	public V getValue(K key) {
		boolean remove = this.evictionList.remove(key);
		if(remove) {
			this.evictionList.addFirst(key);
			return data.get(key);
		}
		return null;
	}

	@Override
	public DefaultCache<K, V> insert(K key, V value) {
		if(checkIfCacheIsFull()) {
			removeDataFromFullCache();
		}
		this.evictionList.addFirst(key);
		this.data.put(key, value);
		return this;
	}

}

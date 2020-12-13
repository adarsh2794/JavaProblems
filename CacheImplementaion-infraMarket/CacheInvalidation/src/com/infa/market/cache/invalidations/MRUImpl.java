package com.infa.market.cache.invalidations;

import com.infa.market.cache.helpers.DefaultCache;

public class MRUImpl<K,V> extends DefaultCache<K, V> {

	public MRUImpl(int sizeOfCache) {
		super(sizeOfCache);
	}

	@Override
	public V getValue(K key) {
		boolean remove = this.evictionList.remove(key);
		if(remove) {
			this.evictionList.addLast(key);
			return this.data.get(key);
		}
		
		return null;
	}

	@Override
	public DefaultCache<K, V> insert(K key, V value) {
		if(checkIfCacheIsFull()) {
			this.removeDataFromFullCache();
		}
		this.evictionList.addLast(key);
		this.data.put(key, value);
		return this;
	}

}

package com.infa.market.cache.helpers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public abstract class DefaultCache<K, V> {

	int sizeOfCache = 0;
	public HashMap<K, V> data = null;
	public LinkedList<K> evictionList = null;

	public abstract V getValue(K key);
	public abstract DefaultCache<K, V> insert(K key, V value);
	
	public DefaultCache(int sizeOfCache){
		this.sizeOfCache = sizeOfCache;
		data = new HashMap<>(sizeOfCache);
		evictionList = new LinkedList<>();
	}
	
	public void removeDataFromFullCache() throws NoSuchElementException{
		K key = evictionList.removeLast();
		data.remove(key);	
	}
	
	public boolean checkIfCacheIsFull() {
		return data.size() == sizeOfCache;
	}

	
	public HashMap<K, V> getData() {
		return data;
	}
}

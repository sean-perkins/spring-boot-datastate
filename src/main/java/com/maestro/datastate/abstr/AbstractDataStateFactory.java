package com.maestro.datastate.abstr;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.maestro.example.ExampleObject;

/**
 * 
 * @author Sean Perkins <sean@meetmaestro.com>
 * @since  12/14/2015
 * @version 1.0.0
 *
 */
@Controller
public abstract class AbstractDataStateFactory {
	
	public AbstractDataStateFactory() {
		seed();
	}
	
	private LinkedHashMap<String, ArrayList<?>> seeds = new LinkedHashMap<String, ArrayList<?>>();
	
	protected void insertSeed(IDataStateObject dataStateObject) {
		seeds.put(dataStateObject.getKeyName(), dataStateObject.getValues());
	}
	
	public abstract void seed();
	
	public abstract DataStatePayload sync(Long lastSyncedAt);
	
	protected DataStatePayload getPayload(Long lastSyncedAt) {		
		return generatePayload(getNewInserts(lastSyncedAt), getNewDeletes(lastSyncedAt));
	}
	
	@SuppressWarnings("unchecked")
	private LinkedHashMap<String, ArrayList<?>> getNewInserts(Long lastSyncedAt) {
		LinkedHashMap<String, ArrayList<?>> newInserts = new LinkedHashMap<String, ArrayList<?>>();
		if(seeds == null)
			return newInserts;
		for(Map.Entry<String, ArrayList<?>> entry : seeds.entrySet()) {
			ArrayList<Object> updatedInserts = new ArrayList<Object>();
			ArrayList<ExampleObject> exampleCollection = (ArrayList<ExampleObject>) entry.getValue();
			for(int index = 0; index < exampleCollection.size(); index++) {
				ExampleObject example = exampleCollection.get(index);
				if(lastSyncedAt == null || example.getLastModifiedAt() > lastSyncedAt) {
					updatedInserts.add(((ArrayList<Object>) entry.getValue()).get(index));
				}
			}
			newInserts.put(entry.getKey(), updatedInserts);
		}
		return newInserts;
	}
	
	@SuppressWarnings("unchecked")
	private LinkedHashMap<String, ArrayList<?>> getNewDeletes(Long lastSyncedAt) {
		LinkedHashMap<String, ArrayList<?>> newDeletes = new LinkedHashMap<String, ArrayList<?>>();
		ArrayList<Object> updatedDeletes = new ArrayList<Object>();
		if(seeds == null || lastSyncedAt == null)
			return newDeletes;
		for(Map.Entry<String, ArrayList<?>> entry : seeds.entrySet()) {
			ArrayList<ExampleObject> exampleCollection = (ArrayList<ExampleObject>) entry.getValue();
			for(int index = 0; index < exampleCollection.size(); index++) {
				ExampleObject example = exampleCollection.get(index);
				if(example.getDeletedAt() > lastSyncedAt && example.isDeleted())
					updatedDeletes.add(((ArrayList<Object>)entry.getValue()).get(index));
			}
			newDeletes.put(entry.getKey(), updatedDeletes);
		}
		return newDeletes;
	}
	
	protected DataStatePayload generatePayload(LinkedHashMap<String, ArrayList<?>> inserts, LinkedHashMap<String, ArrayList<?>> deletes) {
		return new DataStatePayload(inserts, deletes);
	}
	
}

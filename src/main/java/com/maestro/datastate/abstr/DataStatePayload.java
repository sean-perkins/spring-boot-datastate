package com.maestro.datastate.abstr;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/**
 * 
 * @author  Sean Perkins <sean@meetmaestro.com>
 * @since   12/14/2015
 * @version 1.0.0
 *
 */
public class DataStatePayload {
	
	private LinkedHashMap<String, ArrayList<?>> inserts;
	
	private LinkedHashMap<String, ArrayList<?>> deletes;
	
	public DataStatePayload(LinkedHashMap<String, ArrayList<?>> inserts, LinkedHashMap<String, ArrayList<?>> deletes) {
		this.inserts = inserts;
		this.deletes = deletes;
	}
	
	public LinkedHashMap<String, ArrayList<?>> getInserts() {
		return inserts;
	}
	
	public LinkedHashMap<String, ArrayList<?>> getDeletes() {
		return deletes;
	}

}

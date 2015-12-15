package com.maestro.datastate.abstr;

import java.util.ArrayList;

/**
 * 
 * @author  Sean Perkins <sean@meetmaestro.com>
 * @since   12/14/2015
 * @version 1.0.0
 *
 */
public interface IDataStateObject {
	
	// The key of the object when serialized
	public String getKeyName();
	
	public ArrayList<?> getValues();
	
	public Integer getAPIVersion();

}

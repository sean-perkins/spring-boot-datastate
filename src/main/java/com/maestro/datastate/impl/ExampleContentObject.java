package com.maestro.datastate.impl;

import java.util.ArrayList;

import com.maestro.datastate.abstr.IDataStateObject;
import com.maestro.example.impl.ExampleContent;
import com.maestro.example.seeds.SampleSeeder;
/**
 * 
 * @author  Sean Perkins <sean@meetmaestro.com
 * @since   12/14/2015
 * @version 1.0.0
 *
 */
public class ExampleContentObject implements IDataStateObject {

	@Override
	public String getKeyName() {
		return "ExampleContent";
	}

	@Override
	public ArrayList<ExampleContent> getValues() {
		return new ArrayList<ExampleContent>(SampleSeeder.getExampleContent());
	}

	@Override
	public Integer getAPIVersion() {
		return 1;
	}

}

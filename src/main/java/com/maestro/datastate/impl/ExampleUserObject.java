package com.maestro.datastate.impl;

import java.util.ArrayList;

import com.maestro.datastate.abstr.IDataStateObject;
import com.maestro.example.impl.ExampleUser;
import com.maestro.example.seeds.SampleSeeder;
/**
 * 
 * @author  Sean Perkins <sean@meetmaestro.com>
 * @since   12/14/2015
 * @verison 1.0.0
 *
 */
public class ExampleUserObject implements IDataStateObject {

	@Override
	public String getKeyName() {
		return "User";
	}

	@Override
	public ArrayList<ExampleUser> getValues() {
		return new ArrayList<ExampleUser>(SampleSeeder.getExampleUsers());
	}

	@Override
	public Integer getAPIVersion() {
		return 1;
	}

}

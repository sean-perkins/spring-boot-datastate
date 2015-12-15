package com.maestro.datastate;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maestro.datastate.abstr.AbstractDataStateFactory;
import com.maestro.datastate.abstr.DataStatePayload;
import com.maestro.datastate.impl.ExampleContentObject;
import com.maestro.datastate.impl.ExampleUserObject;

/**
 * 
 * @author  Sean Perkins <sean@meetmaestro.com>
 * @since   12/14/2015
 * @version 1.0.0
 *
 */
@Controller
public class ExampleDataStateFactory extends AbstractDataStateFactory {
	
	private static final Logger logger = Logger.getLogger(ExampleDataStateFactory.class);

	@Override
	public void seed() {
		insertSeed(new ExampleContentObject());
		insertSeed(new ExampleUserObject());
	}

	@RequestMapping(value="/api/v1/test", method=RequestMethod.GET)
	@ResponseBody
	@Override
	public DataStatePayload sync(Long lastSyncedAt) {
		logger.info("Generating datastate response for incoming request. [currentTime=" + System.currentTimeMillis() + "]");
		return getPayload(lastSyncedAt);
	}

}

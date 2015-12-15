package com.maestro.example.seeds;

import java.util.ArrayList;
import java.util.List;

import com.maestro.example.impl.ExampleContent;
import com.maestro.example.impl.ExampleUser;

public class SampleSeeder {
	
	public static List<ExampleContent> getExampleContent() {
		List<ExampleContent> exampleContent = new ArrayList<ExampleContent>();
		exampleContent.add(new ExampleContent(1, "Test Content", "www.google.com"));
		exampleContent.add(new ExampleContent(2, "Apple's IPhone", "www.apple.com"));
		exampleContent.add(new ExampleContent(3, "Sharks in the Water", "www.sharktank.com"));
		return exampleContent;
	}
	
	public static List<ExampleUser> getExampleUsers() {
		List<ExampleUser> exampleUsers = new ArrayList<ExampleUser>();
		exampleUsers.add(new ExampleUser(1, "Bill Gates"));
		exampleUsers.add(new ExampleUser(2, "Steve Jobs"));
		exampleUsers.add(new ExampleUser(3, "Taylor Swift"));
		return exampleUsers;
	}

}

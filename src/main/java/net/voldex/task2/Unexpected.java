package net.voldex.task2;

import java.lang.reflect.Field;

public final class Unexpected {

	public static void main(String[] args) throws Exception {
		Unexpected.behaviour();
		System.out.println("2 + 2 = 4");
		System.out.println("2 + 2 = " + (2 + 2));
	}

	private static void behaviour() throws Exception {
		// Create a new string of the value to be printed so it gets cached
		String controlString = "2 + 2 = 4";

		// Get the string class
		Class stringClass = String.class;

		// Get the char[] value
		Field stringValueField = stringClass.getDeclaredField("value");
		stringValueField.setAccessible(true);

		// Set the '4' to be a '5' in our control string
		char[] controlStringValue = controlString.toCharArray();
		controlStringValue[8] = '5';

		// Make our control string our newly edited char array, thus changing the cached version
		stringValueField.set(controlString, controlStringValue);
	}

}

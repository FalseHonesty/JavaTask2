package net.voldex.task2;

import java.lang.reflect.Field;
import java.util.Arrays;

public final class Unexpected {

	public static void main(String[] args) throws Exception {
		Unexpected.behaviour();
		System.out.println("2 + 2 = 4");
		System.out.println("2 + 2 = " + (2 + 2));
	}

	private static void behaviour() throws Exception {
		//The first subclass of Integer is the IntegerCacheClass
		Class integerCacheClass = Integer.class.getDeclaredClasses()[0];

		//Get the Integer[] cache class and make it accessible
		Field integerCacheField = integerCacheClass.getDeclaredField("cache");
		integerCacheField.setAccessible(true);

		//Actually get the cache
		Integer[] integerCache = (Integer[]) integerCacheField.get(integerCacheClass);

		//Set the index of 4 to be the value 5
		integerCache[132] = 5;

		//Has this changed the array, and possibly the print methods?
		System.out.println(Arrays.toString(integerCache));
		System.out.println(Integer.valueOf(4));
	}

}

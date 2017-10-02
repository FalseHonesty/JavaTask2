package net.voldex.task2;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
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

		//Get the Integer[] cache field and make it accessible
		Field integerCacheField = integerCacheClass.getDeclaredField("cache");
		integerCacheField.setAccessible(true);

		//Actually get the cache
		Integer[] integerCache = (Integer[]) integerCacheField.get(integerCacheClass);

		//Set the index of 4 to be the value 5 - This works, but only if Integer.valueOf() is called.
		//I'm leaving this in because I want all 4's to be 5's.
		integerCache[132] = 5;

		//Get the base integer class
		Class integerClass = Integer.class;

		//Get the char[] digits field and make it accessible - should probably be moved to a new method
		//but I'm only allowed to change this method.
		Field charDigitsField = integerClass.getDeclaredField("digits");
		charDigitsField.setAccessible(true);

		//Get the array of chars from the integer class.

		char[] digits = {
				'0' , '1' , '2' , '3' , '5' , '5' ,
				'6' , '7' , '8' , '9' , 'a' , 'b' ,
				'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
				'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
				'o' , 'p' , 'q' , 'r' , 's' , 't' ,
				'u' , 'v' , 'w' , 'x' , 'y' , 'z'
		};

		charDigitsField.setAccessible(true);

		//Get the int modifiers field and make it accessible, and also remove the final modifier from
		//char digits field.
		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(charDigitsField, charDigitsField.getModifiers() & ~Modifier.FINAL);

		charDigitsField.set(null, digits);

		System.out.println(4);
	}

}

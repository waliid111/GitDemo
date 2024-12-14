package pckg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Streams<booelan> {
	
	//@Test
	public void filter()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Altukomar");
		names.add("Don");
		names.add("Alekhmaho");
		names.add("Adam");
		names.add("Jineb");
		
		int count = 0;
		
		for(int i = 0; i < names.size(); i++)
		{
			if(names.get(i).startsWith("A"))
			{
				count++;
			}
		}
		System.out.println(count);
	}
	
	//@Test
	public void streamFilter()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Altukomar");
		names.add("Don");
		names.add("Alekhmaho");
		names.add("Adam");
		names.add("Jineb");
		
		/* Streams -> 1:Create Stream [names.stream()], 
		 * 2:Intermediate Operation on initial Stream to Transform it to another Stream[filter(s->s.startsWith("A"))], 
		 * 3:Terminal Operation for Result [.count()] */
		// Lambda Expression declare variable -> Operation
		// There is no life for intermediate operation if there is no terminal operation
		// Terminale operation will execute only if intermediate operation (filter) return true
		// We can create Stream
		// How to use filter in Stream API
		Long counter = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(counter);
		
		Long counting = Stream.of("Altukomar", "Don", "Alekhmaho", "Adam", "Jineb").filter(s->
		{
			s.startsWith("A");
			return true;
		}
		).count();
		System.out.println("My names Starting with A are : "+counting);
		
		// Print all the names of ArrayList
		//names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s ->System.out.println(s));
		
	}
	
	//@Test
	public void streamMap()
	{
		// Print names that have last letter "o" with Uppercase
		Stream.of("Altukomar", "Don", "Alekhmaho", "Adamo", "Jineb")
			.filter(s -> s.endsWith("o"))
			.map(s->s.toUpperCase())
			.forEach(s -> System.out.println(s));
		
		// Print names with 1st letter as A with Uppercase and Sorted
		List<String> names = Arrays.asList("Azltukomar", "Don", "Alekhmaho", "Adamo", "Jineb");
		names.stream().filter(s->s.startsWith("A"))
			.sorted()
			.map(s -> s.toUpperCase())
			.forEach(s -> System.out.println(s));
		
		// Merge 2 Arrays and sort them
		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Men");
		names1.add("Don");
		names1.add("Women");
		
		Stream <String> newStream =  Stream.concat(names.stream(), names1.stream());
		//newStream.sorted().forEach(s -> System.out.println(s));
		
		// check matching of Element on a Stream
		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Adamo"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	//@Test
	public void streamCollect()
	{
		List<String> ls = Stream.of("Altukomar", "Don", "Alekhmaho", "Adamo", "Jineb")
		.filter(s -> s.endsWith("o"))
		.map(s->s.toUpperCase())
		.collect(Collectors.toList());
		
		System.out.println(ls.get(0));
	}
	
	@Test
	public void streamAssignment()
	{
		// Print unique numbers from this arraylist
		// Sort the Array and get the 3rd index 1,2,3,5,7,9
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
		
		numbers.stream()
			.distinct()
			.forEach(s -> System.out.println(s));
		
		List<Integer> li = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("\n *** "+li.get(2));
	}

}

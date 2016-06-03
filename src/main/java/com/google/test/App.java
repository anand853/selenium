package com.google.test;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Runner run = new Runner();

		String home = System.getProperty("user.home");
		String download = "/Downloads/";
		System.out.println("Working Directory = " + home + download);

	}
}

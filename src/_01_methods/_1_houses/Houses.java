package _01_methods._1_houses;

import java.awt.AWTException;
import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */
public class Houses {
	Robot rob = new Robot();
	Random ran = new Random();

	public void run() {
		// Check the recipe to find out what code to put here
		rob.setWindowColor(0, 0, 0);
		rob.setX(0);
		rob.setY(400);
		rob.hide();
		rob.setPenColor(0, 127, 0);
		rob.setSpeed(20);
		rob.penDown();
		rob.turn(90);
		rob.move(20);
		for (int i = 0; i <= 10; i++) {
			int first = ran.nextInt(256);
			int second = ran.nextInt(256);
			int third = ran.nextInt(256);
			switch (ran.nextInt(3)) {
			case 0:
				makeHouse("small", first, second, third);
				break;
			case 1:
				makeHouse("medium", first, second, third);
				break;
			case 2:
				makeHouse("large", first, second, third);
			}
			rob.setPenColor(0, 127, 0);
			rob.move(20);
		}
	}

	public void makeHouse(String size, int col1, int col2, int col3) {
		int height = 0;
		if (size.equals("large")) {
			height = 250;
		} else if (size.equals("medium")) {
			height = 120;
		} else if (size.equals("small")) {
			height = 60;
		}
		rob.turn(-90);
		rob.setPenColor(col1, col2, col3);
		rob.move(height);
		if (size.equals("large")) {
			makeFlatRoof();
		} else {
			makePointyRoof();
		}
		rob.move(height);
		rob.turn(-90);

	}

	public void makePointyRoof() {
		rob.turn(45);
		rob.move(10);
		rob.turn(90);
		rob.move(10);
		rob.turn(45);
	}

	public void makeFlatRoof() {
		rob.turn(90);
		rob.move(20);
		rob.turn(90);
	}
}

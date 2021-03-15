package com.proyect.rockpaperscissors.game;

import java.util.Random;
import java.util.Scanner;

import com.proyect.models.GameObject;


public class Game implements Runnable {

	private boolean isRunning = true;

	private int score = 0;
	private Random random = new Random();
	Scanner scan = new Scanner(System.in);

	@Override
	public void run() {
		// TODO Auto-generated method stub			
		
			for(int i = 0; i < 3; i++) {
			
			GameObject randomObject = pickObject();
			GameObject playerObject = getPlayerObject();
			
			
			boolean win = playerObject.beats(randomObject);
			String compareText = playerObject.compareText(randomObject);
			String[] outcomes = {"lose","draw","win"};
	
			System.out.println(playerObject + " --- " + randomObject);
			System.out.println(compareText);
			
			if(win) {
				System.out.println("WIN");
				++score;
			}else if(playerObject == randomObject){
				System.out.println("DRAW");
			}else {
				System.out.println("LOSE");
				--score;
			}
			
			System.out.println();

			//score += compare;
	
			}
	

	}



	public GameObject getPlayerObject() {
		do {
			System.out.println("Enter your choice (0. rock, 1. paper, 2.scissors!): ");

			int input = scan.nextInt();

			if (input >= 0 && input <= 2) {
				GameObject[] objects = GameObject.values();
				return objects[input];

			}
		} while (true);
	}

	private GameObject pickObject() {
		GameObject[] objects = GameObject.values();
		return objects[random.nextInt(objects.length)];
	}

}

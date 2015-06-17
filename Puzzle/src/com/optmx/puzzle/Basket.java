package com.optmx.puzzle;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Basket {
	private int basketNo = 0;
	
	private Basket nextBasket = null;
	
	public Basket nextBasket(){
		return nextBasket;
	}
	public void setNextBasket(Basket bas){
		nextBasket = bas;
	}
	public Basket(int input, int random){
		basketNo = input;
		switch(random){
		case 1:
			setFruit(Constant.ORANGE);
			setLabel(Constant.APPLE);
			
			break;
		case 2:
			setFruit(Constant.APPLE);
			setLabel(Constant.APPLE_ORANGE);	
			break;
		case 3:
			setFruit(Constant.APPLE_ORANGE);
			setLabel(Constant.ORANGE);
			break;
		}
	}
	private String labels;
	
	public String getLabels() {
		return labels;
	}
	public void setLabel(String str) {
		this.labels = str;
	}
	public String getFruits() {
		return fruits;
	}
	public void setFruit(String fruit) {
		this.fruits = fruit;
	}
	private String fruits ;

/*	public String toString(){
		
		return labels;
	}*/
	
	public String listFruits(){
		
		return fruits;
	}
	
	public boolean isValidBasket(){
		
		if(labels.toString().equalsIgnoreCase(fruits ) ){
			return true;
		}
		return false;
	}
	
	
	
	public String toString(){
		return "Basket "+basketNo+" is labeled as "+labels;
	}
	
	public String toStringWithContains(){
		return "Basket "+basketNo+" is labeled as "+labels+" but contains "+fruits;
	}
	
	public String fruitToString(){
		return "Basket "+basketNo+" but contains "+fruits;
	}
	
	public void guess(int input){
		int iinput = 0;
		if(input<3){
			iinput = ++input;
		}else{
			iinput = 1;
		}
		
		if(this.getFruits().equalsIgnoreCase(Constant.APPLE)){
			System.out.println("What is the content of Basket "+ (iinput) +"??: press 1 for "+Constant.ORANGE+", 2 "+Constant.APPLE_ORANGE);
			int num = GameClient.scan.nextInt();

			do {
				if(num == 1){
					System.out.println(nextBasket().toStringWithContains());
					if(nextBasket().getFruits().equals(Constant.ORANGE)){
						System.out.println("Correct Guess, YOU WIN!!!");
					}else{
						System.out.println("Wrong Guess, YOU LOSE!!!");
					}
					break;
				}else if (num == 2){
					System.out.println(nextBasket().toStringWithContains());
					if(nextBasket().getFruits().equals(Constant.APPLE_ORANGE)){
						System.out.println("Correct Guess, YOU WIN!!!");
					}else{
						System.out.println("Wrong Guess, YOU LOSE!!!");
					}
					break;

				}else{
					System.out.println("Invalid input, please try again");
				}
				num = GameClient.scan.nextInt();
			}
			while (num == 1 || num == 2);

		} else if(this.getFruits().equalsIgnoreCase(Constant.ORANGE)){
			System.out.println("What is the content of Basket "+ (iinput) +"??: press 1 for "+Constant.APPLE+", 2 for "+Constant.APPLE_ORANGE);
			int num = GameClient.scan.nextInt();

			do {
				if(num == 1){
					System.out.println(nextBasket().toStringWithContains());
					if(nextBasket().getFruits().equals(Constant.APPLE)){
						System.out.println("Correct Guess, YOU WIN!!!");
					}else{
						System.out.println("Wrong Guess, YOU LOSE!!!");
					}
					break;

				}else if (num == 2){
					System.out.println(nextBasket().toStringWithContains());
					if(nextBasket().getFruits().equals(Constant.APPLE_ORANGE)){
						System.out.println("Correct Guess, YOU WIN!!!");
					}else{
						System.out.println("Wrong Guess, YOU LOSE!!!");
					}
					break;

				}else{
					System.out.println("Invalid input, please try again");
				}
				num = GameClient.scan.nextInt();
			}
			while (num == 1 || num == 2);

		}else if(this.getFruits().equalsIgnoreCase(Constant.APPLE_ORANGE)){
			System.out.println("What is the content of Basket "+ (iinput) +"??: press 1 for "+Constant.APPLE+", 2 for "+Constant.ORANGE);
			int num = GameClient.scan.nextInt();

			do {
				if(num == 1){
					System.out.println(nextBasket().toStringWithContains());
					if(nextBasket().getFruits().equals(Constant.APPLE)){
						System.out.println("Correct Guess, YOU WIN!!!");
					}else{
						System.out.println("Wrong Guess, YOU LOSE!!!");
					}
					break;

				}else if (num == 2){
					System.out.println(nextBasket().toStringWithContains());
					if(nextBasket().getFruits().equals(Constant.ORANGE)){
						System.out.println("Correct Guess, YOU WIN!!!");
					}else{
						System.out.println("Wrong Guess, YOU LOSE!!!");
					}
					break;

				}else{
					System.out.println("Invalid input, please try again");
				}
				num = GameClient.scan.nextInt();
			}
			while (num == 1 || num == 2);

		}

	}

}

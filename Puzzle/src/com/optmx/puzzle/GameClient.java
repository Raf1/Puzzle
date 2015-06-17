package com.optmx.puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameClient {
	
	private Basket basket1;
	private Basket basket2;
	private Basket basket3;
	private List<Integer> selectedCombination = new ArrayList<Integer>();
	
	private int input;
	
	public static Scanner scan ;
	
	public static void main(String arg[]){
		new GameClient().start();
	}
	
	public static int randomInit(){
		Random rad = new Random();
		return rad.nextInt(4);
	}
	
	public void start(){
		int randomNo = randomInit();
		boolean firstBasket = false;
		boolean secondBasket = false;
		boolean thirdBasket = false;
		while(true){
			if(randomNo != 0 && !firstBasket){
				if(!selectedCombination.contains(randomNo)){
					basket1 = new Basket(1, randomNo);
					firstBasket = true;
					selectedCombination.add(randomNo);
				}
			}else if(randomNo != 0 && !secondBasket){
				if(!selectedCombination.contains(randomNo)){
					basket2 = new Basket(2, randomNo);
					secondBasket = true;
					selectedCombination.add(randomNo);
				}
			}else	if(randomNo != 0 && !thirdBasket ){
				if(!selectedCombination.contains(randomNo)){
					basket3 = new Basket(3, randomNo);
					selectedCombination.add(randomNo);
					break;
					
				}
			}
			randomNo = randomInit();
		}
		
		
		basket1.setNextBasket(basket2);
		basket2.setNextBasket(basket3);
		basket3.setNextBasket(basket1);
	
		System.out.println("Please choose one to open one of the below basket. All these baskets are wrongly labelled and you get only one attempt to correct it. ");
		System.out.println("1. "+basket1.toString());
		System.out.println("2. "+basket2.toString());
		System.out.println("3. "+basket3.toString());
		System.out.println("4. Exit:  ");
		
		scan = new Scanner(System.in);
		System.out.println("Which basket do you want to open?? 1, 2 or 3. or input 4 for exit");
		
		input = scan.nextInt();
		
		while(input != 4){
			if(input == 1){
				System.out.println(basket1.toStringWithContains());
				basket1.guess(input);
				 break;
				
			}else if (input == 2){
				System.out.println(basket2.toStringWithContains()); 
				basket2.guess(input);
				 break;
				
			}else if (input == 3){
				System.out.println(basket3.toStringWithContains()); 
				basket3.guess(input);
				 break;
			}else if (input == 4){
				System.exit(0);
			}else{
				System.out.println("Invalid input, please try again");
			}
			
			input = scan.nextInt();
		}
		
	}
}

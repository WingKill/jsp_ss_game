package edu.sejong.game.vo;

import java.util.HashSet;
import java.util.Set;

public class LottoVo_mywritings {
	private Set<Integer> numbers = new HashSet<Integer>();
	private String[] colors = {"blue","red","green","orange","black"};	
	private String background = null;

	public LottoVo_mywritings() {
		while(numbers.size() < 7) {
			numbers.add((int)(Math.random()*45 + 1));
		}
		System.out.println(numbers);
	}
	
	public Set<Integer> getNumbers() {
		return numbers;
	}
	
	public void setNumbers(Set<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public String[] getColors() {
		return colors;
	}

	public void setColors(String[] colors) {
		this.colors = colors;
	}

	public String getBackground(int num) {
		if(num >= 40) {
			background = "black";
		}else if(num >= 30) {
			background = "orange";
		}else if(num >= 20) {
			background = "green";
		}else if(num >= 10) {
			background = "red";
		}else {			
			background = "blue";
		}
		return background;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}
}

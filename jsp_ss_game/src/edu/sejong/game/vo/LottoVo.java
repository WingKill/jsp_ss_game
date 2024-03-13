package edu.sejong.game.vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoVo {
	private final static int LOTTO_COUNT = 7;
	private Set<Integer> numbers = new HashSet<Integer>();
	private List<Integer> arrList = new ArrayList<Integer>();
	private int bonusNum;
	private String[] colors = {"blue","red","green","orange","black"};	
	private String background = null;

	public LottoVo() {
		while(numbers.size() < LOTTO_COUNT) {
			numbers.add((int)(Math.random()*45 + 1));
		}
		
		List<Integer> arrList = new ArrayList<Integer>(numbers);
		for(int i=0;i<arrList.size()-1;i++) {
			int num = arrList.get(i);
			this.arrList.add(num);
		}
		
		bonusNum = arrList.get(LOTTO_COUNT-1);
		
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

	public List<Integer> getArrList() {
		return arrList;
	}

	public void setArrList(List<Integer> arrList) {
		this.arrList = arrList;
	}

	public int getBonusNum() {
		return bonusNum;
	}

	public void setBonusNum(int bonusNum) {
		this.bonusNum = bonusNum;
	}
}

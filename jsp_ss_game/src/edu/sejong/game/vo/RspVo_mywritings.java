package edu.sejong.game.vo;

import java.util.Arrays;

public class RspVo_mywritings {
	private static String[] arrRsp = {"가위","바위","보"};
	private static String[] arrResult = {"당신이 이겼습니다.","서로 비겼습니다.","당신이 졌습니다."};
	private static String[] arrImage = {
	"http://49.247.158.208:9999/hjs/img/scissor.f9ef898c.jpg\r\n", 
	"http://49.247.158.208:9999/hjs/img/rock.8b39a13f.jpg\r\n",
	"http://49.247.158.208:9999/hjs/img/paper.0b032424.jpg"};
	
	private String image = null;
	private String rsp = null;
	private String result = null;
	
	// 컴퓨터
	public RspVo_mywritings() {
		// 0~2까지 랜덤한 숫자 얻기
		rsp = arrRsp[(int)(Math.random()*3)];
		rspImage(rsp);
		System.out.println("computer : " + rsp);
	}
	
	// 플레이어 
	public RspVo_mywritings(String rsp) {
		this.rsp = rsp;
		rspImage(this.rsp);
		System.out.println("player : "+ this.rsp);
	}
	
	private void rspImage(String rsp) {	
		if(rsp.equals(arrRsp[0])){
			image = arrImage[0];
		}else if(rsp.equals(arrRsp[1])){
			image = arrImage[1];
		}else if(rsp.equals(arrRsp[2])){
			image = arrImage[2];
		}
	}
	
	public void rspGame(RspVo_mywritings rspVo) {
		String comRsp = rspVo.getRsp();
		if(this.rsp.equals(comRsp)) {
			result = arrResult[1];
		}
		
		if((this.rsp.equals(arrRsp[0]) && comRsp.equals(arrRsp[1]))
		 ||(this.rsp.equals(arrRsp[1]) && comRsp.equals(arrRsp[2]))
		 ||(this.rsp.equals(arrRsp[2]) && comRsp.equals(arrRsp[0]))) {
			result = arrResult[2];					
		}else if((this.rsp.equals(arrRsp[0]) && comRsp.equals(arrRsp[2]))
			   ||(this.rsp.equals(arrRsp[1]) && comRsp.equals(arrRsp[0]))
			   ||(this.rsp.equals(arrRsp[2]) && comRsp.equals(arrRsp[1]))) {
			result = arrResult[0];
		}
	}

	public String getRsp() {
		return rsp;
	}

	public void setRsp(String rsp) {
		this.rsp = rsp;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}

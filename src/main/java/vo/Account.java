package vo;

import vo.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {
    //필드
    private LocalDateTime timeHistory; //날짜 시간
    private String plusCash;  //입금액
    private String minusCash; //출금액
    private int amount; //입력금액


    //생성자
    public Account(int amount){
        this.amount = amount;
    }

    //메소드
    public LocalDateTime getTimeHistory() {
        return timeHistory;
    }
    public String getPlusCash(){return plusCash;}
    public String getMinusCash(){return minusCash;}
    public int getAmount(){return amount;}


    //입금
    public void deposit(int money){
        this.amount+=money;
    }
//    //출금
//    public int withdraw(int amount)
//            throws Exception{//throw:생성한 예외 객체를 호출한 쪽을 넘김
//            if(this.stock<amount){
//                //강제 예외처리
//                throw new Exception("잔액이 부족합니다");//new Exception() 예외객체 생성
//                //메소드의 매개변수 옆에 있는 throws Exception은 호출한 쪽으로 예외를 넘기는 문장
//            }else {
//                this.stock-=amount;
//                return amount;
//            }
//    }

}

package vo;

import java.time.LocalDateTime;

public class Account {
    //필드
    private LocalDateTime timeHistory; //날짜 시간
    private String plusCash;  //입금액
    private String minusCash; //출금액
    private int amount; //입력금액

    private User user;


    //생성자
    public Account(int amount, LocalDateTime timeHistory){
        this.amount = amount;
        this.timeHistory = timeHistory;
    }

    //메소드
    public LocalDateTime getTimeHistory(LocalDateTime timeHistory) {
        return timeHistory;
    }
    public String getPlusCash(){return plusCash;}
    public String getMinusCash(){return minusCash;}
    public int getAmount(){return amount;}

    public boolean setDate(LocalDateTime timeHistory) {
        this.timeHistory = timeHistory;
        return false;
    }


}

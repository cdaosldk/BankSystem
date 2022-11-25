package vo;

import vo.User;
public class Account {

    //필드
    private String bankNum; //계좌번호
    private String user; // 사용자
    private int stock; //잔고

    //생성자
    public Account(String bankNum, String user, int stock){
        this.bankNum = bankNum;
        this.user = user;
        this.stock = stock;
    }

    //메소드
    protected String getBankNum(){return bankNum;}
    protected void setBankNum(String bankNum){this.bankNum = bankNum;}

    protected String getUser(){return user;}
    protected void setUser(String user) { this.user = user; }

    protected int getStock(){return stock;}
    protected void setStock(int stock){this.stock=stock;}

    //입금
    public void deposit(int amount){
        this.stock+=amount;
    }
    //출금
    public int withdraw(int amount)
            throws Exception{//throw:생성한 예외 객체를 호출한 쪽을 넘김
            if(this.stock<amount){
                //강제 예외처리
                throw new Exception("잔액이 부족합니다");//new Exception() 예외객체 생성
                //메소드의 매개변수 옆에 있는 throws Exception은 호출한 쪽으로 예외를 넘기는 문장
            }else {
                this.stock-=amount;
                return amount;
            }
    }

}

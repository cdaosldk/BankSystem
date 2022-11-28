package vo;

import java.time.LocalDateTime;

    public class Account {
        private LocalDateTime timeHistory;
        private int plusCash;
        private int minusCash;
        private int amount;

    //생성자
    public Account(int amount, LocalDateTime timeHistory){
        this.amount = amount;
        this.timeHistory = timeHistory;
    }

    //메소드
    public LocalDateTime getTimeHistory(LocalDateTime timeHistory) {
        return timeHistory;
    }
    public int getAmount(){return amount;}

    public void setDate(LocalDateTime timeHistory) {
        this.timeHistory = timeHistory;
    }

    public LocalDateTime getDate() {
            return timeHistory;
        }


}

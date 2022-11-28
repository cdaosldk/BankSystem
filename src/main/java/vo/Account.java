package vo;

import java.time.LocalDateTime;

    public class Account {

        private String accountNum;
        private LocalDateTime timeHistory;

        private String plusOrMinus;

        private int amount;

        //   날짜/시간, 입출금 +-, 입력금액
        public Account( String plusOrMinus,int amount,String accountNum) {
//            this.timeHistory = timeHistory;
            this.accountNum = accountNum;
            this.plusOrMinus = plusOrMinus;
            this.amount = amount;
        }

        public LocalDateTime getTimeHistory() { return timeHistory;};

        public String getPlusOrMinus() {
            return plusOrMinus;
        }

        public int getAmount() {
            return amount;
        }

        public String getAccountNum() {
            return accountNum;
        }

        public void setTimeHistory(LocalDateTime timeHistory) {
            this.timeHistory = timeHistory;
        }
        //        public int getPlusCash() { return user};
//
//        public int getAmount() { return amount;};
}

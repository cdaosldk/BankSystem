package vo;

import java.time.LocalDateTime;

    public class Account {
        private LocalDateTime timeHistory;

        private int plusCash;

        private int minusCash;

        private int amount;

        //   날짜/시간, 입출금 +-, 입력금액
        public Account(LocalDateTime timeHistory, int plusCash, int minusCash, int amount) {
            this.timeHistory = timeHistory;
            this.plusCash = plusCash;
            this.minusCash = minusCash;
            this.amount = amount;
        }

        public LocalDateTime getTimeHistory() { return timeHistory;};

//        public int getPlusCash() { return user};
//
//        public int getAmount() { return amount;};
}

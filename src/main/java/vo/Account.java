package vo;

import java.time.LocalDateTime;

    public class Account {
        private LocalDateTime timeHistory;

        private String plusCash;

        private String minusCash;

        private int amount;

        //   날짜/시간, 입출금 +-, 입력금액
        public Account(LocalDateTime timeHistory, String plusCash, String minusCash, int amount) {
            this.timeHistory = timeHistory;
            this.plusCash = plusCash;
            this.minusCash = minusCash;
            this.amount = amount;
        }

        public LocalDateTime getTimeHistory() { return timeHistory;};

        public String getPlusCash() { return plusCash;};

        public String getMinusCash() { return minusCash;};

        public int getAmount() { return amount;};
}

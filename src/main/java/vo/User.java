package vo;
public class User {

    private String name; //유저 이름
    private int stock;   //
    private String accountNum;  //계좌번호
    private String bankName;   //은행명
    private String pwd;       //비밀번호

    public User(String name,int stock ,String accountNum, String bankName, String pwd) {
        this.name = name;
        this.stock = stock;
        this.accountNum = accountNum;
        this.bankName = bankName;
        this.pwd = pwd;
    }

    public void setStock(int stock) { // 잔고 변경
        this.stock = stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getName() {
    public String getName() { // 소유주 조회
        return name;
    }

    public int getStock() { // 잔고 조회
        return stock;
    }

    public String getAccountNum() { // 계좌 번호로 조회
        return accountNum;
    }

    public String getBankName() { // 은행이름조회?
        return bankName;
    }

    public String getPwd() { // 비밀번호 조회?
        return pwd;
    }

    public void setName(String name) { // 소유주 이름 변경
        this.name = name;
    }

    public void setBankName(String bankName) { // 은행 이름변경
        this.bankName = bankName;
    }

}

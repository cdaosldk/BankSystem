package vo;
public class User {

    private String name; //유저 이름
    private int stock;   //잔고
    private String accountNum;  //계좌번호
    private String bankName;   //은행명
    private String pwd;       //비밀번호

    private Account account;


    public User(String name,int stock ,String accountNum, String bankName, String pwd) {
        this.name = name;
        this.stock = stock;
        this.accountNum = accountNum;
        this.bankName = bankName;
        this.pwd = pwd;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getBankName() {
        return bankName;
    }

    public String getPwd() {
        return pwd;
    }

    //입금
    public void addStock(int money){
        this.stock += money;
    }
    //출금
    public void subtractStock(int money){
        this.stock -= money;
    }

}

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

    public void setStock(int stock) {
        this.stock = stock;
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
}

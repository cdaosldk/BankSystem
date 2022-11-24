package vo;
public class User {

    private String name;
    private int stock;
    private String accountNum;
    private String bankName;
    private String pwd;

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

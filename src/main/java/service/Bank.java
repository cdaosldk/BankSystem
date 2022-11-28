package service;

import vo.Account;
import vo.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Bank {

    private final static Bank bank = new Bank();

    private List<User> userList = new ArrayList<>();
    private List<Account> accountList = new ArrayList<>();

    //Bank하나의 객체를 유지하기 위한 메서드
    public static Bank getInstance(){

        if(bank == null){
            return new Bank();
        }
        return bank;
    }
    //유저의 정보를 저장하는 부분
    public void addUser(User user){
        System.out.println("은행 정보가 정상적으로 저장되었습니다.");
        userList.add(user);
    }

    public void showAll(){
        for(int i=0;i<userList.size();i++){
            System.out.println("------------");
            System.out.print(userList.get(i).getName()+"님 ");
            System.out.println(userList.get(i).getAccountNum()+" ");
            System.out.println(userList.get(i).getStock()+"원 ");
            System.out.println(userList.get(i).getBankName()+" 은행");
        }
    }

    public boolean checkToUsableBankNum(String bankNum){

        if(userList.stream().anyMatch(s->s.getAccountNum().equals(bankNum))){
            System.out.println("이미 등록된 계좌번호입니다!");
            return false;
        }
        return true;
    }

    public boolean confirmAccountNum(String inputAccountNum){

        if(userList.stream().anyMatch(s -> s.getAccountNum().equals(inputAccountNum))){
            return true;
        }
        System.out.println("존재하지 않는 계좌번호입니다!");
        return false;
    }

    public boolean confirmAccountName(String inputAccountName){

        if(userList.stream().anyMatch(s -> s.getName().equals(inputAccountName))){
            return true;
        }
        System.out.println("존재하지 않는 회원입니다!");
        return false;
    }



    public boolean confirmAccountPwd(String inputAccountNum, String pwd){

        Stream<User> userInfo = userList.stream().filter(s -> s.getAccountNum().equals(inputAccountNum));
        if(userInfo.anyMatch(s -> s.getPwd().equals(pwd))){
            return true;
        }
        System.out.println("계좌의 비밀번호가 틀립니다!");
        return false;

    }

    public void updateUserName(String updateUserName,String inputAccountNum){

        for(int i=0 ; i<userList.size();i++){
            if(userList.get(i).getAccountNum().equals(inputAccountNum)){
                String previousUserName = userList.get(i).getName();
                userList.get(i).setName(updateUserName);
                String presentUserName = userList.get(i).getName();
                System.out.println(previousUserName+"님에서 "+presentUserName+"님으로 변경되었습니다!");
                break;
            }
        }
    }

    public void updateBankName(String updateBankName,String inputAccountNum){

        for(int i=0 ; i<userList.size();i++){
            if(userList.get(i).getAccountNum().equals(inputAccountNum)){
                String previousBankName = userList.get(i).getBankName();
                userList.get(i).setBankName(updateBankName);
                String presentBankName = userList.get(i).getBankName();
                System.out.println(previousBankName+"은행에서  "+presentBankName+"은행으로 변경되었습니다!");
                break;
            }
        }
    }

    public void deleteAccount(String inputAccountNum){
        for(int i=0 ; i<userList.size();i++){
            if(userList.get(i).getAccountNum().equals(inputAccountNum)){
                String presentBankName = userList.get(i).getName();
                userList.remove(i);
                System.out.println(presentBankName+"님의  "+inputAccountNum+" 계좌가 삭제되었습니다!!");
                break;
            }
        }
    }


    public void searchByUserName(String searchUserName){
        Stream<User> searchUser = userList.stream().filter(s -> s.getName().equals(searchUserName));
        searchUser.forEach(u -> System.out.println("--------\n"+u.getName()+" "+u.getAccountNum()+ " \n"+u.getStock()+"원 \n"+u.getBankName()+" 은행"));
    }

    public void searchByAccountNum(String searchAccountNum){

        Stream<User> searchUser = userList.stream().filter(s -> s.getAccountNum().equals(searchAccountNum));
        searchUser.forEach(u -> System.out.println("--------\n"+u.getName()+" "+u.getAccountNum()+ " \n"+u.getStock()+"원 \n"+u.getBankName()+" 은행"));

    }

// 입출금 메서드
    public void deposit(String AccountNum, int money) {
        if (money == 0) {
            System.out.println("금액을 다시 입력해주세요");
        }
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getAccountNum().equals(AccountNum)) {
                userList.get(i).addStock(money);
                break;
            }
        }
    }
    public void withdraw(String AccountNum, int money) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getAccountNum().equals(AccountNum)) {
                if(userList.get(i).getStock() <= money) {
                    System.out.println("잔고가 부족합니다");
                } else if( userList.get(i).getStock() >= money) {
                    userList.get(i).subtractStock(money);
                }
                break;
            }
        }
    }

    //잔고 확인
    public void searchAccountStock(String searchAccountNum) {
        Stream<User> searchUser = userList.stream().filter(s -> s.getAccountNum().equals(searchAccountNum));
        searchUser.forEach(u -> System.out.println("--------\n" + u.getBankName() + "은행  " + u.getAccountNum() + " \n" + "남은 잔고: " + u.getStock() + "원 \n"));
     }
    public void searchByUserNameList(String searchUserName){
        Stream<User> searchUser = userList.stream().filter(s -> s.getName().equals(searchUserName));
        searchUser.forEach(u -> System.out.println("--------\n"+u.getName()+"  "+u.getBankName()+"은행 "+u.getAccountNum()+ " \n"));
    }

    public void addDepositOrWithdrawList(Account account){
        LocalDateTime localDateTime = LocalDateTime.now();
        account.setTimeHistory(localDateTime);
        accountList.add(account);
    }

    public boolean showAccountList(String userName,String accountNum){

        Stream<Account> accountListUser = accountList.stream().filter(s -> s.getAccountNum().equals(accountNum));

        if(!accountList.stream().anyMatch(s -> s.getAccountNum().equals(accountNum))){
            System.out.println(accountNum+" 계좌의 입출금 내역이 없습니다!");
            return false;
        }
        System.out.println("=== "+userName+"님의 " +accountNum+" 계좌 입출금 거래내역 ===");
        accountListUser.forEach(s -> System.out.println(s.getPlusOrMinus()+" "+s.getAmount()+"원 "+s.getTimeHistory()));
        System.out.println("==========================");
        return true;
    }

}

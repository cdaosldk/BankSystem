package service;


import vo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Bank {

    private final static Bank bank = new Bank();

    private List<User> userList = new ArrayList<>();
    //private List<Account> account = new ArrayList<>();

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
            System.out.println(userList.get(i).getBankName()+"");
        }
    }

    public Boolean checkToUsableBankNum(String bankNum){

        if(userList.stream().anyMatch(s->s.getAccountNum().equals(bankNum))){
            return false;
        }
        return true;
    }

    public Boolean confrimAccountNum(String inputAccountNum){

        if(userList.stream().anyMatch(s -> s.getAccountNum().equals(inputAccountNum))){
            return true;
        }
        System.out.println("존재하지 않는 계좌번호입니다!");
        return false;
    }

    public Boolean confrimAccountPwd(String inputAccountNum, String pwd){

        Stream<User> userInfo = userList.stream().filter(s -> s.getAccountNum().equals(inputAccountNum));


        if(userInfo.anyMatch(s -> s.getPwd().equals(pwd))){
            return true;
        }
        System.out.println("계좌의 비밀번호가 틀립니다!");
        return false;

    }

}

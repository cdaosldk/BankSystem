package service;


import org.w3c.dom.ls.LSOutput;
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
            System.out.println(userList.get(i).getBankName()+" 은행");
        }
    }

    public Boolean checkToUsableBankNum(String bankNum){

        if(userList.stream().anyMatch(s->s.getAccountNum().equals(bankNum))){
            System.out.println("이미 등록된 계좌번호입니다!");
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

    public Boolean searchByUserName(String searchUserName){
        Stream<User> searchUser = userList.stream().filter(s -> s.getName().equals(searchUserName));
        //위에 선언한 스트림으로 공백일 때 계좌 없다고 하고 싶은데 필터로 찾지 못해도 무슨 값이 담기는지 봐도 모르겠음..!!
        if(!userList.stream().anyMatch(s -> s.getName().equals(searchUserName))){
            System.out.println(searchUserName+"님으로 등록된 계좌가 없습니다!");
            return false;
        }
        searchUser.forEach(u -> System.out.println("--------\n"+u.getName()+" "+u.getAccountNum()+ " \n"+u.getStock()+"원 \n"+u.getBankName()+" 은행"));
        return true;
    }

}

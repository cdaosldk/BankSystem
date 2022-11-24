
import service.Bank;
import vo.User;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("--은행관리 프로그램입니다.--");
            System.out.println("1.계좌 등록, 2.전체 계좌정보 보기 3.계좌 수정, 4.종료");
            int doingNum = sc.nextInt();


            if(doingNum == 4){
                break;
            }

            switch (doingNum) {
                case 1: registAccount();
                break;

                case 2: showAllAccount();
                break;

                case 3:updateAccount();
                break;
            }

        }

    }

    public static void registAccount(){

        Bank bank = Bank.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("--계좌 등록을 선택하셨습니다.--");
        System.out.println("성함을 입력해주세요!");
        String name = sc.next();
        if(name.isEmpty()){
            System.out.println("성함을 입력해주세요!");
            return;
        }
        System.out.println("계좌번호를 입력해주세요! (ex.xxx-xxxxxx-x) 0~9까지의 숫자만!");
        String pattern = "[0-9,\\-]{3,6}\\-[0-9,\\-]{2,6}\\-[0-9,\\-]";
        String accountNum = sc.next();
        if(!Pattern.matches(pattern,accountNum)){
            System.out.println("계좌번호 형식이 틀렸습니다!");
            return;
        }

        if(!bank.checkToUsableBankNum(accountNum)){
            System.out.println("이미 사용중인 계좌번호 입니다!");
            return;
        }
        System.out.println("계좌 비밀번호를 설정해주세요!");
        String pwd = sc.next();
        System.out.println("계좌 은행을 설정해주세요!");
        String bankName = sc.next();

        User user = new User(name,0,accountNum,bankName,pwd);

        bank.addUser(user);

    }

    public static void showAllAccount(){
        Bank bank = Bank.getInstance();
        bank.showAll();
    }

    public static void updateAccount(){
        Bank bank = Bank.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("--계좌 정보 수정을 선택하셨습니다.--");
        System.out.println("--수정하고자 하는 계좌의 번호를 입력하세요!--");
        String inputAccountNum = sc.next();
        //계좌 번호가 현재 DB에 있는지 확인하는 함수
        if(!bank.confrimAccountNum(inputAccountNum)){
            return;
        }
//        System.out.println("정상확인!");

        System.out.println("계좌의 비밀번호를 입력하세요!");
        String pwd = sc.next();
        //입력한 계좌의 비밀번호가 맞는지 확인하는 함수
        if(!bank.confrimAccountPwd(inputAccountNum,pwd)){
            return;
        }
        System.out.println("해당 계좌의 수정하고 싶은 정보는 무엇입니까?");
        System.out.println("1.소유주 성함, 2.은행명");
        int num = sc.nextInt();





    }
}

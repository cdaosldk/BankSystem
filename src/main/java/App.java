import service.Bank;
import vo.User;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.text.NumberFormat.Field.PREFIX;

public class App {
    //    private static final scan = new Scanner();
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // main 화면, 각 클래스와 관련된 내용으로 연결되고 이후 접속 시 관련 메뉴를 한 번 더 볼 수 있도록 설정
            System.out.println("=== BankSystem에 오신 것을 환영합니다 ===");
            System.out.println("원하시는 메뉴에 해당하는 번호를 입력하세요.");
            System.out.println("1. 은행 관리 2. 거래내역 관리 3. USER 정보 4. 종료");
            int select = sc.nextInt();

            if (select == 4) {
                System.out.println("안녕히 가십시오");
                break;
            }

            switch (select) {
                case 1:
                    bankManager();
                    break;

                case 2:
                    moneyList();
                    break;

//                case 3:
//                    userInfo();
//                    break;

                default:
                    System.out.println("다시 입력해 주세요.");
                    break;

            }
        }
    }

    public static void bankManager() {
        Bank bank = Bank.getInstance();
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 은행 관리자 화면
            System.out.println("=== 은행 관리 ===");
            System.out.println("원하시는 메뉴에 해당하는 번호를 입력하세요.");
            System.out.println("1. 계좌 등록 2. 출금/입금 3. 등록계좌 수정/삭제 4. 계좌 조회(소유자/계좌번호/전체) 5. 이전");
            int select = sc.nextInt();

            if (select == 5) {
                break;
            }
            switch (select) {
                case 1:
                    System.out.println("=== 계좌 등록 ===");
                    System.out.print("소유주 : ");
                    String name = sc.next();
                    String pattern = "[0-9,\\-]{3,6}\\-[0-9,\\-]{2,6}\\-[0-9,\\-]";
                    System.out.print("계좌번호( ex) xxx-xxxxxx-x ) : ");
                    String accountNum = sc.next();
                    if(!Pattern.matches(pattern,accountNum)){
                        System.out.println("계좌번호 형식이 틀렸습니다!");
                        return;
                    }
                    if(!bank.checkToUsableBankNum(accountNum)){
                        return;
                    }
                    System.out.print("계좌 비밀번호 설정 :");
                    String pwd = sc.next();
                    System.out.print("은행명 :");
                    String bankName = sc.next();

                    User user = new User(name,0,accountNum,bankName,pwd);

                    bank.addUser(user);
                    break;

                case 2:
                    System.out.println("=== 입출금 ===");
                    System.out.println("1. 입금 2. 출금");
                    int num = sc.nextInt();

                    if (num == 1) {
                        // 입금 메서드 호출
                    } else {
                        // 출금 메서드 호출
                    }

                    break;

                case 3:

                    System.out.println("=== 등록계좌 수정 및 삭제 ===");
                    System.out.println("1. 수정 2. 삭제");
                    int num2 = sc.nextInt();

                    if (num2 == 1) {
                        // 수정 메서드 호출
                        System.out.print("수정할 계좌번호를 입력하세요 :");
                        String updateAccountNum = sc.next();
                        // 입력한 계좌번호가 DB에 있는지 확인
                        if(!bank.confrimAccountNum(updateAccountNum)){
                            return;
                        }
                        System.out.print("계좌 비밀번호를 입력하세요 :");
                        String updatePwd = sc.next();
                        // 입력한 계좌의 비밀번호가 맞는지 확인
                        if(!bank.confrimAccountPwd(updateAccountNum,updatePwd)){
                            return;
                        }
                        System.out.println("수정할 정보를 선택하세요!");
                        System.out.println("1.소유주명, 2.은행");
                        int updateContentNum = sc.nextInt();

                        if(updateContentNum == 1){
                            // 소유주명 바꾸기
                            System.out.print("변경할 소유주명 :");
                            String updateUserName = sc.next();
                            bank.updateUserName(updateUserName,updateAccountNum);

                        }else if(updateContentNum == 2){
                            // 은행명 바꾸기
                            System.out.print("변경할 은행이름 :");
                            String updateBankName = sc.next();
                            bank.updateBankName(updateBankName,updateAccountNum);

                        }else{
                            System.out.println("잘못된 번호입니다!");
                        }


                    } else {
                        // 삭제 메서드 호출
                        System.out.print("삭제할 계좌번호를 입력하세요 :");
                        String deleteAccountNum = sc.next();
                        // 입력한 계좌번호가 DB에 있는지 확인
                        if(!bank.confrimAccountNum(deleteAccountNum)){
                            return;
                        }
                        System.out.print("계좌 비밀번호를 입력하세요 :");
                        String deletePwd = sc.next();
                        // 입력한 계좌의 비밀번호가 맞는지 확인
                        if(!bank.confrimAccountPwd(deleteAccountNum,deletePwd)){
                            return;
                        }
                        //삭제 메서드 호출
                        bank.deleteAccount(deleteAccountNum);
                    }
                    break;

                case 4:
                    System.out.println("=== 등록계좌 조회 ===");
                    System.out.println("1. 이름으로 조회 2. 계좌번호로 조회 3. 전체 조회");
                    int num3 = sc.nextInt();

                    if (num3 == 1) {
                        // 이름 조회 메서드 호출
                        System.out.print("조회하실 성함을 입력하세요 :");
                        String searchName = sc.next();
                        // 이름 조회 함수 호출

                        if(!bank.searchByUserName(searchName)){
                            return;
                        }

                    } else if (num3 == 2) {
                        // 계좌번호 조희 메서드 호출
                    } else {
                        // 전체 조회 메서드 호출
                        bank.showAll();
                    }
                    break;


                default:
                    System.out.println("다시 입력해 주세요.");
                    break;

            }
        }
    }
    public static void moneyList () {
        Scanner sc = new Scanner(System.in);
//        String accNum = 계좌번호 호출
        while (true) {
            // 입출금내역 관련 화면
            System.out.println("=== 거래내역 관리 ===");
            System.out.println("원하시는 메뉴에 해당하는 번호를 입력하세요.");
            System.out.println("1. 잔고 확인 2. 거래 내역 조회 3. 이전");
            int select = sc.nextInt();

            if (select == 3) {
                break;
            }

            switch (select) {
                case 1:
                    System.out.println("이름을 입력하세요");
                    String name = sc.nextLine();
//                    if ( name == 계좌 클래스의 이름) {
//                          return 이름;
//                          System.out.println(이름);
//                          System.out.println("당신의 계좌번호는 : " + accNum);
//                          break;
//                    }
                    System.out.println("비밀번호를 입력하세요.");
//                    System.out.println("현재 잔액은 " + 잔액 + " 원 입니다.");
//                    비밀번호를 틀릴 경우
                    break;

                case 2:
                    System.out.println("이름을 입력하세요");
                    String name2 = sc.nextLine();
//                    if ( name2 == 계좌 클래스의 이름) { // 계좌번호를 키로 한 거래내역 클래스에 접근
//                          return 이름;
//                          System.out.println(이름);
//                          System.out.println("당신의 계좌번호는 : " + accNum);
//                          break;
//                    }
//                    거래내역 조회 메서드
                    break;

                default:
                    System.out.println("다시 입력해 주세요.");
                    break;

            }
        }
    }

    public static void userInfo () {
        // 유저정보 관련화면
        System.out.println("=== USER 정보 ===");
    }
}
import service.Bank;
import vo.Account;

import java.text.DecimalFormat;
import java.util.Scanner;

import static java.text.NumberFormat.Field.PREFIX;

public class App {
//    private static final scan = new Scanner();
    Scanner sc = new Scanner(System.in);

    //은행시스템 초기화면(은행관리, 거래내역, 유저정보, 종료)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // main 화면, 각 클래스와 관련된 내용으로 연결되고 이후 접속 시 관련 메뉴를 한 번 더 볼 수 있도록 설정
            System.out.println("=== BankSystem에 오신 것을 환영합니다 ===");
            System.out.println("원하시는 메뉴에 해당하는 번호를 입력하세요.");
            System.out.println("1.은행 관리 2.거래내역 관리 3.USER 정보 4.종료");
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

    //은행관리 시스템
    public static void bankManager() {

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
                    System.out.println("소유주 : ");
                    String name = sc.next();
                    int seq = 0; // seq?
                    String accNum = PREFIX+String.format(new DecimalFormat("0000").format(++seq));
                    System.out.println("계좌번호 : " + accNum);
//                  정규표현식으로?? String accNum = sc.next();
                    int amount = 0; // 잔고는 기본값 0원으로 설정하여 저장
                    System.out.println("등록이 완료되었습니다");
                    break;

                case 2:
                    System.out.println("=== 입출금 ===");
                    System.out.println("1. 입금 2. 출금");
                    int num = sc.nextInt();

                    if (num == 1) {
                        deposit();
                        break;
                    } else {
                        withdraw();
                    }
                    break;

                case 3:
                    System.out.println("=== 등록계좌 수정 및 삭제 ===");
                    System.out.println("1. 수정 2. 삭제");
                    int num2 = sc.nextInt();

                    if (num2 == 1) {
                        // 수정 메서드 호출
                    } else {
                        // 삭제 메서드 호출
                    }
                    break;

                case 4:
                    System.out.println("=== 등록계좌 조회 ===");
                    System.out.println("1. 이름으로 조회 2. 계좌번호로 조회 3. 전체 조회");
                    int num3 = sc.nextInt();

                    if (num3 == 1) {
                        // 이름 조회 메서드 호출
                    } else if (num3 == 2) {
                        // 계좌번호 조희 메서드 호출
                    } else {
                        // 전체 조회 메서드 호출
                    }
                    break;


                default:
                    System.out.println("다시 입력해 주세요.");
                    break;

            }
        }
    }

    //거래내역 시스템
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

    //
    public static void userInfo () {
        // 유저정보 관련화면
        System.out.println("=== USER 정보 ===");
    }
    //출금
    private static void withdraw(){
        Bank bank = Bank.getInstance();
        System.out.println("출금할 계좌번호를 입력하세요");
        Scanner sc = new Scanner(System.in);
        String inputAccountNum = sc.next();
        if(!bank.confrimAccountNum(inputAccountNum)){
            return;
        }
        System.out.println("계좌 비밀번호를 입력하세요");
        String pwd = sc.next();
        if(!bank.confrimAccountPwd(inputAccountNum,pwd)){
            return;
        }

    }
    //입금
    private static void deposit() {

    }

}
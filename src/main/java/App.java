import service.Bank;
import vo.User;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    Bank bank = Bank.getInstance();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // main 화면, 각 클래스와 관련된 내용으로 연결되고 이후 접속 시 관련 메뉴를 한 번 더 볼 수 있도록 설정
            System.out.println("=== BankSystem에 오신 것을 환영합니다 ===");
            System.out.println("원하시는 메뉴에 해당하는 번호를 입력하세요.");
            System.out.println("1. 은행 관리 2. 거래내역 관리 3. 종료");
            int select = sc.nextInt();

            if (select == 3) {
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

                default:
                    System.out.println("다시 입력해 주세요.");
                    break;

            }
        }
    }

    public static void bankManager() {

        Scanner sc = new Scanner(System.in);
        while (true) {
            // 은행 관리자 화면
            System.out.print("=== 은행 관리 ===");
            System.out.print("원하시는 메뉴에 해당하는 번호를 입력하세요.");
            System.out.print("1. 계좌 등록 2. 등록계좌 수정/삭제 3. 계좌 조회(소유자/계좌번호/전체) 4. 이전");
            int select = sc.nextInt();

            if (select == 4) {
                break;
            }
            switch (select) {
                case 1:
                    Bank bank = Bank.getInstance();
                    System.out.print("=== 계좌 등록 ===");
                    System.out.print("소유주 : ");
                    String name = sc.next();

                    String pattern = "[0-9,\\-]{3,6}\\-[0-9,\\-]{2,6}\\-[0-9,\\-]";
                    System.out.print("계좌번호( ex.xxx-xxxxxx-x ) : ");

                    String accountNum = sc.next();
                    if(!Pattern.matches(pattern,accountNum)){
                        System.out.print("계좌번호 형식이 틀렸습니다!");
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
                    System.out.print("=== 등록계좌 수정 및 삭제 ===");
                    System.out.print("1. 수정 2. 삭제");
                    int num2 = sc.nextInt();

                    if (num2 == 1) {
                        // 수정 메서드 호출
                        System.out.print("수정할 계좌번호를 입력하세요 :");
                        String updateAccountNum = sc.next();
                        // 입력한 계좌번호가 DB에 있는지 확인
                        if(!bank.confirmAccountNum(updateAccountNum)){
                            return;
                        }
                        System.out.print("계좌 비밀번호를 입력하세요 :");
                        String updatePwd = sc.next();
                        // 입력한 계좌의 비밀번호가 맞는지 확인
                        if(!bank.confirmAccountPwd(updateAccountNum,updatePwd)){
                            return;
                        }
                        System.out.print("수정할 정보를 선택하세요!");
                        System.out.print("1.소유주명, 2.은행");
                        int updateContentNum = sc.nextInt();

                        if(updateContentNum == 1){
                            // 소유주명 바꾸기
                            System.out.print("변경할 소유주명 :");
                            String updateUserName = sc.next();
                            bank.updateUserName(updateUserName,updateAccountNum);

                        }else{
                            // 은행명 바꾸기
                            System.out.print("변경할 은행명 : ");
                            String updateBankName = sc.next();
                            bank.updateBankName(updateBankName,updateAccountNum);
                        }


                    } else {
                        // 삭제 메서드 호출
                        System.out.print("삭제할 계좌번호를 입력하세요 :");
                        int deleteAccNum = sc.nextInt();


                    }
                    break;

                case 3:
                    System.out.print("=== 등록계좌 조회 ===");
                    System.out.print("1. 이름으로 조회 2. 계좌번호로 조회 3. 전체 조회");
                    int num3 = sc.nextInt();

                    if (num3 == 1) {
//                        System.out.println("이름을 입력하세요");
//                        String name = sc.nextLine();
                    } else if (num3 == 2) {
//                        System.out.println("계좌번호를 입력하세요");
//                        String accNum = sc.nextLine();
//                        계좌번호로 계좌 클래스 접근, Account 내역 전체 조회
//                        거래내역 조회 메서드
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
    public static void moneyList () {
        Scanner sc = new Scanner(System.in);
//        String accNum = 계좌번호 호출
        while (true) {
            // 입출금내역 관련 화면
            System.out.println("=== 거래내역 관리 ===");
            System.out.println("원하시는 메뉴에 해당하는 번호를 입력하세요.");
            System.out.println("1. 잔고 확인 2. 거래 내역 조회 3. 입금/출금 4. 이전");
            int select = sc.nextInt();

            if (select == 4) {
                break;
            }

            switch (select) {
                case 1:
                    System.out.println("=== 등록계좌 조회 ===");
                    System.out.println("1. 이름으로 조회 2. 계좌번호로 조회 3. 전체 조회");
                    int num3 = sc.nextInt();

                    System.out.print("조회하실 성함을 입력하세요 :");
                    String searchName = sc.next();
                    // 이름 조회 함수 호출

                    if(!bank.searchByUserName(searchName)){
                        return;
                    System.out.println("비밀번호를 입력하세요.");
//                    System.out.println("현재 잔액은 " + 잔액 + " 원 입니다.");
//                    비밀번호를 틀릴 경우
                    break;

                case 2:
                    System.out.println("계좌번호를 입력하세요");
                    String accNum = sc.nextLine();
//                    계좌번호로 계좌 클래스 접근, Account 내역 전체 조회
//                    거래내역 조회 메서드
                    break;

                case 3:
                    System.out.println("=== 입출금 ===");
                    System.out.println("1. 입금 2. 출금");
                    int num = sc.nextInt();

                    if (num == 1) {
                        // return Bank.입금메서드 호출
                        System.out.println("계좌번호를 입력하세요");
                        String accNum = sc.nextLine();
                        System.out.println("당신의 계좌는 " + accNum + "입니다.");
                        System.out.println("현재 잔액" + bank.getStock);
                        System.out.println("입금할 금액을 입력하세요");
                        int Won = sc.nextInt();
                        System.out.println("입금되었습니다.");
                    } else {
                        // retrun Bank.출금메서드 호출
                        System.out.println("계좌번호를 입력하세요");
                        String accNum2 = sc.nextLine();
                        System.out.println("당신의 계좌는 " + accNum2 + "입니다.");
                        System.out.println("현재 잔액" + bank.getStock);
                        System.out.println("입금할 금액을 입력하세요");
                    }
                    break;
                default:
                    System.out.println("다시 입력해 주세요.");
                    break;

            }
        }
    }
}
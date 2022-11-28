import service.Bank;
import vo.Account;
import vo.User;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // main 화면, 각 클래스와 관련된 내용으로 연결되고 이후 접속 시 관련 메뉴를 한 번 더 볼 수 있도록 설정
            System.out.println("=== BankSystem에 오신 것을 환영합니다 ===");
            System.out.println("원하시는 메뉴에 해당하는 번호를 입력하세요.");
            System.out.println("1. 은행 관리 2. 거래내역 및 입출금 3. 종료");
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
        Bank bank = Bank.getInstance();
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 은행 관리자 화면
            System.out.println("=== 은행 관리 ===");
            System.out.println("원하시는 메뉴에 해당하는 번호를 입력하세요.");
            System.out.println("1. 계좌 등록 2. 등록계좌 수정/삭제 3. 계좌 조회(소유자/계좌번호/전체) 4. 이전");
            int select = sc.nextInt();

            if (select == 4) {
                break;
            }
            switch (select) {
                case 1:
                    System.out.println("=== 계좌 등록 ===");
                    System.out.println("소유주 : ");
                    String name = sc.next();
                    String pattern = "[0-9,\\-]{3,6}\\-[0-9,\\-]{2,6}\\-[0-9,\\-]";
                    System.out.print("계좌번호( ex) xxx-xxxxxx-x ) : ");
                    String accountNum = sc.next();

                    if (!Pattern.matches(pattern, accountNum)) {
                        System.out.println("계좌번호 형식이 틀렸습니다!");
                        return;
                    }
                    if (!bank.checkToUsableBankNum(accountNum)) {
                        return;
                    }
                    System.out.print("계좌 비밀번호 설정 :");
                    String pwd = sc.next();

                    System.out.print("은행명 :");
                    String bankName = sc.next();

                    User user = new User(name, 0, accountNum, bankName, pwd);

                    bank.addUser(user);
                    break;

                case 2:

                    System.out.println("=== 등록계좌 수정 및 삭제 ===");
                    System.out.println("1. 수정 2. 삭제");
                    int num2 = sc.nextInt();

                    if (num2 == 1) {
                        // 수정 메서드 호출
                        System.out.print("수정할 계좌번호를 입력하세요 :");
                        String updateAccountNum = sc.next();
                        // 입력한 계좌번호가 DB에 있는지 확인
                        if (!bank.confirmAccountNum(updateAccountNum)) {
                            return;
                        }
                        System.out.print("계좌 비밀번호를 입력하세요 :");
                        String updatePwd = sc.next();
                        // 입력한 계좌의 비밀번호가 맞는지 확인
                        if (!bank.confirmAccountPwd(updateAccountNum, updatePwd)) {
                            return;
                        }
                        System.out.print("수정할 정보를 선택하세요!");
                        System.out.print("1.소유주명, 2.은행");
                        int updateContentNum = sc.nextInt();

                        if (updateContentNum == 1) {
                            // 소유주명 바꾸기
                            System.out.print("변경할 소유주명 :");
                            String updateUserName = sc.next();
                            bank.updateUserName(updateUserName, updateAccountNum);

                        } else {
                            // 은행명 바꾸기
                            System.out.print("변경할 은행명 : ");
                            String updateBankName = sc.next();
                            bank.updateBankName(updateBankName, updateAccountNum);
                        }

                    } else {
                        // 삭제 메서드 호출
                        System.out.print("삭제할 계좌번호를 입력하세요 :");
                        String deleteAccountNum = sc.next();
                        // 입력한 계좌번호가 DB에 있는지 확인
                        if (!bank.confirmAccountNum(deleteAccountNum)) {
                            return;
                        }
                        System.out.println("계좌 비밀번호를 입력하세요 :");
                        String deletePwd = sc.next();
                        // 입력한 계좌의 비밀번호가 맞는지 확인
                        if (!bank.confirmAccountPwd(deleteAccountNum, deletePwd)) {
                            return;
                        }
                        //삭제 메서드 호출
                        bank.deleteAccount(deleteAccountNum);
                        System.out.println("삭제할 계좌번호를 입력하세요 :");
                        int deleteAccNum = sc.nextInt();
                    }
                    break;

                case 3:
                    System.out.println("=== 등록계좌 조회 ===");
                    System.out.println("1. 이름으로 조회 2. 계좌번호로 조회 3. 전체 조회");
                    int num3 = sc.nextInt();

                    if (num3 == 1) {
                        // 이름 조회 메서드 호출
                        System.out.print("조회하실 성함을 입력하세요 :");
                        String searchName = sc.next();

                        if (!bank.confirmAccountName(searchName)) {
                            return;
                        }
                        bank.searchByUserName(searchName);


                    } else if (num3 == 2) {
                        // 계좌번호 조희 메서드 호출
                        System.out.print("조회하실 계좌번호를 입력하세요 :");
                        String searchAccountNum = sc.next();
                        //search
                        if (!bank.confirmAccountNum(searchAccountNum)) {
                            return;
                        }
                         bank.searchByAccountNum(searchAccountNum);


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

    public static void moneyList() {
        Scanner sc = new Scanner(System.in);
        Bank bank = Bank.getInstance();
//        String accNum = 계좌번호 호출
        while (true) {
            // 입출금내역 관련 화면
            System.out.println("=== 거래 내역 및 입출금 ===");
            System.out.println("원하시는 메뉴에 해당하는 번호를 입력하세요.");
            System.out.println("1. 잔고 확인 2. 거래 내역 조회 3. 입금/출금 4. 이전");
            int accountMenu = sc.nextInt();

            if (accountMenu == 4) {
                break;
            }

            switch (accountMenu) {
                case 1:
                    // 잔고확인 메서드
                    System.out.println("=== 계좌잔고 조회 ===");
                    System.out.print("이름을 입력하세요 : "); //이름을 입력하세요
                    String name = sc.nextLine();
                    break;
                case 2:
                    System.out.println("=== 거래내역 조회 ===");
                    System.out.print("이름을 입력하세요 : ");
                    String accountName = sc.next();
                    if (!bank.confirmAccountName(accountName)) {
                        return;
                    }
                    System.out.print("계좌번호를 입력하세요 : ");
                    String AccountNumCaseTwo = sc.next();
                    if (!bank.confirmAccountNum(AccountNumCaseTwo)) {
                        return;
                    }

                    System.out.print("계좌비밀번호를 입력하세요 : ");
                    String serchPwd = sc.next();
                    if (!bank.confirmAccountPwd(AccountNumCaseTwo, serchPwd)) {
                        return;
                    }

                    if(!bank.showAccountList(accountName,AccountNumCaseTwo)){
                        return;
                    }

                    break;
                case 3:
                    System.out.println("=== 입출금 ===");
                    System.out.println("1. 입금 2. 출금");
                    int num = sc.nextInt();

                    if (num == 1) {
                        // return Bank.입금메서드 호출
                        System.out.print("계좌번호를 입력하세요 : ");
                        String AccountNum = sc.next();
                        //search 계좌번호
                        if (!bank.confirmAccountNum(AccountNum)) {
                            return;
                        }
                        System.out.print("계좌 비밀번호를 입력하세요 :");
                        String updatePwd = sc.next();
                        // 입력한 계좌의 비밀번호가 맞는지 확인
                        if (!bank.confirmAccountPwd(AccountNum, updatePwd)) {
                            return;
                        }
                        System.out.print("입금할 금액을 입력하세요 : ");
                        int money = sc.nextInt();
                        bank.deposit(AccountNum,money);
                        System.out.println("입금되었습니다.");
                        Account account = new Account("입금",money,AccountNum);
                        bank.addDepositOrWithdrawList(account);

                    } else if(num == 2){
                        // return Bank.출금메서드 호출
                        System.out.print("계좌번호를 입력하세요 : ");
                        String AccountNum = sc.next();
                        //search 계좌번호
                        if (!bank.confirmAccountNum(AccountNum)) {
                            return;
                        }
                        System.out.print("계좌 비밀번호를 입력하세요 :");
                        String updatePwd = sc.next();
                        // 입력한 계좌의 비밀번호가 맞는지 확인
                        if (!bank.confirmAccountPwd(AccountNum, updatePwd)) {
                            return;
                        }
                        System.out.print("출금할 금액을 입력하세요 : ");
                        int money = sc.nextInt();
                        bank.withdraw(AccountNum,money);
                        System.out.println("출금되었습니다.");
                        Account account = new Account("출금",money,AccountNum);
                        bank.addDepositOrWithdrawList(account);
                    }else{
                        System.out.println("잘못된 번호입니다!!");
                        return;
                    }
                    break;
                default:
                    System.out.println("다시 입력해 주세요.");
                    break;
            }
        }
    }
}
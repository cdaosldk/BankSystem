# BankSystem
은행프로그램 진행과정 기록
  
  2022.11.24
  
  1. 오전 회의
    필수 요구 기능 확인
    투입 간 역할 분담

  
  2. 오전 회의 결과
    필수 요구사항을 구현하기 위한 코드 흐름 정립: 클래스 - 메서드 및 클래스/ 리스트/ DB 테이블 개념 활용

  클래스 정하기
    
    1) Main 클래스(application)
    
    2) USER 정보 (계좌번호 -> 외래 키 , 이름, 비밀번호, 잔고) 클래스 DB 테이블 2
    
    3) 은행 클래스 - 출금/입금 메서드, 계좌 등록, 계좌 찾기(조회) -> (소유주, 계좌번호, 전체 조회), 수정/삭제
    
    4) 입출금 내역 클래스 - 거래일자, 시간, 계좌번호, 입출금여부, 거래금액, 은행명 DB 테이블 2

  *클래스 별로 코드 작성 할당
    
    박상훈 : USER 정보, 은행 클래스 틀 만들기
    
    유성재 : Main 틀 만들기
    
    임동규, 손현진 : 입출금 내역 클래스, 은행 클래스

  프로젝트 소통 방법: 깃허브 브랜치 푸시/풀 시스템을 활용한 프로그램 코드 적용 실습/ 실제 프로젝트 활용

  깃허브 소통 프로세스: 
    
    1) 프로젝트 레포지토리 -> master 브랜치 개설 + 팀원 콜라보레이터 추가
    
    2) master 브랜치에서 Pull하여 로컬 컴퓨터(인텔리제이)에 프로젝트 클론, 그 후 각 팀원들의 개인 브랜치 생성
    
    2-1) 콜라보레이터로 등록된 후 fork 기능을 활용해 본인의 레포지토리에 생성
   
    3) 코드 작업
    
    4) 각 브랜치에 푸시/ 풀 리퀘스트 오픈
    
    5) master 병합
    
    6) master에서 코드를 가져오기위해서는:
    
    origin master 브랜치에서 프로젝트 업데이트로 local master를 업데이트해서 local master를 최신화->
    
    이후 코드 작업을 거쳐 자신의 브랜치에 커밋 & 푸시 &풀 리퀘스트 & 병합 

  
  3. 상호 간 약속:
    
    변수 명/ 클래스 구조 통일
    
    충분한 소통 후 프로젝트 작업하기

  
  2022.11.25
  
  1. 오전 회의
    
    지난 업무 성과 점검
    
    깃허브를 통한 소통 및 코드 교환 과정 실습
    
  
  2. 진행 상황
    
    1) 클래스 간 구조 확정
    
    2) 깃허브 사용중 생겼던 오류 해결 및 정석에 대한 학습 및 실습:
      
      (1) Origin master의 병합이 발생한 후 각 사용자는 본인 브랜치의 작업물을 커밋하여 Local master로 체크아웃한다.
      
      (2) 병합된 Origin master내용을 Local master에서(로) 업데이트(풀)한다.
      
      (3) 각 브랜치에 병합된 내용이 반영된 Local master내용을 병합한다(리베이스X)
      
      (4) 다른 병합이 발생한 경우 위 과정 반복
      
      (+ fork를 활용한 협업은 현재보다 인원이 더 많은 업무를 진행할 경우에 적절하다)


  2022. 11.28
    
    1. 진행 상황
      
      마지막날, 프로젝트 필수 요구 사항을 만족하는 프로그램 코드 작성
       
       1) 입출금 메서드 완성
       
       2) 거래내역 조회 메서드 완성


# bitcamp-java-2018-12
비트캠프(강남센터) 자바반 - UIUX 엔지니어링 및 응용 S/W 엔지니어링 양성과정

## 1일(2018-12-27)
- 리눅스 설치
- 부팅 과정
- 2진수-10진수

## 2일(2018-1-31)
- 인코딩과 디코딩, 압축, 디코더
- 컴파일 방식과 인터프리터 방식
- hello.c 컴파일 및 실행 실습
- JRE 설치
- 바이트코드 프로그래밍 실습(HelloWorld.class)
- OpenJDK 11 설치
- Hello.java 컴파일 및 실행 실습

## 3일(2019-1-2)
- 프로젝트 폴더 준비
    - Maven 프로젝트 디렉토리 구조로 만든다.
    - 깃 서버에 업로드
- 자바 소스 컴파일
    - .java와 .class 파일의 관계
    - 일반 클래스와 public 클래스
    - -d 옵션으로 사용하여 별도의 디렉토리에 .class 파일 생성
- 자바 클래스 실행
    - -classpath 또는 -cp 옵션
    - 패키지 클래스 실행
- 패키지 무소속 클래스와 패키지 소속 클래스
- Eclipse IDE 도구 설치 및 설정
    - 에디터
        - 탭 대신 스페이스로 처리
        - 한 줄 당 글자 수: 100자 안내선  
        - 공백 문자를 흐릿하게 표시
    - 워크스페이스
        - 문자집합 : UTF-8
    - Java / JRE
        - OpenJDK 11 버전으로 설정
        - 단, 회사에서 JDK8을 사용한다면 8로 설정하라.
    - Web
        - HTML, CSS, JSP 문자집합: UTF-8
    - java code style guild 설치
        - google java style guide 검색한 후 github 링크 클릭
        - eclipse-java-google-style.xml을 다운로드 받아 설치한다.
- gradle 빌드 도구 설치
    - apt-get 기본 저장소에는 gradle 최신 버전이 없다.
    - 그래서 최신 버전을 갖고 있는 저장소를 추가해야 한다.
    - apt-get 저장소 추가: $ sudo add-apt-repository ppa:cwchien/gradle
    - 설치: $ sudo apt-get install gradle
- 일반 프로젝트 폴더를 이클립스 프로젝트 폴더로 만들기
    - 이클립스 IDE가 사용할 설정 파일과 디렉토리가 있어야 한다.
    - 예).project, .classpath, .settings/
    - Gradle 빌드 도구를 사용하여 이클립스 프로젝트와 관련된 파일을 자동 생성한다.
    - 절차
        - 1) 프로젝트 디렉토리 생성
        - 2) gradle 초기화 수행 : 프로젝트 폴더에 기본 파일 및 디렉토리 생성
            - $ gradle init --type java-application
        - 3) gradle 빌드 스크립트 파일(build.gradle)에 eclipse 플러그인 추가
            - id 'eclipse' 추가
        - 4) 이클립스 설정 파일 생성
            - $ gradle eclipse
        - 5) 이클립스로 import
- javadoc 사용법
- git 서버 업로드
    - 1) 관리 명단에 등록:
        - bitcamp-java-2018-12$ git add .
    - 2) 명단에 등록된 파일 및 디렉토리 백업:
        - bitcamp-java-2018-12$ git commit -m "메시지"
    - 3) 깃 서버에 업로드:
        - bitcamp-java-2018-12$ git push
- git 저장소 복제
    - git$ git clone https://github.com/아이디/저장소.git
    - git$ git clone https://github.com/아이디/저장소.git 다른디렉토리명

## 4일(2019-1-3)
- 리터럴의 타입과 표기법
- 정수 리터럴의 메모리 크기와 표기법
- 정수 리터럴의 자릿수 표기법
- 정수 값을 메모리에 저장하는 원리
- 부동소수점의 리터럴 메모리 크기와 표기법
- 부동소수점이 메모리에 저장되는 원리

## 5일(2019-1-4)
- 논리 리터럴
- 문자 리터럴과 문자 제어 코드(이스케이프 시퀀스)
- 콘솔 출력 다루기
- 변수 선언과 메모리 크기
- 일반 변수와 레퍼런스 변수
- 키보드 입력 받기, System.in과 Scanner 사용하기

## 6일(2019-1-7)
- 윈도우 환경에서 개발 도구 설치
- 배열 다루기
- 인스턴스와 레퍼런스
- 가비지와 가비지 컬렉터
- 산술 연산자, 동일 타입 연산 동일 타입 결과
- 명시적 형변환과 암시적 형변환
- 연산자 우선순위
- 관계연산자와 등위 연산자
- 부동소수점의 비교 오류

## 7일(2019-1-8)
- 전위 연산자와 후위 연산자
- 논리 연산자와 비트 연산자
- 비트 이동 연산자
- 조건 연산자
- 할당 연산자
- if 조건문, switch 문과 break
- while 반복문, break와 continue

## 8일(2019-1-9)
- 과제 풀이
- do~while
- for(;;)와 for(:)
- 메서드 정의와 사용법
- 파라미터와 리턴 값 다루기
- 메서드 중첩 호출의 실행 순서
- 가변 파라미터와 배열 파라미터
- 로컬 변수의 생성과 소멸
- 메서드 호출과 스택 메모리
- call by value 과 call by reference
- 재귀호출

## 9일(2019-1-10)
- 프로그램 아규먼트 다루기
- JVM 아규먼트 다루기
- JVM 기본 프로퍼티 조회하기
- 클래스 문법의 용도
- 클래스를 정의하고 사용하는 방법
- 레퍼런스와 인스턴의 관계
- 가비지와 가비지 컬렉터, 레퍼런스 카운트
- 로컬 변수와 인스턴스 필드의 초기화
- 레퍼런스 배열 다루기
- 패키지 멤버 클래스와 중첩 클래스
- 패키지 멤버 클래스의 공개, 비공개
- import 명령문

## 10일(2019-1-11)
- 과제 풀이
- 클래스 필드의 목적
- 클래스 로딩과 Method Area 영역의 관계
- 클래스 필드와 인스턴스 필드의 차이점
- 클래스 멤버들
- 클래스 문법의 활용 : 역할에 따라 메서드를 분류한다.
- 패키지의 활용
- 과제1: 자바 기본 문법의 활용(ver. 08) + 과제 풀이
- 과제2: 메서드 문법의 활용(ver. 09) + 과제 풀이
- 과제3: 클래스 문법의 활용(ver. 10)
- 관제4: 패키지의 활용(ver. 11)

## 11일(2019-1-14)
- 과제 풀이
- 클래스 필드와 메서드의 활용법
- 클래스 필드의 한계를 이해하기
- 인스턴스 필드의 활용법
- 인스턴스 메서드의 활용법
- 인스턴스 메서드의 내장 변수 this에 대한 이해
- 'JVM 스택' 메모리의 프레임(frame)에 대한 이해
- 클래스 필드와 인스턴스 필드의 비교
- 인스턴스 멤버들: 인스턴스 필드, 인스턴스 블록, 생성자, 인스턴스 메서드
- 인스턴스 필드를 초기화시켜야 하는 이유와 초기화시키는 다양한 방법 
- 생성자 문법

## 12일(2019-1-15)
- 과제 풀이
- 생성자 활용 : String, java.util.Date, java.util.Calendar
- 디자인 패턴 : Singleton, Factory Method
- String 클래스 사용법 
- Immutable과 Mutable : String과 StringBuffer

## 13일(2019-1-16)
- 과제 풀이 : 14번
- Wrapper 클래스의 역할과 활용법
- 오토 박싱과 오토 언박싱 
- Wrapper 클래스의 생성자가 deprecated 된 이유
- 캡슐화의 필요성과 활용법
- setter/getter와 프로퍼티
- 접근 제한자(modifier): private, (default), protected, public
- 기능을 확장하는 다양한 방법: 기존 코드 변경, 기존 코드 복제
- 상속을 이용한 기능 확장의 이점

## 14일(2019-1-17)
- 과제 풀이 
- 상속의 의미: 수퍼 클래스의 멤버 사용권 획득 
- 상속 관계에서 인스턴스 필드 생성과 초기화 과정
- 상속에서 생성자 호출 과정, super()의 활용
- 다중 상속이 불가한 이유 
- 오버라이딩이 필요한 이유
- 오버라이딩 규칙과 this, super 키워드의 메서드 호출 규칙
- 오버로딩이 필요한 이유와 규칙
- 다형적 변수의 필요성과 사용법
- 다형적 변수와 오버라이딩 메서드
- 다형적 변수와 형변환

## 15일(2019-1-18)
- 과제 풀이
- 상속의 종류: generalization과 specialization
- generalization과 추상 클래스, 추상 메서드
- Object 클래스에 대하여: toString()
- Hash code와 Hash 알고리즘
- HashMap과 Key 클래스, hashCode(), equals()
- 제네릭 사용법

## 16일(2019-1-21)
- 과제 풀이 
- 추상 메서드와 추상 클래스
- 정렬 알고리즘: 다형적 변수, 추상 클래스, 추상 메서드 활용

## 17일(2019-1-22)
- 추상 클래스 활용
- 인터페이스 문법 활용
- 인터페이스와 추상 클래스를 함께 활용하는 예  
- ArrayList 구현 
- JUnit 테스트 프레임워크를 활용하여 단위 테스트 수행하기

## 18일(2019-1-23)
- 디자인 패턴: 템플릿 메서드 패턴 구현 
- 디자인 패턴: 추상 팩토리 패턴 구현 
- Linked List 구현 
- Stack 구현 
- Queue 구현 

## 19일(2019-1-24)
- 중첩 클래스: static / non-static nested 클래스 
- static nested class의 활용 예 : 분류명 다루는 클래스 
- non-static nested class의 활용 예 : LinkedList의 인스턴스를 사용하는 Array 중첩 클래스
- anonymous class : File의 list()에서 사용할 FilenameFilter 구현하기 
- LinkedList, Stack, Queue 에 중첩 클래스 및 제네릭 적용
- 20단계 과제 풀이
- 21단계 과제 풀이
- 인스턴스 복제 : java.lang.Cloneable 인터페이스와 Object.clone() 메서드 
 
## 20일(2019-1-25)
- 22단계 과제 풀이: Queue 사용
- deep clone 개념과 구현
- 23단계 과제 풀이: List 인터페이스 적용  
- Iterator 디자인 패턴
- 24단계 과제 풀이: Iterator 디자인 패턴 적용
- 25단계 과제 풀이: Java Collection API로 교체

## 21일(2019-1-28)
- 자바 컬렉션 API 사용법
- 26단계 과제 풀이: Command 패턴 적용

## 22일(2019-1-29)
- Command 패턴의 개념과 용도
- 예외처리 다루기

## 23일(2019-1-30)
- 예외처리 다루기 II
- Decorator 디자인 패턴 
- Composite 디자인 패턴

## 24일(2019-1-31)
- File 클래스 사용법
- Lambda 문법 다루기

## 25일(2019-2-1)
- 바이너리 데이터 입출력 다루기 
- 버퍼 입출력 다루기 
- 버퍼를 사용할 때 속도가 높아지는 이유 발표
- primitive type  데이터 입출력 다루기 
- 데코레이터 클래스 만들기 
- 문자 데이터 입출력 다루기 

## 26일(2019-2-7)
- 인스턴스 출력 과제 해설
- Serialize/Deserialize 개념
- Serializable 인터페이스 
- ObjectInputStream/ObjectOutputStream 사용법
- transient 한정자의 용도와 사용법
- 29, 30, 31 단계 과제 풀이

## 27일(2019-2-8)
- Observer 디자인 패턴
- 소켓 프로그래밍 : 연결, 대기열, 타임아웃 다루기
- 에코 클라이언트/서버 만들기
- 파일 전송 클라이언트/서버 만들기
- 과제: 계산기 클라이언트/서버 만들기 

## 28일(2019-2-11)
- "계산기 클라이언트/서버 만들기" 과제 풀이
- connectionful/connectionless 방식 비교
- stateful/stateless 통신 구현 : 계산기 클라이언트/서버 만들기
- stateful 응용 : 계산 결과 유지하기
- 과제) stateless 응용 : 계산 결과 유지하기

## 29일(2019-2-12)
- 과제 풀이: stateless 응용 계산기 서버 만들기
- Connection-Oriented와 Connectionless 비교
- DatagramSocket과 DatagramPacket을 이용하여 connectionless 통신 구현하기
- HTTP 클라이언트와 서버 만들기
- URL과 URLConnection 다루기
- apache.org의 HttpClient 라이브러리 사용
- 32단계 과제 풀이: java-project에서 데이터처리 부분을 분리하여 서버로 만들라.

## 30일(2019-2-13)
- 32단계 과제 풀이: java-project에서 데이터처리 부분을 분리하여 서버로 만들라.
- 33단계 과제 풀이: Stateful 방식으로 Stateless 방식으로 전환하기

## 31일(2019-2-14)
- 33단계 과제 풀이: Stateful 방식으로 Stateless 방식으로 전환하기 II
- 통신 기능을 별도의 클래스로 분리하기

## 32일(2019-2-15)
- '프록시 디자인 패턴'의 개념과 용도  
- RMI 기술 개념과 활용하기

## 33일(2019-2-18)
- 33단계 과제 풀이: Stateful 방식으로 Stateless 방식으로 전환하기 III
- 33단계 과제에 프록시 패턴 적용
- Stateless의 한계 확인하기: 여러 클라이언트 요청 시에 문제점 확인
- 34단계 과제 풀이: 멀티 스레드 활용하기
- 멀티태스킹과 CPU 스케줄링
- 프로세스와 스레드
- 스레드 만들기 

## 34일(2019-2-19)
- 스레드 생명주기
- join(), sleep()
- 스레드와 동기화
- 세마포어와 뮤텍스 개념
- 35단계 과제 풀이 : 스레드풀 적용하기
- DBMS와 Vendor API, ODBC API, JDBC API 관계
- JDBC 드라이버의 종류와 구동 방식
- MariaDB 설치
- MariaDB 사용자 및 데이터베이스 생성

## 35일(2019-2-20)
- JDBC 드라이버 준비 및 프로젝트에 등록
- 연습용 게시판 테이블 생성
- CRUD 기본 SQL : select, insert, update, delete
- JDBC 프로그래밍
    - java.sql.Driver 구현체 등록하기
    - DBMS 연결하기, java.sql.Connection 구현체
    - java.sql.Statement 구현체 사용법
    - CRUD JDBC 코드 구현

## 36일(2019-2-21)
- 36단계 과제 풀이(java-project2/src01): DAO에 데이터베이스 적용
- 36단계 과제 풀이(java-project2/src02): Connection 공유
- 36단계 과제 풀이(java-project2/src03): Observer 패턴 적용

## 37일(2019-2-22)
- 37단계 과제풀이(java-project2-client, java-project2-server): Application Server 도입하기
- Application Server 아키텍처의 특징
- Observer 패턴 적용
- 캡슐화 응용 : 응답 기능을 별도의 클래스로 정의 

## 38일(2019-2-25)
- DB 모델링: 
    - 주요 용어
    - 수퍼 키, 후보 키, 기본 키, 대리 키, 대체 키, 외래 키
    - 엔티티 식별 및 속성 식별
    - 제1정규화 방법
    - 제2정규화 방법
    - 부모 테이블과 자식 테이블의 관계
    - 식별 관계와 비식별 관계

## 39일(2019-2-26)
- DB 모델링: 
  - 제3정규화 방법
  - 다대다 관계를 해소하는 방법
  - 포함관계 및 배타적 관계의 개념과 모델링 방법
  - 관계 차수 설정
  - 유니크 컬럼 지정
  - null 컬럼과 인덱스 컬럼 지정
  - 물리 모델링과 도메인 정의
  - 자동 증가 컬럼 지정
  - 포워딩 엔지니어링과 리버스 엔지니어링

## 40일(2019-2-27)
- DB 모델링 과제 리뷰
- SQL DDL 사용법 

## 41일(2019-2-28)
- SQL DDL 사용법(계속)
    - 테이블 생성, 삭제
    - 뷰 생성, 삭제
    - 인덱스 생성, 삭제
- SQL DML 사용법
    - insert 사용법
    - update 사용법
    - delete 사용법
    - transcation 다루기: commit과 rollback
    - join의 종류와 사용법

## 42일(2019-3-4)
- 38단계 과제풀이 : 트랜잭션의 필요성과 다루는 방법
- 사진 게시판 및 첨부파일 기능 구현
- JDBC 프로그래밍 : setAutoCommit(), commit(), rollback() 사용법

## 43일(2019-3-5)
- 프로젝트에 멀티 스레드 적용하기: 
    - stateful 방식과 stateless 방식의 차이점
    - 싱글 스레드의 한계 확인
    - 멀티 스레드로 전환
- 39단계 과제풀이: 멀티 스레드에서 싱글 커넥션을 사용할 때의 문제점과 해결책
    - 멀티 스레드가 같은 커넥션을 사용하면 클라이언트들의 작업이 서로 영향을 끼친다.
    - DAO 별로 커넥션을 따로 사용한다.
- 40단계 과제풀이: 한 스레드에서 여러 DB 작업을 수행할 때 커넥션을 공유하기
    - 스레드 로컬을 사용하여 스레드 마다 자신만의 커넥션을 유지할 수 있다.
- 41단계 과제풀이: 커넥션풀을 적용하여 커넥션 재활용하기 

## 44일(2019-3-6)
- mybatis 퍼시스턴스 프레임워크 사용법 I
    - 설정하기
    - SqlSession 얻기
    - SQL 실행하기
    - 결과 값 받기: select
    - 클래스에 별명 부여하기
    - 컬럼과 프로퍼티 연결하기
    - in-parameter 전달하기: insert
- Builder 디자인 패턴 개념과 사용법

## 45일(2019-3-7)
- mybatis 퍼시스턴스 프레임워크 사용법 II
    - dynamic sql 다루기
    - join 데이터 다루기

## 46일(2019-3-8)
- 43단계 과제풀이: Mybatis 적용

## 47일(2019-3-11)
- 43단계 과제풀이: Mybatis에 트랜잭션 적용하기
  - 트랜잭션 관리자 만들기
  - 프록시 디자인 패턴을 이용하여 SqlSessionFactory와 SqlSession 객체에 기능을 추가하고 변경하기
- 44단계 과제풀이: Mybatis의 동적 SQL 적용하기
  - sql, bind, foreach 태그 사용하기

## 48일(2019-3-12)
- java.lang.reflect.Proxy.newProxyInstance() 를 사용하여 인터페이스 구현체 자동 생성하는 방법
- 45 단계 과제풀이: DAO 구현체 자동생성하기

## 49일(2019-3-13)
- 45 단계 과제풀이: Mybatis에게 제공하는 DAO 자동 생성 기능 사용하기
- 46 단계 과제풀이: 커맨드 클래스의 인스턴스 자동 생성하기

## 50일(2019-3-14)
- 애노테이션 다루기
    - 애노테이션 정의하는 방법
    - 애노테이션을 사용하는 방법
    - 실행 할 때(runtime) 클래스에서 애노테이션 정보 추출하기
- 47 단계 과제풀이: 애노테이션을 활용하여 커맨드 객체 자동 생성하기
- 48 단계 과제풀이: 인터페이스 대신 애노테이션으로 메서드 구분하기
- 49 단계 과제풀이: CRUD 메서드를 묶어 한 클래스로 분류하기

## 51일(2019-3-15)
- Spring 프레임워크의 클래스 설정 방식 모방하기
- 50 단계 과제풀이: Spring IoC 컨테이너 도입 
- 51 단계 과제풀이: Spring IoC 컨테이너와 Mybatis 연동

## 52일(2019-3-18)
- Spring IoC 컨테이너 사용법 I

## 53일(2019-3-19)
- Spring IoC 컨테이너 사용법 II

## 54일(2019-3-20)
- Spring IoC 컨테이너 사용법 III
- Mybatis-Spring 연동 방법

## 55일(2019-3-21)
- Spring AOP 다루기

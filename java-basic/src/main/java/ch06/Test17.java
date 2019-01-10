// JVM 아규먼트 응용 I
package ch06;

public class Test17 {
  public static void main(String[] args) {
    // JVM 아규먼트로 학생의 이름과 국영수 점수를 입력 받아 총점과 평균을 출력하라
    //   $java -cp ./bin/main -Dname=홍길동 -Dkor=100 -Deng=100 -Dmath=90 ch06.Test17
    //
    
    String name = System.getProperty("name");
    String s1 = System.getProperty("kor");
    String s2 = System.getProperty("eng");
    String s3 = System.getProperty("math");
    
    if (name == null || s1 == null || s2 == null || s3 == null) {
      System.out.println("실행 형식: java -cp ./bin/main -Dname=이름 -Dkor=국어점수 -Deng=영어점수 -Dmath=수학점수 ch06.Test17");
      return;
    }
    int kor = Integer.parseInt(s1);
    int eng = Integer.parseInt(s2);
    int math = Integer.parseInt(s3);
    
    
    int sum = kor + eng + math;
    
    System.out.printf("이름: %s\n", name);
    System.out.printf("총점: %d\n", sum);
    System.out.printf("평균: %.1f\n",sum / 3f);
    
  }
}

/*
# 프로그램 아규먼트(arguments)
- 프로그램을 실행할 때 넘겨주는 값.
- 어떻게 아규먼트를 넘기는가?
  $ java 클래스명 값1 값2 값3
- 아규먼트는 공백으로 구분한다.
- 각 아규먼트는 문자열 배열에 보관된다.
- JVM은 아규먼트의 개수만큼 문자열 배열을 만들어 저장한다.
- 아규먼트가 없으면 빈 배열을 만든다.
- 그런후 main()을 호출할 때 그 배열의 주소를 넘겨준다.
 */

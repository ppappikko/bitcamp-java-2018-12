// JVM 아규먼트
package ch06;

public class Test16 {
  public static void main(String[] args) {
    // JVM 아규먼트?
    // - JVM에게 전달하는 값
    // - 형식
    //   $java -cp ./bin/main -D이름=값 -D이름=값 -D이름=값 ch06.Test16
    //
    
    //JVM 아규먼트의 값 꺼내기
    // => System.getProperty("이름")
    String value1 = System.getProperty("a");
    String value2 = System.getProperty("b");
    String value3 = System.getProperty("c");
    
    System.out.println(value1);
    System.out.println(value2);
    System.out.println(value3);
    
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

// JVM 아규먼트 응용 II
package ch06;

public class Test18 {
  public static void main(String[] args) {
    // JVM 기본으로 설정되어 있는 프로퍼티를 모두 출력하라!
    //
    
    // JVM의 전체 프로퍼티 목록 가져오기
    java.util.Properties props = System.getProperties();
    
    java.util.Set keySet = props.keySet();
    
    for (Object key : keySet) {
      String value = System.getProperty((String)key);
      System.out.printf("%s = %s\n", key, value);
    }
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

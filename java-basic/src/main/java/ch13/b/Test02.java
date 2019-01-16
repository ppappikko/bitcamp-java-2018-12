// 기능 확장하기 - Score 클래스를 상속 받아 기능 추가하기
package ch13.b;

public class Test02 {
  public static void main(String[] args) {
    
    // Score2를 이용하여 수퍼 클래스의 기능을 호출할 수 있다.
    //
    Score2 s2 = new Score2();
    s2.setName("홍길동"); // Score의 메서드
    s2.setKor(100); // Score의 메서드
    s2.setEng(100); // Score의 메서드
    s2.setMath(100); // Score의 메서드
    s2.setMusic(100); // Score2의 메서드
    s2.setArt(100); // Score2의 메서드
    System.out.printf("%s: %d(%.1f)\n", s2.getName(), s2.getSum(), s2.getAver());
    
  }
}

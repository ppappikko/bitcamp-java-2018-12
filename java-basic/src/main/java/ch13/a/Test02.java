// 기능 확장하기 - Score 클래스에 음악과 미술 과목을 추가하기
package ch13.a;

public class Test02 {
  public static void main(String[] args) {
    
    Score2 s2 = new Score2();
    s2.setName("홍길동");
    s2.setKor(100);
    s2.setEng(100);
    s2.setMath(100);
    s2.setMusic(100);
    s2.setArt(100);
    System.out.printf("%s: %d(%.1f)\n", s2.getName(), s2.getSum(), s2.getAver());
    
  }
}

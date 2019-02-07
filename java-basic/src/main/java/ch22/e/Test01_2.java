// 인스턴스 읽기
package ch22.e;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class Test01_2 {
  
  public static void main(String[] args) {
    
    // score.data 파일에서 세 학생의 성적 정보를 읽어 Score 인스턴스로 생성하라!
    // => java.io.BufferedInputStream 클래스를 사용하라.
    // => java.io.DataOInputStream 클래스를 사용하라.
    Score s1 = null;
    Score s2 = null;
    Score s3 = null;
    
    try (DataInputStream in = new DataInputStream(
        new BufferedInputStream(
        new FileInputStream("score.data")))) {
      
      s1 =
          new Score(in.readUTF(), in.readInt(), in.readInt(), in.readInt());
      s2 =
          new Score(in.readUTF(), in.readInt(), in.readInt(), in.readInt());
      s3 =
          new Score(in.readUTF(), in.readInt(), in.readInt(), in.readInt());
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("읽기 완료!");
    
    // 그리고 세 학생의 정보를 다음과 같은 형식으로 출력하라!
    // => 홍길동, 100, 100, 100, 300, 100.0
    //
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);
  }
  
}

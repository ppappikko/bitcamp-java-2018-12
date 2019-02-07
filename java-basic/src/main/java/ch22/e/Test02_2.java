// 인스턴스 읽기 - 배열을 활용
package ch22.e;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class Test02_2 {
  
  public static void main(String[] args) {
    
    // score.data 파일에서 세 학생의 성적 정보를 읽어 Score 인스턴스로 생성하라!
    // => java.io.BufferedInputStream 클래스를 사용하라.
    // => java.io.DataOInputStream 클래스를 사용하라.
    Score[] students = null;
    
    try (DataInputStream in = new DataInputStream(
        new BufferedInputStream(
        new FileInputStream("score.data")))) {
      
      // 배열을 개수 만큼 만들기 위해서 처음에 저장해 놓은 크기를 불러온다.
      int len = in.readInt();
      students = new Score[len];
      
      for (int i = 0; i < students.length; i++) {
        Score s = new Score(in.readUTF(), in.readInt(), in.readInt(), in.readInt());
        students[i] = s;
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("읽기 완료!");
    
    // 그리고 세 학생의 정보를 다음과 같은 형식으로 출력하라!
    // => 홍길동, 100, 100, 100, 300, 100.0
    //
    for (Score s : students) {
      System.out.println(s);
    }
    
  }
  
}

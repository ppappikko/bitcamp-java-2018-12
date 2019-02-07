// 인스턴스 출력하기 - 배열을 활용
package ch22.e;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Test02_1 {

  public static void main(String[] args) {

    // 다음 세 학생의 성적 정보를 score.data 파일에 바이너리 형식으로 저장하라!
    // => java.io.BufferedOutputStream 클래스를 사용하라.
    // => java.io.DataOutputStream 클래스를 사용하라.
    //
    Score[] students = {
        new Score("홍길동", 100, 100, 100),
        new Score("임꺽정", 90, 90, 90),
        new Score("유관순", 80, 80, 80)
    };
    try (DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(
        new FileOutputStream("score.data")))) {
      
      out.writeInt(students.length); // 몇개의 데이터가 있는지 알려주기 위해 배열의 크기를 먼저 출력한다.
      
      for (Score s : students) { // 인덱스를 따로 사용할 필요 없고 배열 전체를 반복할 때 사용
        out.writeUTF(s.getName());
        out.writeInt(s.getKor());
        out.writeInt(s.getEng());
        out.writeInt(s.getMath());
      }

      out.flush();

    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("출력 완료!");

  }

}

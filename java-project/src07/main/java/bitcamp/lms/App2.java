// 1,2,3 단계 실행
package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    final int length = 10;
    Member[] members = new Member[length];
    
    int index = 0;
    while (index < length) {
      Member member = new Member();
      System.out.print("번호? ");
      member.num = Integer.parseInt(keyboard.nextLine());

      System.out.print("이름? ");
      member.name = keyboard.nextLine();

      System.out.print("이메일? ");
      member.email = keyboard.nextLine();

      System.out.print("암호? ");
      member.password = keyboard.nextLine();

      System.out.print("사진? ");
      member.photo = keyboard.nextLine();

      System.out.print("전화? ");
      member.tel = keyboard.nextLine();

      member.registeredDate = new Date(System.currentTimeMillis()); 

      System.out.println();
      
      members[index] = member;
      index++;

      // 계속 진행할 것인가?
      System.out.println("계속 입력 하시겠습니까?(Y/n) ");
      String answer = keyboard.nextLine();
      if (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("")) {
        break;
      }
    }

    // 사용후 스캐너 객체의 자원을 해제한다.
    keyboard.close();

    System.out.println(); // 빈 줄 출력

    for (int i = 0; i < index; i++) {
      System.out.printf("%3d, %-20s, %-30s, %-10s, %-20s, %s, %s\n", 
          members[i].num, members[i].name, members[i].email, members[i].password, 
          members[i].photo, members[i].tel, members[i].registeredDate);
    }
  }
}

package design_pattern.command.after;

// Command 규칙에 따라 동작하는 클래스를 정의한다.
// 각 명령어를 처리하는 메서드를 클래스로 분리한다.
public class BoardListCommand implements Command {

  @Override
  public void exectue() {
    System.out.println("게시물 목록조회 처리!");
  }
  
}

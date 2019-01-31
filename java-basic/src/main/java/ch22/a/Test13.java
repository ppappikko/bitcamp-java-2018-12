// java.io.File 클래스 : 연습 과제 - bin 폴더를 삭제하라!
package ch22.a;

import java.io.File;

public class Test13 {
  
  public static void main(String[] args) throws Exception {
    
    // bin 하위 폴더와 파일을 모두 삭제해야만 bin 폴더를 삭제할 수 있다.
    // => 재귀 호출을 이용할 것
    File dir = new File("./bin");
    
    delete(dir);
    
    System.out.println("삭제 완료!");
  }
  
  static void delete(File dir) {
    
    // 파일의 하위 디렉토리와 파일 목록을 얻는다. pseudo code
    File[] files = dir.listFiles();
    
    // 파일 목록에서 파일을 하나 꺼낸다.
    for (File file : files) {
      if (file.isFile()) {
        // 만약 파일이면 삭제한다.
        file.delete();
        
      } else {
        // 디렉토리면 delete() 호출하여 삭제한다.
        delete(file);
      }
    }
    // 마지막으로 디렉토리를 삭제한다.
    dir.delete();
  }

}

// select 결과 값을 자바 인스턴스에 온전히 담는 방법 II
//
package ch26.d;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test04 {

  public static void main(String[] args) throws Exception {
    
    // 1) mybatis-config.xml 변경
    //    - 클래스 전체 이름에 대해 별명을 지정한다.
    // 2) BoardMapper.xml 변경
    //    - 결과를 담을 클래스를 지정할 때 클래스 전체 이름을 사용하는 대신에
    //      mybatis 설정 파일에 등록된 별명을 사용할 수 있다.
    //
    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/d/mybatis-config.xml");
    
    InputStream inputStream2 = new FileInputStream(
        "/home/bitcamp/git/bitcamp-java-2018-12/java-basic/src/main/java/ch26/d/mybatis-config.xml");
    
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    // select 문에서 컬럼을 값을 자바 인스턴스의 프로퍼티와 맞추기 위해
    // 별명을 부여하는 방식은 번거롭다.
    // 특히 컬럼 개수가 많은 경우 더더욱 번거롭다.
    // 이를 해결하기 위해 mybatis는 컬럼의 이름과 프로퍼티 이름을 연결해주는 문법을 제공한다.
    //      <resultMap></resultMap>
    //
    Board2 board = sqlSession.selectOne("board.select5");
    System.out.println(board);
    
  }

}

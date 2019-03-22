package com.eomcs.lms.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.service.LessonService;

// 스프링 IoC 컨테이너가 관리하는 객체 중에서
// 비즈니스 로직을 담당하는 객체는
// 특별히 그 역할을 표시하기 위해 @Component 대신에 @Service 애노테이션을 붙인다.
// 이렇게 애노테이션으로 구분해 두면 나중에 애노테이션으로 객체를 찾을 수 있다.
@Service
public class LessonServiceImpl implements LessonService {

  LessonDao lessonDao;
  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;

  public LessonServiceImpl(
      LessonDao lessonDao,
      PhotoBoardDao photoBoardDao,
      PhotoFileDao photoFileDao) {

    this.lessonDao = lessonDao;
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public List<Lesson> list() {
    return lessonDao.findAll();
  }

  @Override
  public int add(Lesson lesson) {
    return lessonDao.insert(lesson);
  }

  @Override
  public Lesson get(int no) {
    return lessonDao.findByNo(no);
  }

  @Override
  public int update(Lesson lesson) {
    return lessonDao.update(lesson);
  }

  @Override
  public int delete(int no) {

    HashMap<String,Object> params = new HashMap<>();
    params.put("lessonNo", no);

    List<PhotoBoard> boards = photoBoardDao.findAll(params);
    for (PhotoBoard board : boards) {
      photoFileDao.deleteByPhotoBoardNo(board.getNo());
      photoBoardDao.delete(board.getNo());
    }
    
    return lessonDao.delete(no);
  }
}

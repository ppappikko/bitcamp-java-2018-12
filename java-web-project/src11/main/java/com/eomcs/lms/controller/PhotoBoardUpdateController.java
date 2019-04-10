package com.eomcs.lms.controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;

@Controller
public class PhotoBoardUpdateController {

  // 의존객체는 생성자에서 받는 것을 권고한다.
  @Autowired PhotoBoardService photoBoardService;

  @RequestMapping("/photoboard/update")
  public String execute(
      HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    PhotoBoard board = new PhotoBoard();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setLessonNo(Integer.parseInt(request.getParameter("lessonNo")));

    ArrayList<PhotoFile> files = new ArrayList<>();
    Collection<Part> photos = request.getParts();

    String uploadDir = request.getServletContext().getRealPath("/upload/photoboard");

    for (Part photo : photos) {
      if (photo.getSize() == 0 || !photo.getName().equals("photo")) {
        continue;
      }

      String filename = UUID.randomUUID().toString();
      photo.write(uploadDir + "/" + filename);

      PhotoFile file = new PhotoFile();
      file.setFilePath(filename);
      file.setPhotoBoardNo(board.getNo());
      files.add(file);
    }

    board.setFiles(files);

    if (files.size() == 0) {
      throw new Exception("최소 한 개의 사진 파일을 등록해야 합니다.");
    }
    
    photoBoardService.update(board);
    return "redirect:list";
  }
}

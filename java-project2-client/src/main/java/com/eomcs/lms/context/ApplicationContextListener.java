package com.eomcs.lms.context;

import java.util.Map;

public interface ApplicationContextListener {
  // 호출될 때
  void contextInitialized(Map<String,Object> context) throws ApplicationContextException;
  
  // 종료될 때
  void contextDestroyed(Map<String,Object> context) throws ApplicationContextException;
  
}

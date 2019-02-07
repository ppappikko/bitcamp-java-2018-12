package com.eomcs.lms.context;

import java.util.Map;

public interface ApplicationContextListener {
  
  void startApplication(Map<String,Object> context);
  
  void endApplication(Map<String,Object> context);
  
}

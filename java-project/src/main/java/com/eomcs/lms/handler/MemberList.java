package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Member;

public class MemberList {
  
  private int LENGTH = 10;
  private Member[] memberList = new Member[LENGTH];
  private int boardIdx = 0;
  
  public MemberList() {
    
  }
  
  public MemberList(int LENGTH) {
    this.LENGTH = LENGTH;
  }
  
  public Member[] toArray() {
    // 전체 배열의 크기 100이라면,
    // 현재 들어있는 항목만 따로 배열을 만들어 리턴한다
    Member[] boards = new Member[boardIdx];
    for (int i = 0; i < boardIdx; i++) {
      boards[i] = memberList[i];
    }
    return boards;
  }
  
  public void add(Member member) {
    memberList[boardIdx] = member;
    boardIdx++;
  }
}

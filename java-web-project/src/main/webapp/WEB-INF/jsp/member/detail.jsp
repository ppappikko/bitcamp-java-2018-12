<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>회원 조회</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="${contextRootPath}/css/common.css">
</head>
<body>

<jsp:include page="../header.jsp"/>

<div class="container">
  <h1>회원 조회</h1>
<c:choose>
<c:when test="${empty member}">
  <p>해당하는 회원이 없습니다.</p>
</c:when>
<c:otherwise>
  <form action='update' method='post' enctype='multipart/form-data'>
  
  <div class="form-group row">
    <label for="no" class="col-sm-2 col-form-label">번호</label>
    <div class="col-sm-8">
      <input type="text" class="form-control-plaintext" id="no" name='no'
              value='${member.no}' readonly>
    </div>
  </div>
  <div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">이름</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="name" name='name'
              value='${member.name}'>
    </div>
  </div>
  <div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">이름</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="name" name='name'
              value='${member.name}'>
    </div>
  </div>
  <div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">이름</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="name" name='name'
              value='${member.name}'>
    </div>
  </div>
  <div class="form-group row">
    <label for="email" class="col-sm-2 col-form-label">이메일</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="email" name='email'
              value='${member.email}'>
    </div>
  </div>
  <div class="form-group row">
    <label for="password" class="col-sm-2 col-form-label">비밀번호</label>
    <div class="col-sm-8">
      <input type="password" class="form-control" id="password" name='password'>
    </div>
  </div>
  <div class="form-group row">
    <c:set var="contextRootPath" value="${pageContext.servletContext.contextPath}"></c:set>
      <c:if test="${empty member.photo}">
          <img src='${contextRootPath}/images/default.jpg' style='height: 80px'><br>
      </c:if>
      <c:if test="${not empty member.photo}">
          <img src='${contextRootPath}/upload/member/${member.photo}' style='height: 80px'><br>
      </c:if>
    <label for="photoFile" class="col-sm-2 col-form-label">사진</label>
    <div class="col-sm-8">
      <input type="file" class="form-control" id="photoFile" name='photoFile'>
    </div>
  </div>
  
  
  
  
      <tr>
        <th>전화</th>
        <td><input type='text' name='tel' value='${member.tel}'></td>
      </tr>
      <tr>
        <th>가입일</th>
        <td>${member.registeredDate}</td>
      </tr>
    </table>
    <p>
      <a href='.'>목록</a> <a href='delete/${member.no}'>삭제</a>
      <button type='submit'>변경</button>
    <p>
  </form>
</c:otherwise>
</c:choose>
</div> <!-- .container -->

<jsp:include page="../javascript.jsp"/>
</body>
</html>
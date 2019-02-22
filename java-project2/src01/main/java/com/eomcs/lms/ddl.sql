-- 게시판 테이블 삭제
drop table p_board;

-- 게시판 테이블 생성
create table p_board (
  board_id int not null primary key auto_increment,
  contents text null,
  created_date datetime null default now(),
  view_count int null default 0
);

-- 데이터 입력
insert into p_board(contents)
values('내용');

-- 데이터 목록 조회
select
  board_id,
  created_date,
  view_count
from
  p_board
order by board_id desc;

-- 데이터 상세 조회
select
  board_id,
  contents,
  created_date,
  view_count
from
  p_board
where
  board_id = 3;

-- 데이터 변경
update p_board set
  view_count = view_count + 1,
  created_date = now()
where
  board_id = 3;

-- 데이터 삭제
delete from p_board
where
  board_id = 3;


-- 회원 테이블 삭제
drop table p_member;

-- 회원 테이블 생성
create table p_member (
  member_id int not null primary key auto_increment,
  name varchar(255) not null,
  email varchar(255) not null,
  password varchar(255) not null,
  photo varchar(255) not null,
  tel varchar(255) not null,
  registered_date datetime null default now()
);

-- 데이터 입력
insert into p_member(name, email, password, photo, tel)
values('이름', '이메일', '비밀번호', '사진', '전화번호');

-- 데이터 목록 조회
select
  member_id,
  name,
  email,
  photo
from
  p_member
order by member_id desc;

-- 데이터 상세 조회
select
  member_id,
  name,
  email,
  password,
  photo,
  tel,
  registered_date
from
  p_member
where
  member_id = 1;

-- 데이터 변경
update p_member set
  name = 'hong',
  email = 'hong@test.com',
  password = '4444',
  photo = 'hong.jpg',
  tel = '1111-4444'
where
  lesson_id = 1;

-- 데이터 삭제
delete from p_member
where
  member_id = 3;

  
-- 수업 테이블 삭제
drop table p_lesson;

-- 수업 테이블 생성
create table p_lesson (
  lesson_id int not null primary key auto_increment,
  title varchar(255) not null,
  contents text null,
  start_date datetime not null,
  end_date datetime not null,
  total_hours int not null,
  day_hours int not null
);

-- 데이터 입력
insert into p_lesson(title, contents, start_date, end_date, total_hours, day_hours)
values('수업명', '수업내용', '2018-12-28', '2019-07-01', '1000', '8');

-- 데이터 목록 조회
select
  lesson_id,
  title,
  start_date,
  end_date
from
  p_lesson
order by lesson_id desc;

-- 데이터 상세 조회
select
  lesson_id,
  title,
  contents,
  start_date,
  end_date,
  total_hours,
  day_hours
from
  p_lesson
where
  lesson_id = 1;

-- 데이터 변경
update p_lesson set
  title = '수업명1',
  contents = '수업내용1',
  start_date = '시작일1',
  end_date = '종료일1',
  total_hours = '총시간1',
  day_hours = '일시간1'
where
  lesson_id = 1;

-- 데이터 삭제
delete from p_lesson
where
  lesson_id = 1;

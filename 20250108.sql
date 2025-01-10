/*******************************
상태관리
쿠키/세션
인증/인가
권한이 있어야 글쓰기를 할 수  있어요.
회원가입을 하란말야 -  이름, 아이디대신 이메일, 아이디 핸드폰번호
작성자는 입력받는 값이 아니다.
로그인을 하면 세션이나 쿠키에 이름, 닉네임, uid, id - 보안
시간동안 유지된다.안써도 된다. 입력받지 않아도 괜찮아.
작성자는 로그인시에 저장해둔 이름으로 자동처리할것. -요구사항
*******************************/

create table react_member(
    email varchar2(30)constraints react_member_email primary key,
    mem_pw varchar2(10) not null,
    nickname varchar2(30),
    zonecode varchar2(10),
    mem_addr varchar2(100),
    mem_addr2 varchar2(30),
    reg_date varchar2(30)
);

create table react_board(
    b_no number(5) constraints react_board_no primary key,
    b_title varchar2(100) not null,
    email varchar2(30) not null,
    b_content varchar2(4000),
    b_hit number(5) default 0,
    b_date varchar2(20),
    b_file varchar2(200)
);

create table react_board_comment(
    bc_no number(5) constraints react_board_comment_no primary key,
    email varchar2(30),
    bc_comment varchar2(4000),
    bc_date varchar2(20),
    b_no number(5)
);

-- react_member 테이블
INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('kosmo@example.com', 'pwd1', '코스모', '12345', '서울 금천구', '가산디지털2로 101', '2025-01-01');

INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('egane@example.com', 'pwd2', '떡볶이', '67890', '부산시 중구', '부평1길 48', '2025-01-02');

INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('kintex@example.com', 'pwd3', '킨텍스', '11223', '경기도 고양시 일산서구', '킨텍스로 217-60', '2025-01-03');

INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('sungsim4@example.com', 'pwd4', '성심당', '44556', '대전시 중구', '대종로480번길 15', '2025-01-04');

INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('mansuk@example.com', 'pwd5', '닭강정', '77889', '강원 속초시', '청초호반로 72', '2025-01-05');

-- react_board 테이블
INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '성심당 맛있어', 'sungsim4@example.com', '명란바게트 맛있어요!', 0, '2025-01-01', 'file1.jpg');

INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '빵 맛있어', 'sungsim4@example.com', '빵 가성비가 좋아요', 0, '2025-01-02', 'file2.jpg');

INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '컨퍼런스', 'kintex@example.com', '성공적인 세미나', 0, '2025-01-03', 'file3.jpg');

INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '닭강정 맛있어', 'mansuk@example.com', '속초는 닭강정?', 0, '2025-01-04', 'file4.jpg');

INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '코딩 잘하는 법', 'kosmo@example.com', 'GPT를 사용해볼까?', 0, '2025-01-05', 'file5.jpg');

-- react_board_comment 테이블
INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'sungsim4@example.com', '좋은 글 감사합니다.', '2025-01-01', 1);

INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'sungsim4@example.com', '공유 감사해요', '2025-01-02', 1);

INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'sungsim4@example.com', '흥미롭네요', '2025-01-03', 2);

INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'kosmo@example.com', '열심히 해야죠!', '2025-01-04', 5);

INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'kintex@example.com', '세미나 내용 좋아요', '2025-01-05', 3);

select * from react_board;

select * from react_board_comment;

select * from react_member;

commit;

SELECT react_member.nickname
  FROM react_board
  JOIN react_member
    ON react_board.email = react_member.email
 WHERE react_board.b_title like '%맛있어%';
 
SELECT nickname FROM REACT_MEMBER
  WHERE email = (
                 SELECT email FROM REACT_BOARD 
                   WHERE b_title = :x
                );
                
SELECT *
  FROM react_member RM, REACT_BOARD RB
  WHERE RM.email = RB.email;
  
SELECT RM.nickname, RB.email
  FROM react_member RM, REACT_BOARD RB
 WHERE RM.email = RB.email
   AND RB.b_title = '빵 맛있어';
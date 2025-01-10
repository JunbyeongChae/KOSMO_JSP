/* Formatted on 2025/01/09 오후 4:37:32 (QP5 v5.287) */
SELECT * FROM REACT_BOARD;

SELECT * FROM REACT_BOARD_COMMENT;

SELECT * FROM REACT_MEMBER;

-- 게시글테이블과 댓글테이블은 1:N관계이다.
-- 게시판 테이블의 b_no가 댓글 테이블에 외래키가 되었다.

-- 게시판목록 조회

SELECT RB.b_no,
       RB.b_title,
       RB.b_content,
       RB.b_hit,
       RB.b_date,
       RM.NICKNAME
  FROM REACT_BOARD RB, REACT_MEMBER RM
 WHERE RB.EMAIL = RM.EMAIL;

SELECT b_no, b_title, b_content, b_hit, b_date FROM REACT_BOARD;

-- 게시판 검색

SELECT RB.b_no,
       RB.b_title,
       RB.b_content,
       RB.b_hit,
       RB.b_date,
       RM.NICKNAME
  FROM REACT_BOARD RB, REACT_MEMBER RM
 WHERE RB.EMAIL = RM.EMAIL AND RB.b_title LIKE '%' || '맛있어' || '%';

SELECT RB.b_no,
       RB.b_title,
       RB.b_content,
       RB.b_hit,
       RB.b_date,
       RM.NICKNAME
  FROM REACT_BOARD RB, REACT_MEMBER RM
 WHERE RB.EMAIL = RM.EMAIL AND RB.b_content LIKE '%' || '맛있어' || '%';

SELECT RB.b_no,
       RB.b_title,
       RB.b_content,
       RB.b_hit,
       RB.b_date,
       RM.NICKNAME
  FROM REACT_BOARD RB, REACT_MEMBER RM
 WHERE RB.EMAIL = RM.EMAIL AND RM.NICKNAME LIKE '%' || '코스모' || '%';

SELECT bc_no, bc_comment
  FROM REACT_BOARD_COMMENT
 WHERE b_no = 1;

SELECT bc_no, bc_comment
  FROM REACT_BOARD_COMMENT
 WHERE b_no = 2;

SELECT bc_no, bc_comment
  FROM REACT_BOARD_COMMENT
 WHERE b_no = 3;

SELECT bc_no, bc_comment
  FROM REACT_BOARD_COMMENT
 WHERE b_no = 4;

SELECT bc_no, bc_comment
  FROM REACT_BOARD_COMMENT
 WHERE b_no = 5;

SELECT RBC.bc_no, RBC.bc_comment
  FROM REACT_BOARD_COMMENT RBC JOIN REACT_BOARD RB ON RBC.b_no = RB.b_no
 WHERE RB.b_no = :x;

-- count는 그룹함수이다.
-- count 파라미터에 *사용하면 전체로우를 세어준다.
-- count 파라민터에 컬럼명이 오는 경우 null인 경우에 null값은 배제

SELECT COUNT (*), COUNT (COMM) FROM EMP;

SELECT COMM FROM EMP;

SELECT COMM
  FROM EMP
 WHERE COMM >= 0;

SELECT DEPTNO, COUNT (*) FROM EMP;

  SELECT DEPTNO, COUNT (*)
    FROM EMP
GROUP BY DEPTNO;

SELECT RB.b_no,
       RB.b_title,
       RB.b_content,
       RB.b_hit,
       RB.b_date,
       RM.nickname
  FROM REACT_BOARD RB, REACT_MEMBER RM
 WHERE RB.email = RM.email
 AND RB.b_title LIKE '%'||'컨퍼런스'||'%'
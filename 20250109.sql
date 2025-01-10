/* Formatted on 2025/01/09 ���� 4:37:32 (QP5 v5.287) */
SELECT * FROM REACT_BOARD;

SELECT * FROM REACT_BOARD_COMMENT;

SELECT * FROM REACT_MEMBER;

-- �Խñ����̺�� ������̺��� 1:N�����̴�.
-- �Խ��� ���̺��� b_no�� ��� ���̺� �ܷ�Ű�� �Ǿ���.

-- �Խ��Ǹ�� ��ȸ

SELECT RB.b_no,
       RB.b_title,
       RB.b_content,
       RB.b_hit,
       RB.b_date,
       RM.NICKNAME
  FROM REACT_BOARD RB, REACT_MEMBER RM
 WHERE RB.EMAIL = RM.EMAIL;

SELECT b_no, b_title, b_content, b_hit, b_date FROM REACT_BOARD;

-- �Խ��� �˻�

SELECT RB.b_no,
       RB.b_title,
       RB.b_content,
       RB.b_hit,
       RB.b_date,
       RM.NICKNAME
  FROM REACT_BOARD RB, REACT_MEMBER RM
 WHERE RB.EMAIL = RM.EMAIL AND RB.b_title LIKE '%' || '���־�' || '%';

SELECT RB.b_no,
       RB.b_title,
       RB.b_content,
       RB.b_hit,
       RB.b_date,
       RM.NICKNAME
  FROM REACT_BOARD RB, REACT_MEMBER RM
 WHERE RB.EMAIL = RM.EMAIL AND RB.b_content LIKE '%' || '���־�' || '%';

SELECT RB.b_no,
       RB.b_title,
       RB.b_content,
       RB.b_hit,
       RB.b_date,
       RM.NICKNAME
  FROM REACT_BOARD RB, REACT_MEMBER RM
 WHERE RB.EMAIL = RM.EMAIL AND RM.NICKNAME LIKE '%' || '�ڽ���' || '%';

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

-- count�� �׷��Լ��̴�.
-- count �Ķ���Ϳ� *����ϸ� ��ü�ο츦 �����ش�.
-- count �Ķ���Ϳ� �÷����� ���� ��� null�� ��쿡 null���� ����

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
 AND RB.b_title LIKE '%'||'���۷���'||'%'
/*******************************
���°���
��Ű/����
����/�ΰ�
������ �־�� �۾��⸦ �� ��  �־��.
ȸ�������� �϶����� -  �̸�, ���̵��� �̸���, ���̵� �ڵ�����ȣ
�ۼ��ڴ� �Է¹޴� ���� �ƴϴ�.
�α����� �ϸ� �����̳� ��Ű�� �̸�, �г���, uid, id - ����
�ð����� �����ȴ�.�Ƚᵵ �ȴ�. �Է¹��� �ʾƵ� ������.
�ۼ��ڴ� �α��νÿ� �����ص� �̸����� �ڵ�ó���Ұ�. -�䱸����
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

-- react_member ���̺�
INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('kosmo@example.com', 'pwd1', '�ڽ���', '12345', '���� ��õ��', '���������2�� 101', '2025-01-01');

INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('egane@example.com', 'pwd2', '������', '67890', '�λ�� �߱�', '����1�� 48', '2025-01-02');

INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('kintex@example.com', 'pwd3', 'Ų�ؽ�', '11223', '��⵵ ���� �ϻ꼭��', 'Ų�ؽ��� 217-60', '2025-01-03');

INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('sungsim4@example.com', 'pwd4', '���ɴ�', '44556', '������ �߱�', '������480���� 15', '2025-01-04');

INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('mansuk@example.com', 'pwd5', '�߰���', '77889', '���� ���ʽ�', 'û��ȣ�ݷ� 72', '2025-01-05');

-- react_board ���̺�
INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '���ɴ� ���־�', 'sungsim4@example.com', '����ٰ�Ʈ ���־��!', 0, '2025-01-01', 'file1.jpg');

INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '�� ���־�', 'sungsim4@example.com', '�� ������ ���ƿ�', 0, '2025-01-02', 'file2.jpg');

INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '���۷���', 'kintex@example.com', '�������� ���̳�', 0, '2025-01-03', 'file3.jpg');

INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '�߰��� ���־�', 'mansuk@example.com', '���ʴ� �߰���?', 0, '2025-01-04', 'file4.jpg');

INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '�ڵ� ���ϴ� ��', 'kosmo@example.com', 'GPT�� ����غ���?', 0, '2025-01-05', 'file5.jpg');

-- react_board_comment ���̺�
INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'sungsim4@example.com', '���� �� �����մϴ�.', '2025-01-01', 1);

INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'sungsim4@example.com', '���� �����ؿ�', '2025-01-02', 1);

INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'sungsim4@example.com', '��̷ӳ׿�', '2025-01-03', 2);

INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'kosmo@example.com', '������ �ؾ���!', '2025-01-04', 5);

INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'kintex@example.com', '���̳� ���� ���ƿ�', '2025-01-05', 3);

select * from react_board;

select * from react_board_comment;

select * from react_member;

commit;

SELECT react_member.nickname
  FROM react_board
  JOIN react_member
    ON react_board.email = react_member.email
 WHERE react_board.b_title like '%���־�%';
 
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
   AND RB.b_title = '�� ���־�';
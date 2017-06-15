CREATE TABLE p_user(
id int PRIMARY KEY auto_increment,
name VARCHAR (20),
sex CHAR (2)
);
INSERT INTO p_user(name,sex) VALUES ('A','男');
INSERT INTO p_user(name,sex) VALUES ('B','女');
INSERT INTO p_user(name,sex) VALUES ('C','男');

drop PROCEDURE mybatis.ges_user_count;

-- #创建存储过程（查询得到男性或女性的数量，如果传入的是0就女性否则是男性）
DELIMITER $
CREATE PROCEDURE mybatis.ges_user_count(IN sex_id int,OUT user_count INT )
BEGIN
 if sex_id = 0 THEN
 SELECT count(*) from mybatis.p_user where p_user.sex='女' INTO user_count;
 ELSE
 select count(*) from mybatis.p_user where p_user.sex='男' into user_count;
 end if ;
END
$

-- #调用存储过程
DELIMITER ;
ALTER database mybatis  CHARACTER set utf8;
ALTER TABLE p_user convert to CHARACTER set utf8;
SET @user_count=0;
call mybatis.ges_user_count(1,@user_count);
SELECT @user_count;

show VARIABLES like 'character_set_%';
show variables like '%coll%';
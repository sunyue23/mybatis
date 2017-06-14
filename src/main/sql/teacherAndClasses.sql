CREATE TABLE teacher(
t_id INT PRIMARY KEY AUTO_INCREMENT,
t_name VARCHAR(20)
);
CREATE TABLE class(
c_id INT PRIMARY KEY AUTO_INCREMENT,
c_name VARCHAR(20),
teacher_id INT
);
ALTER TABLE class ADD constraint fk_teacher_id FOREIGN KEY (teacher_id) REFERENCES  teacher(t_id);
INSERT INTO teacher(t_name) VALUES ('LS1');
INSERT INTO teacher(t_name) VALUES ('LS2');

INSERT INTO class(c_name,teacher_id) VALUES ('bj_a',1);
INSERT INTO class(c_name,teacher_id) VALUES ('bj_2',2);
CREATE TABLE Student(
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(250) NOT NULL,
                        nick_name VARCHAR(50),
                        picture_url VARCHAR(300) NOT NULL
);

CREATE TABLE Winner(
                       student_id INT PRIMARY KEY,
                       selected_date DATE NOT NULL,
                       performed_date DATE NOT NULL,
                       CONSTRAINT fk_winner_student FOREIGN KEY (student_id) REFERENCES Student (id)
);

CREATE TABLE MetaData(
                         `key` VARCHAR(50) PRIMARY KEY,
                         value VARCHAR(250)
);
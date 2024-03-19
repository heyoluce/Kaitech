CREATE TABLE IF NOT EXISTS courses (
                                       id SERIAL PRIMARY KEY,
                                       course_name VARCHAR(255),
                                       cost INTEGER,
                                       duration_in_months INTEGER,
                                       description VARCHAR(255),
                                       image_url VARCHAR(255),
                                       status VARCHAR(255),
                                       number_of_lessons INTEGER
);

CREATE TABLE IF NOT EXISTS mentors (
                                       id SERIAL PRIMARY KEY,
                                       username VARCHAR(255),
                                       name VARCHAR(255),
                                       phone_number VARCHAR(255),
                                       salary INTEGER,
                                       status VARCHAR(255),
                                       course_id BIGINT,
                                       image_url VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS students (
                                        id SERIAL PRIMARY KEY,
                                        name VARCHAR(255),
                                        username VARCHAR(255),
                                        phone_number VARCHAR(255),
                                        status VARCHAR(255),
                                        group_id BIGINT,
                                        date_of_birth TIMESTAMP WITHOUT TIME ZONE,
                                        gender VARCHAR(255),
                                        total_debt DECIMAL,
                                        total_payment DECIMAL
);

CREATE TABLE IF NOT EXISTS groups (
                                      id SERIAL PRIMARY KEY,
                                      group_name VARCHAR(255),
                                      course_id BIGINT,
                                      mentor_id BIGINT,
                                      max_capacity INTEGER,
                                      start_date DATE,
                                      end_date DATE,
                                      status VARCHAR(255),
                                      image_url VARCHAR(255),
                                      days VARCHAR(255),
                                      start_time TIME WITHOUT TIME ZONE,
                                      end_time TIME WITHOUT TIME ZONE
);

CREATE TABLE IF NOT EXISTS payment (
                                       id SERIAL PRIMARY KEY,
                                       student_id BIGINT,
                                       sum INTEGER,
                                       date DATE,
                                       payment_type SMALLINT
);

CREATE TABLE IF NOT EXISTS users (
                                     id SERIAL PRIMARY KEY,
                                     name VARCHAR(255),
                                     username VARCHAR(255),
                                     password VARCHAR(255),
                                     date_of_birth DATE,
                                     phone_number VARCHAR(255),
                                     role VARCHAR(255),
                                     enabled BOOLEAN,
                                     image_url VARCHAR(255),
                                     last_visit_date TIMESTAMP WITHOUT TIME ZONE,
                                     status VARCHAR(255)
);

ALTER TABLE mentors
    ADD CONSTRAINT fk_mentors_course FOREIGN KEY (course_id) REFERENCES courses (id);

ALTER TABLE students
    ADD CONSTRAINT fk_students_group FOREIGN KEY (group_id) REFERENCES groups (id);

ALTER TABLE groups
    ADD CONSTRAINT fk_groups_course FOREIGN KEY (course_id) REFERENCES courses (id),
    ADD CONSTRAINT fk_groups_mentor FOREIGN KEY (mentor_id) REFERENCES mentors (id);

ALTER TABLE payment
    ADD CONSTRAINT fk_payment_student FOREIGN KEY (student_id) REFERENCES students (id);

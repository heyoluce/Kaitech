create type role as enum ('ADMIN', 'SUPER_ADMIN');
create type status as enum ('ACTIVE', 'DELETED');
create type gender as enum ('MALE', 'FEMALE');
create type paymentType as enum ('CREDIT_CARD', 'CASH');
create type dayOfTheWeek as enum ('MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY', 'SUNDAY');

create table users
(
    id           bigserial primary key,
    first_name    varchar(255),
    last_name     varchar(255),
    date_of_birth date,
    phone_number varchar(255),
    email varchar(255) unique,
    password varchar(255),
    role role,
    enabled boolean,
    image_url varchar(255),
    last_visit_date timestamp,
    status status
);
create table courses
(
    id bigserial primary key ,
    name varchar(255),
    cost integer,
    duration_in_months integer,
    description varchar(255),
    image_url varchar(255),
    status status,
    number_of_lessons integer
);

create table mentors
(
    id bigserial primary key ,
    email varchar(255) unique ,
    first_name varchar(255),
    last_name varchar(255),
    phone_number varchar(255),
    salary integer,
    status status,
    course_id int references courses(id),
    image_url varchar(255)
);

create table groups
(
    id bigserial primary key ,
    name varchar(255),
    course_id integer references courses(id),
    mentor_id integer references mentors(id),
    max_capacity integer,
    start_date date,
    end_date date,
    status status,
    image_url varchar(255),
    days dayOfTheWeek,
    start_time time,
    end_time time
);

create table students
(
    id           bigserial primary key,
    first_name    varchar(255),
    last_name     varchar(255),
    email varchar(255) unique ,
    phone_number varchar(255),
    status status,
    group_id int references groups(id),
    date_of_birth date,
    gender gender,
    total_debt numeric(10,2),
    total_payment numeric(10,2)
);

create table groups_students
(
    id bigserial primary key ,
    student_id int,
    group_id int ,
    creation_date timestamp,
    constraint groups_students_students foreign key (student_id) references students(id) on delete cascade on update no action,
    constraint groups_students_groups foreign key (group_id) references groups(id) on delete cascade on update no action
);

create table payment
(
    id bigserial primary key ,
    student_id int references students(id),
    sum integer,
    date timestamp,
    payment_type paymentType
);

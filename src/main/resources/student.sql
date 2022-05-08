SELECT id, age, country, mobile, student_name
FROM `hibernate-hql`.`students`;

select sum(age) from students;

select avg(age) from students;

select count(*) from students;

select country ,avg(age) from students  group by country;

select country ,count(*) from students group by country;

select * from students where student_name='Ram';

select * from students where student_name='Venkat can\'t';

create table employee(
    personId varchar(50),
    employeeId VARCHAR(20),
    name VARCHAR(50) not null,
    designation VARCHAR(30),
    PRIMARY KEY (personId)
);

insert into employee VALUES
  ('f2e7b3d3-ab7c-4bbc-ad45-0fd46883e34e','intern-01','Siva Prasad Raju','Intern in Engineering'),
  ('9bc59b76-f2b2-4087-ba0c-725d1cc7f834','intern-02','Manoj','Intern in Engineering'),
  ('2825dfa6-38f6-4c77-84ad-1d66cb183490','intern-03','Lokesh','Intern in Engineering'),
  ('c177f4be-e905-4fdb-bdf5-cd3c4116a7fc','intern-04','Harika','Intern in Engineering');
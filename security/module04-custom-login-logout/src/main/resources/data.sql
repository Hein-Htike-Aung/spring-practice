

insert into Users (username, password, algorithm) values ('karina', '$2a$12$qlf5eU4mNcnBKjy5wDRGluM6OW9gCcCMA5eeGgPlITql56SaEF2nu' ,'BCRYPT');
insert into Authorities (authority, users_id) values ('read', 1);
insert into Authorities (authority, users_id) values ('write', 1);

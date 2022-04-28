



insert into Users (name) values ('karina');
insert into Authorities (role, authority, users) values ('ADMIN', 'READ', 1);
insert into Authorities (role, authority, users) values ('ADMIN', 'WRITE', 1);
insert into Authorities (role, authority, users) values ('MANAGER', 'READ', 1);
insert into Authorities (role, authority, users) values ('MANAGER', 'WRITE', 1);

insert into Users (name) values ('xiaoting');
insert into Authorities (role, authority, users) values ('MANAGER', 'READ', 2);
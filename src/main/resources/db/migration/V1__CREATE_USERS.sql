use ktknowledge_db;

create table users (
  id int not null primary key auto_increment,
  name varchar(50) not null,
  created_at datetime not null,
  updated_at datetime not null
);
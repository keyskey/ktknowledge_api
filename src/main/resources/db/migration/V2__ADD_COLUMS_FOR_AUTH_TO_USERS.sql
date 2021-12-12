ALTER TABLE users ADD (email varchar(255) not null, password varchar(60) not null);
ALTER TABLE users ADD UNIQUE idx_id_email (id, email);

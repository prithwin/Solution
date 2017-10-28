-- you can create these tables in any online table editor and try out a varity of commands that have
-- been listed here, this is a simple thing just to make your life easier root@localhost: .Sk>%;KZo96w

create table users (
  id int PRIMARY KEY,
  user_name VARCHAR(25),
  password VARCHAR(25),
  profile_pic VARCHAR(256)
);

create table followers (
  id          INT PRIMARY KEY,
  user_id     INT ,
  follower_id INT
  CONSTRAINT f_uid_fk REFERENCES users
)
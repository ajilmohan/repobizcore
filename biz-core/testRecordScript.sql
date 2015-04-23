
-- Test record to populate dictionary show table
insert into `biz-core`.dicnshow (NAME,SHOWTIME) values ('9 AM','9 AM');
insert into `biz-core`.dicnshow (NAME,SHOWTIME) values ('2 PM','2 PM');
insert into `biz-core`.dicnshow (NAME,SHOWTIME) values ('6 PM','6 PM');
insert into `biz-core`.dicnshow (NAME,SHOWTIME) values ('9 PM','9 PM');

--Test records for transaction show table.
insert into `biz-core`.trnshow (STATUS,DICN_ID,MOVIE_ID,SCREEN_ID) values ('RUNNING',1,1,1);
insert into `biz-core`.trnshow (STATUS,DICN_ID,MOVIE_ID,SCREEN_ID) values ('RUNNING',2,1,1);
insert into `biz-core`.trnshow (STATUS,DICN_ID,MOVIE_ID,SCREEN_ID) values ('RUNNING',3,1,1);
insert into `biz-core`.trnshow (STATUS,DICN_ID,MOVIE_ID,SCREEN_ID) values ('RUNNING',4,1,1);
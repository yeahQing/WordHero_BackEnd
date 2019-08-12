
-- Admin表

create table word_hero.Admin(
	admin_id int(0) auto_increment comment '管理员id',
	admin_name varchar(255) not null comment '管理员姓名',
	admin_password varchar(255) not null comment '管理员密码',
	primary key(admin_id),
	unique index u_admin_name(admin_name)
);

insert into word_hero.Admin(admin_name,admin_password) values("admin","123456");

-- User表

create table word_hero.User(
	user_id int(0) auto_increment comment '用户id',
	username varchar(255) not null comment '用户名',
	password varchar(255) not null comment '密码',
	mobile varchar(255) comment '手机号',
	score int(0) DEFAULT 0  comment '积分',
	level_id int(0) DEFAULT 1  comment '题库等级',
	primary key(user_id),
	unique index u_user_name(username),
	unique index u_user_mobile(mobile),
	CONSTRAINT `f_level_id` foreign key (`level_id`) REFERENCES `Library_Level` (`level_id`)
);

insert into word_hero.User(username,password,mobile) values("Andy","123456","13948524675");

-- Word表

create table word_hero.Word(
	word_id int(0) auto_increment comment '单词id',
	word_name varchar(255) not null comment '单词名',
	word_translate varchar(255) not null comment '翻译',
	primary key(word_id),
	unique index u_word_name(word_name)
);

insert into word_hero.Word(word_name,word_translate) values("Hello","你好");

-- Library表
-- 从单词表查找翻译和题库表中问题匹配
-- select word_id,ques_id,word_translate from Word left join Library on Library.ques_name = Word.word_name;
create table word_hero.Library(
	ques_id int(0) auto_increment comment '问题id',
	ques_name varchar(255) not null comment '问题名',
	option_1 varchar(255) not null comment '选项1',
	option_2 varchar(255) not null comment '选项2',
	option_3 varchar(255) not null comment '选项3',
	option_4 varchar(255) not null comment '选项4',
	level_id int(0) DEFAULT 1  comment '题库等级',
	primary key(ques_id),
	CONSTRAINT `f_level_id` foreign key (`level_id`) REFERENCES `Library_Level` (`level_id`)
);


insert into word_hero.Library(ques_name,option_1,option_2,option_3,option_4) values("Hello","再见","你好","拜拜","哈哈");

-- 题库难度表
create table word_hero.Library_Level(
	level_id int(0) comment '难度id',
	level_name varchar(255) not null comment '难度名',
	primary key(level_id)
);

insert into  word_hero.Library_Level(level_id,level_name) values(1,"小学水平");
insert into  word_hero.Library_Level(level_id,level_name) values(2,"中学水平");
insert into  word_hero.Library_Level(level_id,level_name) values(3,"大学水平");

-- 查询对应题库id的等级名
select level_name from Library,Library_Level where Library.level_id = Library_Level.level_id; 

-- 查询指定题库的问题
SELECT * FROM Library WHERE ques_id >= (SELECT FLOOR( MAX(ques_id) * RAND()) FROM Library) AND level_id = 3 ORDER BY ques_id LIMIT 1 ;
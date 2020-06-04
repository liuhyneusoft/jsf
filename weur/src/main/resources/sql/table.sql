create table t_user(
	id int PRIMARY KEY AUTO_INCREMENT,
	username varchar(40),
	password varchar(40),
	firstname varchar(40),
	lastname varchar(40),
	contact_number varchar(40),
	reg_datetime date,
	reg_code varchar(40),
	force_rest_password boolean,
	active boolean
);

create table t_mentor(
	id int PRIMARY KEY AUTO_INCREMENT,
	username varchar(40),
	linkedin_url varchar(40),
	reg_datetime date,
	reg_code varchar(40),
	years_of_experience varchar(40),
	active boolean
);

create table t_mentor_skills(
	id int PRIMARY KEY AUTO_INCREMENT,
	mid int,
	self_rating double,
	years_of_exp int,
	trainings_delivered  varchar(40),
	facilities_offered varchar(40)
);

create table t_mentor_calendar(
	id int PRIMARY KEY AUTO_INCREMENT,
	mid int,
	start_date date,
	end_date date
);

create table t_skills(
	id int PRIMARY KEY AUTO_INCREMENT,
	Name  varchar(40),
	TOC  varchar(40),
	Duration  varchar(40),
	Prerequites  varchar(40)
);

create table t_training(
	id int PRIMARY KEY AUTO_INCREMENT, 
	user_id int,
	mentor_id int,
	skill_id int,
	status varchar(40), 
	progress varchar(40), 
	rating double, 
	start_date date , 
	end_date date,
	amount_received double
);

create table t_payment(
	id int PRIMARY KEY AUTO_INCREMENT,
	mentor_id int ,
	training_id int,
	txn_type varchar(40),
	amount double ,
	pay_date date,
	remarks varchar(400)
);


create table t_admin(
	id int PRIMARY KEY AUTO_INCREMENT,
	username varchar(40),
	password varchar(40)
);
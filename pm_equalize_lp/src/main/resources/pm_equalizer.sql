CREATE TABLE public.pm_equalizer (
	pm_equalizer_id int NOT NULL,
	account_id int NOT NULL,
	signature varchar(50) NULL,
	creation_date date NULL,
	confirmation_date date NULL,
	pm_previous_value varchar(500) NULL,
	notification_type varchar(20) NOT NULL,
	CONSTRAINT pm_equalizer_pk PRIMARY KEY (pm_equalizer_id)
);
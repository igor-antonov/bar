--DROP TABLE IF EXISTS USERS;
--DROP TABLE IF EXISTS DRINKS;
--DROP TABLE IF EXISTS DRINK_TYPES;

CREATE TABLE IF NOT EXISTS DRINK_TYPES
(
  DRINK_TYPE_ID serial NOT NULL,
  DRINK_TYPE_NAME varchar(200) NOT NULL,
  POWER INTEGER NOT NULL,
  CONSTRAINT DRINK_TYPE_PKEY PRIMARY KEY (DRINK_TYPE_ID)
);

CREATE TABLE IF NOT EXISTS DRINKS
(
  DRINK_ID serial NOT NULL,
  DRINK_NAME varchar(200),
  DRINK_TYPE_ID INTEGER,
  AMOUNT INTEGER,
  PRICE INTEGER,
  CREATION_DATE DATE,
  FOREIGN KEY (DRINK_TYPE_ID) REFERENCES DRINK_TYPES(DRINK_TYPE_ID),
  CONSTRAINT ALCOHOL_PKEY PRIMARY KEY (DRINK_ID)
);

CREATE TABLE IF NOT EXISTS USERS
(
  LOGIN varchar(20) NOT NULL,
  FULL_NAME varchar(100),
  PASSWORD varchar(200) NOT NULL,
  CREATION_DATE DATE,
  USER_ROLE varchar(20),
  MONEY INTEGER,
  DRUNKENNESS INTEGER,
  FAVORITE_DRINK_ID INTEGER,
  FOREIGN KEY (FAVORITE_DRINK_ID) REFERENCES DRINKS(DRINK_ID),
  CONSTRAINT USERS_PKEY PRIMARY KEY (LOGIN)
);
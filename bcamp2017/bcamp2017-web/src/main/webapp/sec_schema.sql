CREATE TABLE security.user_roles
(
  user_name character varying(15) NOT NULL,
  role_name character varying(15) NOT NULL,
  CONSTRAINT user_roles_pkey PRIMARY KEY (user_name, role_name)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE security.users
(
  user_name character varying(15) NOT NULL,
  user_pass character varying(15) NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (user_name)
)
WITH (
  OIDS=FALSE
);
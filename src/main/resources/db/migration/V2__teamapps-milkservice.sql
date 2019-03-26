-- MILK PURCHASES id sequence
create sequence teamapps.milk_purchases_id_seq
  minvalue 100
  cycle;

-- MILK PURCHASES table
create table teamapps."milk_purchases"
(
  id integer default nextval('teamapps.milk_purchases_id_seq' :: regclass) not null
     constraint pk_milk_purchases
     primary key,
  user_id integer REFERENCES teamapps."user"(id) ON DELETE CASCADE,
  bottles integer not null,
  bottle_quantity integer not null,
  purchase_date  TIMESTAMP not null,
  status varchar(255) DEFAULT 'VALID' not null
);
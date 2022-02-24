CREATE TABLE IF NOT EXISTS public.users
(
    id character varying NOT NULL,
    name character varying COLLATE ,
    age integer,
    CONSTRAINT user_pk PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS public.user_contact
(
    id character varying NOT NULL,
    address character varying,
    user_id character varying ,
    CONSTRAINT user_contact_pk PRIMARY KEY (id),
    CONSTRAINT user_contact_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
--
-- PostgreSQL database dump
--

-- Dumped from database version 13.0
-- Dumped by pg_dump version 13.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: drunker; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE drunker;


ALTER DATABASE drunker OWNER TO postgres;

\connect drunker

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: drunker; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA drunker;


ALTER SCHEMA drunker OWNER TO postgres;

SET default_tablespace = '';

--
-- Name: usr; Type: TABLE; Schema: drunker; Owner: postgres
--

CREATE TABLE drunker.usr (
                             id bigint NOT NULL,
                             fio character varying(256) NOT NULL,
                             login character varying(128) NOT NULL,
                             password character varying(256) NOT NULL,
                             phone character varying(50),
                             email character varying(50),
                             role_id bigint NOT NULL
);


ALTER TABLE drunker.usr OWNER TO postgres;

--
-- Name: User_id_seq; Type: SEQUENCE; Schema: drunker; Owner: postgres
--

CREATE SEQUENCE drunker."User_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE drunker."User_id_seq" OWNER TO postgres;

--
-- Name: User_id_seq; Type: SEQUENCE OWNED BY; Schema: drunker; Owner: postgres
--

ALTER SEQUENCE drunker."User_id_seq" OWNED BY drunker.usr.id;


--
-- Name: basket_of_goods; Type: TABLE; Schema: drunker; Owner: postgres
--

CREATE TABLE drunker.basket_of_goods (
                                         id bigint NOT NULL,
                                         tea_id bigint NOT NULL,
                                         user_id bigint NOT NULL,
                                         count_in_card integer NOT NULL
);


ALTER TABLE drunker.basket_of_goods OWNER TO postgres;

--
-- Name: basket_of_goods_id_seq; Type: SEQUENCE; Schema: drunker; Owner: postgres
--

CREATE SEQUENCE drunker.basket_of_goods_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE drunker.basket_of_goods_id_seq OWNER TO postgres;

--
-- Name: basket_of_goods_id_seq; Type: SEQUENCE OWNED BY; Schema: drunker; Owner: postgres
--

ALTER SEQUENCE drunker.basket_of_goods_id_seq OWNED BY drunker.basket_of_goods.id;


--
-- Name: image; Type: TABLE; Schema: drunker; Owner: postgres
--

CREATE TABLE drunker.image (
                               id bigint NOT NULL,
                               name character(256) NOT NULL,
                               type character(128)
);


ALTER TABLE drunker.image OWNER TO postgres;

--
-- Name: image_id_seq; Type: SEQUENCE; Schema: drunker; Owner: postgres
--

CREATE SEQUENCE drunker.image_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE drunker.image_id_seq OWNER TO postgres;

--
-- Name: image_id_seq; Type: SEQUENCE OWNED BY; Schema: drunker; Owner: postgres
--

ALTER SEQUENCE drunker.image_id_seq OWNED BY drunker.image.id;


--
-- Name: kind_of_tea; Type: TABLE; Schema: drunker; Owner: postgres
--

CREATE TABLE drunker.kind_of_tea (
                                     id bigint NOT NULL,
                                     name character varying(128) NOT NULL
);


ALTER TABLE drunker.kind_of_tea OWNER TO postgres;

--
-- Name: kind_of_tea_id_seq; Type: SEQUENCE; Schema: drunker; Owner: postgres
--

CREATE SEQUENCE drunker.kind_of_tea_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE drunker.kind_of_tea_id_seq OWNER TO postgres;

--
-- Name: kind_of_tea_id_seq; Type: SEQUENCE OWNED BY; Schema: drunker; Owner: postgres
--

ALTER SEQUENCE drunker.kind_of_tea_id_seq OWNED BY drunker.kind_of_tea.id;


--
-- Name: notification; Type: TABLE; Schema: drunker; Owner: postgres
--

CREATE TABLE drunker.notification (
                                      id bigint NOT NULL,
                                      user_id bigint NOT NULL,
                                      tea_id bigint NOT NULL
);


ALTER TABLE drunker.notification OWNER TO postgres;

--
-- Name: notification_id_seq; Type: SEQUENCE; Schema: drunker; Owner: postgres
--

CREATE SEQUENCE drunker.notification_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE drunker.notification_id_seq OWNER TO postgres;

--
-- Name: notification_id_seq; Type: SEQUENCE OWNED BY; Schema: drunker; Owner: postgres
--

ALTER SEQUENCE drunker.notification_id_seq OWNED BY drunker.notification.id;


--
-- Name: role; Type: TABLE; Schema: drunker; Owner: postgres
--

CREATE TABLE drunker.role (
                              id bigint NOT NULL,
                              name character varying(50) NOT NULL
);


ALTER TABLE drunker.role OWNER TO postgres;

--
-- Name: role_id_seq; Type: SEQUENCE; Schema: drunker; Owner: postgres
--

CREATE SEQUENCE drunker.role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE drunker.role_id_seq OWNER TO postgres;

--
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: drunker; Owner: postgres
--

ALTER SEQUENCE drunker.role_id_seq OWNED BY drunker.role.id;


--
-- Name: sort_of_tea; Type: TABLE; Schema: drunker; Owner: postgres
--

CREATE TABLE drunker.sort_of_tea (
                                     id bigint NOT NULL,
                                     name character varying(256) NOT NULL
);


ALTER TABLE drunker.sort_of_tea OWNER TO postgres;

--
-- Name: sort_of_tea_id_seq; Type: SEQUENCE; Schema: drunker; Owner: postgres
--

CREATE SEQUENCE drunker.sort_of_tea_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE drunker.sort_of_tea_id_seq OWNER TO postgres;

--
-- Name: sort_of_tea_id_seq; Type: SEQUENCE OWNED BY; Schema: drunker; Owner: postgres
--

ALTER SEQUENCE drunker.sort_of_tea_id_seq OWNED BY drunker.sort_of_tea.id;


--
-- Name: tea; Type: TABLE; Schema: drunker; Owner: postgres
--

CREATE TABLE drunker.tea (
                             id bigint NOT NULL,
                             name character varying(256) NOT NULL,
                             sort_tea_id bigint NOT NULL,
                             count_on_warehouse integer NOT NULL,
                             kind_id bigint
);


ALTER TABLE drunker.tea OWNER TO postgres;

--
-- Name: tea_id_seq; Type: SEQUENCE; Schema: drunker; Owner: postgres
--

CREATE SEQUENCE drunker.tea_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE drunker.tea_id_seq OWNER TO postgres;

--
-- Name: tea_id_seq; Type: SEQUENCE OWNED BY; Schema: drunker; Owner: postgres
--

ALTER SEQUENCE drunker.tea_id_seq OWNED BY drunker.tea.id;


--
-- Name: basket_of_goods id; Type: DEFAULT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.basket_of_goods ALTER COLUMN id SET DEFAULT nextval('drunker.basket_of_goods_id_seq'::regclass);


--
-- Name: image id; Type: DEFAULT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.image ALTER COLUMN id SET DEFAULT nextval('drunker.image_id_seq'::regclass);


--
-- Name: kind_of_tea id; Type: DEFAULT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.kind_of_tea ALTER COLUMN id SET DEFAULT nextval('drunker.kind_of_tea_id_seq'::regclass);


--
-- Name: notification id; Type: DEFAULT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.notification ALTER COLUMN id SET DEFAULT nextval('drunker.notification_id_seq'::regclass);


--
-- Name: role id; Type: DEFAULT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.role ALTER COLUMN id SET DEFAULT nextval('drunker.role_id_seq'::regclass);


--
-- Name: sort_of_tea id; Type: DEFAULT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.sort_of_tea ALTER COLUMN id SET DEFAULT nextval('drunker.sort_of_tea_id_seq'::regclass);


--
-- Name: tea id; Type: DEFAULT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.tea ALTER COLUMN id SET DEFAULT nextval('drunker.tea_id_seq'::regclass);


--
-- Name: usr id; Type: DEFAULT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.usr ALTER COLUMN id SET DEFAULT nextval('drunker."User_id_seq"'::regclass);


--
-- Data for Name: basket_of_goods; Type: TABLE DATA; Schema: drunker; Owner: postgres
--



--
-- Data for Name: image; Type: TABLE DATA; Schema: drunker; Owner: postgres
--



--
-- Data for Name: kind_of_tea; Type: TABLE DATA; Schema: drunker; Owner: postgres
--



--
-- Data for Name: notification; Type: TABLE DATA; Schema: drunker; Owner: postgres
--



--
-- Data for Name: role; Type: TABLE DATA; Schema: drunker; Owner: postgres
--

INSERT INTO drunker.role VALUES (1, 'test');
INSERT INTO drunker.role VALUES (2, 'test123');


--
-- Data for Name: sort_of_tea; Type: TABLE DATA; Schema: drunker; Owner: postgres
--



--
-- Data for Name: tea; Type: TABLE DATA; Schema: drunker; Owner: postgres
--



--
-- Data for Name: usr; Type: TABLE DATA; Schema: drunker; Owner: postgres
--



--
-- Name: User_id_seq; Type: SEQUENCE SET; Schema: drunker; Owner: postgres
--

SELECT pg_catalog.setval('drunker."User_id_seq"', 1, false);


--
-- Name: basket_of_goods_id_seq; Type: SEQUENCE SET; Schema: drunker; Owner: postgres
--

SELECT pg_catalog.setval('drunker.basket_of_goods_id_seq', 1, false);


--
-- Name: image_id_seq; Type: SEQUENCE SET; Schema: drunker; Owner: postgres
--

SELECT pg_catalog.setval('drunker.image_id_seq', 1, false);


--
-- Name: kind_of_tea_id_seq; Type: SEQUENCE SET; Schema: drunker; Owner: postgres
--

SELECT pg_catalog.setval('drunker.kind_of_tea_id_seq', 1, false);


--
-- Name: notification_id_seq; Type: SEQUENCE SET; Schema: drunker; Owner: postgres
--

SELECT pg_catalog.setval('drunker.notification_id_seq', 1, false);


--
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: drunker; Owner: postgres
--

SELECT pg_catalog.setval('drunker.role_id_seq', 2, true);


--
-- Name: sort_of_tea_id_seq; Type: SEQUENCE SET; Schema: drunker; Owner: postgres
--

SELECT pg_catalog.setval('drunker.sort_of_tea_id_seq', 1, false);


--
-- Name: tea_id_seq; Type: SEQUENCE SET; Schema: drunker; Owner: postgres
--

SELECT pg_catalog.setval('drunker.tea_id_seq', 1, false);


--
-- Name: basket_of_goods basket_of_goods_pk; Type: CONSTRAINT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.basket_of_goods
    ADD CONSTRAINT basket_of_goods_pk PRIMARY KEY (id);


--
-- Name: image image_pk; Type: CONSTRAINT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.image
    ADD CONSTRAINT image_pk PRIMARY KEY (id);


--
-- Name: kind_of_tea kind_of_tea_pk; Type: CONSTRAINT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.kind_of_tea
    ADD CONSTRAINT kind_of_tea_pk PRIMARY KEY (id);


--
-- Name: notification notification_pk; Type: CONSTRAINT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.notification
    ADD CONSTRAINT notification_pk PRIMARY KEY (id);


--
-- Name: role role_pk; Type: CONSTRAINT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.role
    ADD CONSTRAINT role_pk PRIMARY KEY (id);


--
-- Name: sort_of_tea sort_of_tea_pk; Type: CONSTRAINT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.sort_of_tea
    ADD CONSTRAINT sort_of_tea_pk PRIMARY KEY (id);


--
-- Name: tea tea_pk; Type: CONSTRAINT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.tea
    ADD CONSTRAINT tea_pk PRIMARY KEY (id);


--
-- Name: usr user_pk; Type: CONSTRAINT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.usr
    ADD CONSTRAINT user_pk PRIMARY KEY (id);


--
-- Name: basket_of_goods_id_uindex; Type: INDEX; Schema: drunker; Owner: postgres
--

CREATE UNIQUE INDEX basket_of_goods_id_uindex ON drunker.basket_of_goods USING btree (id);


--
-- Name: image_id_uindex; Type: INDEX; Schema: drunker; Owner: postgres
--

CREATE UNIQUE INDEX image_id_uindex ON drunker.image USING btree (id);


--
-- Name: kind_of_tea_id_uindex; Type: INDEX; Schema: drunker; Owner: postgres
--

CREATE UNIQUE INDEX kind_of_tea_id_uindex ON drunker.kind_of_tea USING btree (id);


--
-- Name: notification_id_uindex; Type: INDEX; Schema: drunker; Owner: postgres
--

CREATE UNIQUE INDEX notification_id_uindex ON drunker.notification USING btree (id);


--
-- Name: role_id_uindex; Type: INDEX; Schema: drunker; Owner: postgres
--

CREATE UNIQUE INDEX role_id_uindex ON drunker.role USING btree (id);


--
-- Name: sort_of_tea_id_uindex; Type: INDEX; Schema: drunker; Owner: postgres
--

CREATE UNIQUE INDEX sort_of_tea_id_uindex ON drunker.sort_of_tea USING btree (id);


--
-- Name: tea_id_uindex; Type: INDEX; Schema: drunker; Owner: postgres
--

CREATE UNIQUE INDEX tea_id_uindex ON drunker.tea USING btree (id);


--
-- Name: basket_of_goods basket_of_goods_tea_id_fk; Type: FK CONSTRAINT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.basket_of_goods
    ADD CONSTRAINT basket_of_goods_tea_id_fk FOREIGN KEY (tea_id) REFERENCES drunker.tea(id);


--
-- Name: basket_of_goods basket_of_goods_usr_id_fk; Type: FK CONSTRAINT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.basket_of_goods
    ADD CONSTRAINT basket_of_goods_usr_id_fk FOREIGN KEY (user_id) REFERENCES drunker.usr(id);


--
-- Name: notification notification_tea_id_fk; Type: FK CONSTRAINT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.notification
    ADD CONSTRAINT notification_tea_id_fk FOREIGN KEY (tea_id) REFERENCES drunker.tea(id);


--
-- Name: notification notification_usr_id_fk; Type: FK CONSTRAINT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.notification
    ADD CONSTRAINT notification_usr_id_fk FOREIGN KEY (user_id) REFERENCES drunker.usr(id);


--
-- Name: tea tea_kind_of_tea_id_fk; Type: FK CONSTRAINT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.tea
    ADD CONSTRAINT tea_kind_of_tea_id_fk FOREIGN KEY (kind_id) REFERENCES drunker.kind_of_tea(id);


--
-- Name: tea tea_sort_of_tea_id_fk; Type: FK CONSTRAINT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.tea
    ADD CONSTRAINT tea_sort_of_tea_id_fk FOREIGN KEY (sort_tea_id) REFERENCES drunker.sort_of_tea(id);


--
-- Name: usr usr_role_id_fk; Type: FK CONSTRAINT; Schema: drunker; Owner: postgres
--

ALTER TABLE ONLY drunker.usr
    ADD CONSTRAINT usr_role_id_fk FOREIGN KEY (role_id) REFERENCES drunker.role(id);


--
-- PostgreSQL database dump complete
--


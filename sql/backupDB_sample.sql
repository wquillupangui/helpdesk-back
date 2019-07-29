PGDMP     +    9                w            edimca    11.4    11.4                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                        0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            !           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            "           1262    16393    edimca    DATABASE     �   CREATE DATABASE edimca WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Ecuador.1252' LC_CTYPE = 'Spanish_Ecuador.1252';
    DROP DATABASE edimca;
             postgres    false                        2615    16394 	   help_desk    SCHEMA        CREATE SCHEMA help_desk;
    DROP SCHEMA help_desk;
             postgres    false            �            1259    16432 	   operation    TABLE     �   CREATE TABLE help_desk.operation (
    id integer NOT NULL,
    mark text,
    date_m timestamp(4) without time zone,
    fk_user_id integer,
    fk_request_id integer,
    state smallint
);
     DROP TABLE help_desk.operation;
    	   help_desk         postgres    false    6            �            1259    16403    request    TABLE     t   CREATE TABLE help_desk.request (
    id integer NOT NULL,
    name text,
    description text,
    priority text
);
    DROP TABLE help_desk.request;
    	   help_desk         postgres    false    6            �            1259    16395    user    TABLE     l   CREATE TABLE help_desk."user" (
    id integer NOT NULL,
    name text,
    password text,
    role text
);
    DROP TABLE help_desk."user";
    	   help_desk         postgres    false    6            �            1259    16463    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public       postgres    false            �            1259    16450 	   operation    TABLE     �   CREATE TABLE public.operation (
    id integer NOT NULL,
    date_m timestamp without time zone,
    mark character varying(255)
);
    DROP TABLE public.operation;
       public         postgres    false            �            1259    16455    request    TABLE     �   CREATE TABLE public.request (
    id integer NOT NULL,
    description character varying(255),
    name character varying(255),
    priority character varying(255)
);
    DROP TABLE public.request;
       public         postgres    false                      0    16432 	   operation 
   TABLE DATA               Z   COPY help_desk.operation (id, mark, date_m, fk_user_id, fk_request_id, state) FROM stdin;
 	   help_desk       postgres    false    199   �                 0    16403    request 
   TABLE DATA               E   COPY help_desk.request (id, name, description, priority) FROM stdin;
 	   help_desk       postgres    false    198   �                 0    16395    user 
   TABLE DATA               =   COPY help_desk."user" (id, name, password, role) FROM stdin;
 	   help_desk       postgres    false    197   �                 0    16450 	   operation 
   TABLE DATA               5   COPY public.operation (id, date_m, mark) FROM stdin;
    public       postgres    false    200   )                 0    16455    request 
   TABLE DATA               B   COPY public.request (id, description, name, priority) FROM stdin;
    public       postgres    false    201   F       #           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 26, true);
            public       postgres    false    202            �
           2606    16439    operation operation_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY help_desk.operation
    ADD CONSTRAINT operation_pkey PRIMARY KEY (id);
 E   ALTER TABLE ONLY help_desk.operation DROP CONSTRAINT operation_pkey;
    	   help_desk         postgres    false    199            �
           2606    16410    request request_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY help_desk.request
    ADD CONSTRAINT request_pkey PRIMARY KEY (id);
 A   ALTER TABLE ONLY help_desk.request DROP CONSTRAINT request_pkey;
    	   help_desk         postgres    false    198            �
           2606    16402    user user_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY help_desk."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);
 =   ALTER TABLE ONLY help_desk."user" DROP CONSTRAINT user_pkey;
    	   help_desk         postgres    false    197            �
           2606    16454    operation operation_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.operation
    ADD CONSTRAINT operation_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.operation DROP CONSTRAINT operation_pkey;
       public         postgres    false    200            �
           2606    16462    request request_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.request
    ADD CONSTRAINT request_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.request DROP CONSTRAINT request_pkey;
       public         postgres    false    201            �
           2606    16445 &   operation operation_fk_request_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY help_desk.operation
    ADD CONSTRAINT operation_fk_request_id_fkey FOREIGN KEY (fk_request_id) REFERENCES help_desk.request(id);
 S   ALTER TABLE ONLY help_desk.operation DROP CONSTRAINT operation_fk_request_id_fkey;
    	   help_desk       postgres    false    2709    199    198            �
           2606    16440 #   operation operation_fk_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY help_desk.operation
    ADD CONSTRAINT operation_fk_user_id_fkey FOREIGN KEY (fk_user_id) REFERENCES help_desk."user"(id);
 P   ALTER TABLE ONLY help_desk.operation DROP CONSTRAINT operation_fk_user_id_fkey;
    	   help_desk       postgres    false    199    2707    197               �   x���1� @�N��b`�z����,i�J=�,I$$�'�o��a^&C���(� ���lІ��lj�7L��������î�P����R��[*�"����k��UE%���)�$�W��C�L��T�T~>���P�E9J���˞POK�>4%�C�~ӛ`%���V��[F_ϐ��@t,gJ�>�����           x���N�0���S�;�hG7v� B8r��YJ��N��q������_�5oR��5��c׼��v�&�%)�,z�ӹV��$Y��}�N��~-���(��P�pE�2��*�]�n�����W��U�`M�&�e}P΀�[cP3�"��+�N@�����l��{)%�2�X#�TcpH�t)h#HIL�Ka]2f�����$j"ak�@(�U0)�#�-T|B��Rn�'	���,%v�1�T�h����p�׻�����شm���         M   x�3�t���tu�񃳹�9CR�3�2�3��Ar!��\&(�FpqSqc��!������kH�T������ α6            x������ � �            x������ � �     
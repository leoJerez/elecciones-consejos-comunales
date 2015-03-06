/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     05-03-2015 02:11:30 a.m.                     */
/*==============================================================*/

/*==============================================================*/
/* Table: candidato                                             */
/*==============================================================*/
create table candidato (
   id_candidato         serial               not null,
   id_cargo             int4                 null,
   id_vecino            int4                 null,
   id__eleccion         int4                 null,
   estado               char(1)              null,
   cantidad_votos       int            null,
   status               char(1)              null,
   constraint pk_candidato primary key (id_candidato)
);

/*==============================================================*/
/* Table: cargo                                                 */
/*==============================================================*/
create table cargo (
   id_cargo             serial               not null,
   id_consejo_comunal   int4                 null,
   nombre               varchar(120)         not null,
   descripcion          varchar(255)         null,
   duracion_periodo     float              null,
   minimo_edad_postulante int                null,
   status               char(1)              null,
   constraint pk_cargo primary key (id_cargo)
);

/*==============================================================*/
/* Table: cargo_evento_electoral                                */
/*==============================================================*/
create table cargo_evento_electoral (
   id_cargo_evento      serial               not null,
   nombre               varchar(255)         null,
   descripcion          varchar(500)         null,
   status               char(1)              null,
   constraint pk_cargo_evento_electoral primary key (id_cargo_evento)
);

/*==============================================================*/
/* Table: cartelera_informativa                                 */
/*==============================================================*/
create table cartelera_informativa (
   id_noticia           serial               not null,
   id_consejo_comunal   int4                 null,
   titulo               varchar(255)         null,
   contenido            varchar(500)         null,
   fecha_publicacion    date                 null,
   autor                varchar(255)         null,
   url_imagen           varchar(255)         null,
   imagen               bytea             null,
   status               char(1)              null,
   constraint pk_cartelera_informativa primary key (id_noticia)
);

/*==============================================================*/
/* Table: consejo_comunal                                       */
/*==============================================================*/
create table consejo_comunal (
   id_consejo_comunal   serial               not null,
   id_parroquia         int4                 null,
   id_usuario           int4                 null,
   nombre               varchar(255)         not null,
   fecha_creacion       date                 null,
   codigo_registro_fundacomunal varchar(100)         null,
   rif                  varchar(20)          null,
   sector               varchar(150)         null,
   mision               varchar(500)         null,
   vision               varchar(500)         null,
   telefono             varchar(14)          null,
   celular              varchar(14)          null,
   correo               varchar(255)         null,
   lindero_norte        varchar(255)         null,
   lindero_sur          varchar(255)         null,
   lindero_este         varchar(255)         null,
   lindero_oeste        varchar(255)         null,
   href_twitter         varchar(255)         null,
   data_widget_id       varchar(255)         null,
   status               char(1)              null,
   constraint pk_consejo_comunal primary key (id_consejo_comunal)
);

/*==============================================================*/
/* Table: eleccion                                              */
/*==============================================================*/
create table eleccion (
   id__eleccion         serial               not null,
   fecha_evento         date                 not null,
   hora_inicio          time                 null,
   hora_cierre          time                 null,
   status               char(1)              null,
   constraint pk_eleccion primary key (id__eleccion)
);

/*==============================================================*/
/* Table: estado                                                */
/*==============================================================*/
create table estado (
   id_estado            serial               not null,
   nombre               varchar(60)          not null,
   status               char(1)              null,
   constraint pk_estado primary key (id_estado)
);

/*==============================================================*/
/* Table: mesa_electoral                                        */
/*==============================================================*/
create table mesa_electoral (
   id_mesa              serial               not null,
   id__eleccion         int4                 null,
   numero_mesa          varchar(5)           null,
   mac_pc               varchar(23)          null,
   votos_nulos          int              null,
   observaciones        varchar(255)         null,
   status               char(1)              null,
   constraint pk_mesa_electoral primary key (id_mesa)
);

/*==============================================================*/
/* Table: miembros_consejo                                      */
/*==============================================================*/
create table miembros_consejo (
   id_miembro           serial               not null,
   id_cargo             int4                 null,
   id_vecino            int4                 null,
   id__eleccion         int4                 null,
   observaciones        varchar(500)         null,
   estado               char(1)              null,
   status               char(1)              null,
   constraint pk_miembros_consejo primary key (id_miembro)
);

/*==============================================================*/
/* Table: miembros_mesa                                         */
/*==============================================================*/
create table miembros_mesa (
   id_miembro           serial               not null,
   id_vecino            int4                 null,
   id_cargo_evento      int4                 null,
   id_mesa              int4                 null,
   status               char(1)              null,
   constraint pk_miembros_mesa primary key (id_miembro)
);

/*==============================================================*/
/* Table: municipio                                             */
/*==============================================================*/
create table municipio (
   id_municipio         serial               not null,
   id_estado            int4                 null,
   nombre               varchar(60)          not null,
   status               char(1)              null,
   constraint pk_municipio primary key (id_municipio)
);

/*==============================================================*/
/* Table: parroquia                                             */
/*==============================================================*/
create table parroquia (
   id_parroquia         serial               not null,
   id_municipio         int4                 null,
   nombre               varchar(60)          not null,
   status               char(1)              null,
   constraint pk_parroquia primary key (id_parroquia)
);

/*==============================================================*/
/* Table: rol                                                   */
/*==============================================================*/
create table rol (
   id_rol               serial               not null,
   nombre               varchar(60)          not null,
   descripcion          varchar(255)         null,
   status               char(1)              null,
   constraint pk_rol primary key (id_rol)
);

/*==============================================================*/
/* Table: usuario                                               */
/*==============================================================*/
create table usuario (
   id_usuario           serial               not null,
   id_rol               int4                 null,
   login                varchar(20)          not null,
   password             varchar(15)          not null,
   status               char(1)              null,
   constraint pk_usuario primary key (id_usuario)
);

/*==============================================================*/
/* Table: vecino                                                */
/*==============================================================*/
create table vecino (
   id_vecino            serial               not null,
   id_usuario           int4                 null,
   cedula               varchar(12)          not null,
   nombre               varchar(120)         not null,
   apellido             varchar(120)         not null,
   sexo                 char(1)              null,
   fecha_nacimiento     date                 not null,
   estado_civil         char(1)              null,
   profesion_ocupacion  varchar(255)         null,
   telefono             varchar(14)          null,
   celular              varchar(14)          null,
   correo               varchar(100)         null,
   fecha_ingreso_comunidad date                 null,
   url_foto             varchar(500)         null,
   imagen               bytea             null,
   status               char(1)              null,
   constraint pk_vecino primary key (id_vecino)
);

/*==============================================================*/
/* Table: vecino_vivienda                                       */
/*==============================================================*/
create table vecino_vivienda (
   id_vecino_vivienda   serial               not null,
   id_vecino            int4                 null,
   id_vivienda          int4                 null,
   status               char(1)              null,
   constraint pk_vecino_vivienda primary key (id_vecino_vivienda)
);

/*==============================================================*/
/* Table: vehiculo                                              */
/*==============================================================*/
create table vehiculo (
   id_vehiculo          serial               not null,
   placa                varchar(10)          null,
   modelo               varchar(200)         null,
   marca                varchar(200)         null,
   anno                 varchar(5)           null,
   status               char(1)              null,
   constraint pk_vehiculo primary key (id_vehiculo)
);

/*==============================================================*/
/* Table: vehiculo_vivienda                                     */
/*==============================================================*/
create table vehiculo_vivienda (
   id_vehiculo_vivienda serial               not null,
   id_vivienda          int4                 null,
   id_vehiculo          int4                 null,
   status               char(1)              null,
   constraint pk_vehiculo_vivienda primary key (id_vehiculo_vivienda)
);

/*==============================================================*/
/* Table: vivienda                                              */
/*==============================================================*/
create table vivienda (
   id_vivienda          serial               not null,
   id_consejo_comunal   int4                 null,
   numero_casa          varchar(10)          null,
   manzana              varchar(60)          null,
   calle                varchar(60)          null,
   carrera              varchar(60)          null,
   nombre_casa          varchar(60)          null,
   codigo_poste_cercano varchar(60)          null,
   cantidad_habitaciones varchar(10)          null,
   cantidad_bannos      varchar(10)          null,
   status               char(1)              null,
   constraint pk_vivienda primary key (id_vivienda)
);

/*==============================================================*/
/* Table: voto_candidato_mesa                                   */
/*==============================================================*/
create table voto_candidato_mesa (
   id_voto_candidato_mesa serial               not null,
   id_mesa              int4                 null,
   id_candidato         int4                 null,
   cantidad_votos       int             null,
   status               char(1)              null,
   constraint pk_voto_candidato_mesa primary key (id_voto_candidato_mesa)
);

alter table candidato
   add constraint fk_candidat_reference_cargo foreign key (id_cargo)
      references cargo (id_cargo)
      on delete restrict on update restrict;

alter table candidato
   add constraint fk_candidat_reference_vecino foreign key (id_vecino)
      references vecino (id_vecino)
      on delete restrict on update restrict;

alter table candidato
   add constraint fk_candidat_reference_eleccion foreign key (id__eleccion)
      references eleccion (id__eleccion)
      on delete restrict on update restrict;

alter table cargo
   add constraint fk_cargo_reference_consejo_ foreign key (id_consejo_comunal)
      references consejo_comunal (id_consejo_comunal)
      on delete restrict on update restrict;

alter table cartelera_informativa
   add constraint fk_carteler_reference_consejo_ foreign key (id_consejo_comunal)
      references consejo_comunal (id_consejo_comunal)
      on delete restrict on update restrict;

alter table consejo_comunal
   add constraint fk_consejo__reference_usuario foreign key (id_usuario)
      references usuario (id_usuario)
      on delete restrict on update restrict;

alter table consejo_comunal
   add constraint fk_consejo__reference_parroqui foreign key (id_parroquia)
      references parroquia (id_parroquia)
      on delete restrict on update restrict;

alter table mesa_electoral
   add constraint fk_mesa_ele_reference_eleccion foreign key (id__eleccion)
      references eleccion (id__eleccion)
      on delete restrict on update restrict;

alter table miembros_consejo
   add constraint fk_miembros_reference_eleccion foreign key (id__eleccion)
      references eleccion (id__eleccion)
      on delete restrict on update restrict;

alter table miembros_consejo
   add constraint fk_miembros_reference_cargo foreign key (id_cargo)
      references cargo (id_cargo)
      on delete restrict on update restrict;

alter table miembros_consejo
   add constraint fk_miembros_reference_vecino foreign key (id_vecino)
      references vecino (id_vecino)
      on delete restrict on update restrict;

alter table miembros_mesa
   add constraint fk_miembros_reference_vecino foreign key (id_vecino)
      references vecino (id_vecino)
      on delete restrict on update restrict;

alter table miembros_mesa
   add constraint fk_miembros_reference_cargo_ev foreign key (id_cargo_evento)
      references cargo_evento_electoral (id_cargo_evento)
      on delete restrict on update restrict;

alter table miembros_mesa
   add constraint fk_miembros_reference_mesa_ele foreign key (id_mesa)
      references mesa_electoral (id_mesa)
      on delete restrict on update restrict;

alter table municipio
   add constraint fk_municipi_reference_estado foreign key (id_estado)
      references estado (id_estado)
      on delete restrict on update restrict;

alter table parroquia
   add constraint fk_parroqui_reference_municipi foreign key (id_municipio)
      references municipio (id_municipio)
      on delete restrict on update restrict;

alter table usuario
   add constraint fk_usuario_reference_rol foreign key (id_rol)
      references rol (id_rol)
      on delete restrict on update restrict;

alter table vecino
   add constraint fk_vecino_reference_usuario foreign key (id_usuario)
      references usuario (id_usuario)
      on delete restrict on update restrict;

alter table vecino_vivienda
   add constraint fk_vecino_v_reference_vivienda foreign key (id_vivienda)
      references vivienda (id_vivienda)
      on delete restrict on update restrict;

alter table vecino_vivienda
   add constraint fk_vecino_v_reference_vecino foreign key (id_vecino)
      references vecino (id_vecino)
      on delete restrict on update restrict;

alter table vehiculo_vivienda
   add constraint fk_vehiculo_reference_vivienda foreign key (id_vivienda)
      references vivienda (id_vivienda)
      on delete restrict on update restrict;

alter table vehiculo_vivienda
   add constraint fk_vehiculo_reference_vehiculo foreign key (id_vehiculo)
      references vehiculo (id_vehiculo)
      on delete restrict on update restrict;

alter table vivienda
   add constraint fk_vivienda_reference_consejo_ foreign key (id_consejo_comunal)
      references consejo_comunal (id_consejo_comunal)
      on delete restrict on update restrict;

alter table voto_candidato_mesa
   add constraint fk_voto_can_reference_mesa_ele foreign key (id_mesa)
      references mesa_electoral (id_mesa)
      on delete restrict on update restrict;

alter table voto_candidato_mesa
   add constraint fk_voto_can_reference_candidat foreign key (id_candidato)
      references candidato (id_candidato)
      on delete restrict on update restrict;


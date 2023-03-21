create table usuarios(

                        id smallint not null identity (1,1),
                        login varchar(100) not null,
                        senha varchar(260) not null,

                        constraint PK_chaveid primary key(id),
                        CONSTRAINT UQ_login UNIQUE(login)
)
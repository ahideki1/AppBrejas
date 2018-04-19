/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  alexandre.yoshimura
 * Created: 19/04/2018
 */

create table tb_usuario
(
    id_user int PRIMARY key AUTO_INCREMENT,
    username varchar(200),
    email varchar(200),
    senha varchar(200)
);

insert into tb_usuario(id_user,username,email,senha)
values('','japa','alexandre.yoshi1@gmail.com','1');
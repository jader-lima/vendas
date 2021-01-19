package br.com.vendas.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.vendas.model.Pedido;
import br.com.vendas.model.StatusPedido;

/*
 * Repository é um Design Pattern onde os dados são obtidos do banco de dados e 
 * ocorre também a regra de negócio. Este retorna objetos de domínio que seriam 
 * as Entidades (classes anotadas com @Entity).

DAO é outro Design Pattern onde somente há a comunicação com o banco de 
dados sem regra de negócio.

Service seria outro Desing Pattern onde há somente a regra de negócio 
e não tem acesso direto ao banco de dados.

Controller Ele é utilizado para lidar com a ligação da View com as 
outras partes do sistema que são a regra de negócio e banco de dados.
 * 
 * */


@Repository 
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(StatusPedido status);
	
	//Classe JpaRepository recebe a classe que vai lidar(Pedido) 
	//e o tipo do id da classe(tipo id é long)		
	

	
	

}

package br.com.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;


public class CadastroDeProduto {

	public static void main(String[] args) {
		Categoria categoria = new Categoria("CELULARES");
		// TODO Auto-generated method stub
		Produto notebook = new Produto("Notebook Dell", "Quero demais", new BigDecimal("2500"), categoria  );
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja"); 
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(categoria);
		em.persist(notebook);
		em.getTransaction().commit();
		em.close();
		
		EntityManager emSelect =factory.createEntityManager();
		Query query = emSelect.createQuery("SELECT p FROM Produto p");
		List<Produto> result = query.getResultList();
		System.out.println(result.get(0).getNome());
		
		
		
		

	}

}

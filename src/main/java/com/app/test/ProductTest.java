package com.app.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;
import com.app.repo.ProductRepository.MyView;
import com.app.repo.ProductRepository.MyViewTwo;

@Component
public class ProductTest implements CommandLineRunner {
	@Autowired
	private ProductRepository repo;

	@Override
	public void run(String... args) throws Exception {
		repo.saveAll(Arrays.asList(new Product("A", 1.1), new Product("A", 2.1), new Product("C", 3.1),
				new Product("D", 4.1), new Product("E", 5.1), new Product("F", 5.1), new Product("G", 7.1),
				new Product("H", 8.1), new Product("I", 5.1), new Product("A", 10.1), new Product("K", 11.1)));
		List<Product> findAll = repo.findAll();
		System.out.println(findAll);
		// repo.findByProdId(1).forEach(System.out::println);
		repo.findByProdCode("A").forEach(System.out::println);
		repo.findByProdCost(5.1).forEach(System.out::println);
		repo.findByProdCostGreaterThan(2.1).forEach(System.out::println);
		repo.findByProdCostLessThan(2.1).forEach(System.out::println);
		repo.findByProdCodeAndProdCost("A", 1.1).forEach(System.out::println);
		repo.findByProdCodeOrProdCost("A", 5.1).forEach(System.out::println);
		repo.findByProdIdIn(Arrays.asList(1, 5, 8, 9)).forEach(System.out::println);
		repo.findByProdIdNotIn(Arrays.asList(1, 5, 8, 9)).forEach(System.out::println);
		
		
		//static Projection
		List<MyView> findByProdId = repo.findByProdId(1);
		for (MyView myView : findByProdId) {
			System.out.println(myView.getProdCost()+" "+myView.getProdCode());
		}
		
		System.out.println("******************************");
		//dynamic Projection
		List<MyViewTwo> data = repo.findByProdId(1, MyViewTwo.class);
		for (MyViewTwo myViewTwo : data) {
			System.out.println(myViewTwo.getProdCode() + "  " + myViewTwo.getProdCost());
		}
	}
}

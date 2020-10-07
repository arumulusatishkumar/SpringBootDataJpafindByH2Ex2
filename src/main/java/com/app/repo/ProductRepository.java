package com.app.repo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> 
{
	//public List<Product> findByProdId(Integer prodId);
	public List<Product> findByProdCode(String prodCode);
	public List<Product> findByProdCost(Double prodCost);
	public List<Product> findByProdCostGreaterThan(Double prodCost);
	public List<Product> findByProdCostLessThan(Double prodCost);
	public List<Product> findByProdCodeAndProdCost(String prodCode, Double productCost );
	public List<Product> findByProdCodeOrProdCost(String prodCode, Double productCost );
	public List<Product> findByProdIdIn(Collection<Integer> values);
	public List<Product> findByProdIdNotIn(Collection<Integer> values);
	
	//static projection
	public List<MyView> findByProdId(Integer prodId);
	interface MyView
	{
		String getProdCode();
		Double getProdCost();
	}
	
	//dynamic projection
	<T> List<T> findByProdId(Integer prodId,Class<T> clz);
	interface MyViewTwo
	{
		String getProdCode();
		Double getProdCost();
	}
	
}

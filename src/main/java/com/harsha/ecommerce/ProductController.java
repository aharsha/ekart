package com.harsha.ecommerce;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.harsha.ecommerce.dao.ProductDaoImpl;
import com.harsha.ecommerce.dao.UserDaoImpl;
import com.harsha.ecommerce.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	 UserDaoImpl userDaoimpl;
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	
	 public ProductController() {
		System.out.println("Product Controller is loading");
		
	}
	 
	 
		
		@RequestMapping("/hme")
		public String test()
		{
			System.out.println("at hi request");
			return "home";
		}
		@RequestMapping("/addproduct")
		public ModelAndView saveProduct()
		{
			ModelAndView  modelAndView=new ModelAndView("addproduct");
			modelAndView.addObject("pro",new Product());
			return modelAndView;
		}
		@PostMapping("/readProduct")
		public void readProductFormData(@ModelAttribute("pro")  Product  product)
		{
		System.out.println(product.getProductName());
		System.out.println(product.getProImage());
		
		// get image from product
		MultipartFile  productImage=product.getProImage();
		
		//cut image into byte array
		try {
			byte imgArr[]=productImage.getBytes();
			System.out.println("Image length = "+imgArr.length);
			//D:\pgp22\ecommerce\src\main\webapp\resources
			String path="D://pgp22/ecommerce/src/main/webapp/resources/"+product.getProductId()+".jpg";
			System.out.println(path);
			FileOutputStream  fos=new FileOutputStream(path);
			BufferedOutputStream  bufferedOutputStream=new BufferedOutputStream(fos);
			bufferedOutputStream.write(imgArr);
			bufferedOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		@RequestMapping("/displayproducts")
		public ModelAndView displayProducts()
		{
			
			userDaoimpl.testSessionFactory();
			System.out.println("at displayproducts request");
			//send data to view(jsp)
			//create ModelAndView object
			ModelAndView modelAndView=new ModelAndView("showproducts");
			//modelAndView.addObject("nm",120);
			
			
			//create products objects
			Product  p1=new Product();
			Product  p2=new Product();
			Product  p3=new Product();
			
			//intialise  product object
			p1.setProductId(101);
			p1.setProductName("dell");
			p1.setProductPrice(45000);
			
			p2.setProductId(102);
			p2.setProductName("lenovo");
			p2.setProductPrice(35000);
			
			
			
				p3.setProductId(103);
				p3.setProductName("hp");
				p3.setProductPrice(55000);
				//prepare list
				ArrayList al=new ArrayList();
				
				//add product project objects into list
				al.add(p1);
				al.add(p2);
				al.add(p3);
				
			//add list into ModelAndview
			modelAndView.addObject("proList",al);
				
			return modelAndView;
		}
		
		//@RequestMapping(value="/info",method=RequestMethod.GET)
		@GetMapping("/info")
		public ModelAndView goToSingleProduct(@RequestParam("pid") int proId)
		{
			System.out.println(proId);
			//based on proId get single Product from DataBase
			Product product=productDaoImpl.getProduct(proId);
			ModelAndView modelAndView=new ModelAndView("singleproduct");
			modelAndView.addObject("pro",product);
			return modelAndView;
		}
		
}

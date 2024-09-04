package ra.business.implement;

import ra.business.design.IProductService;
import ra.business.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static ArrayList<Product> products = new ArrayList<>();

    //Get arraylist products
    @Override
    public List<Product> getAll() {
        return products;
    }

    //add or update product
    @Override
    public void save(Product product) {
        Scanner sc = new Scanner(System.in);
        if(findById(product.getProductId()) == null){
            products.add(product);
        }else{
            product.saveData(sc);
            products.set(findIndexById(product.getProductId()),product);
            System.out.println("Update product success");
        }
    }

    //find product by id
    @Override
    public Product findById(String s) {
        for(Product product: products){
            if(product.getProductId().equals(s)){
                return product;
            }
        }
        return null;
    }

    //delete product by id
    @Override
    public void delete(String s) {
        if(findById(s) != null){
            products.remove(findById(s));
            System.out.println("Delete product success");
        }else{
            System.err.println("Not found product with id: "+s);
        }
    }

    //find index product by id
    public int findIndexById(String id){
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getProductId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
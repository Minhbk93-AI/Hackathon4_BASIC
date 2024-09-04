package ra.validate;

import ra.business.design.IGenericService;
import ra.business.entity.Catalog;
import ra.business.entity.Product;
import ra.business.implement.CatalogService;
import ra.business.implement.ProductService;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ProductValidate {
    private static IGenericService<Product,String> products = new ProductService();
    private static IGenericService<Catalog,Integer> categories = new CatalogService();

    //Validate Product Id
    public static String inputProductId(Scanner sc){
        String productIdRegex = "^P\\d{4}$";
        while (true){
            System.out.println("Enter Product Id");
            String productId = sc.nextLine();
            if(Pattern.matches(productIdRegex,productId)){
                boolean check = false;
                for(Product product: products.getAll()){
                    if(product.getProductId().equals(productId)){
                        check = true;
                        System.err.println("ProductId already exists");
                        break;
                    }
                }
                if(!check){
                    return productId;
                }
            }else{
                System.err.println("start with letter P and add 4 characters number");
            }
        }
    }

    //Validate Product Name
    public static String inputProductName(Scanner sc) {
        while (true){
            System.out.println("Enter Product Name");
            String productName = sc.nextLine();
            if(productName.trim().isEmpty()){
                System.err.println("Product name must be not null");
            }else{
                return productName;
            }
        }
    }

    //Validate Product Price
    public static double inputProductPrice(Scanner sc) {
        double productPrice;
        while (true){
            while (true) {
                try {
                    System.out.println("Enter product price");
                    productPrice = Double.parseDouble(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("You must enter a number, please try again");
                }
            }
            if(productPrice > 0){
                return productPrice;
            }else{
                System.err.println("Product price must greater than 0");
            }
        }
    }

    //Validate Product Descriptions
    public static String inputProductDescriptions(Scanner sc) {
        System.out.println("Enter product description");
        return sc.nextLine();
    }

    //Validate Catalog
    public static Catalog inputProductCatalog(Scanner sc) {
        System.out.println("List Category");
        for (Catalog catalog: categories.getAll()){
            System.out.println(catalog);
        }
        int categoryId;
        while (true){
            while (true) {
                try {
                    System.out.println("Enter the category id you want to add");
                    categoryId = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("You must enter a number, please try again");
                }
            }
            if(categories.findById(categoryId) != null){
                return categories.findById(categoryId);
            }else{
                System.err.println("Cant found category with Id: " + categoryId +", please try again");
            }
        }
    }

    //Validate Product Stock
    public static int inputProductStock(Scanner sc) {
        int categoryStock;
        while (true){
            while (true) {
                try {
                    System.out.println("Enter the category stock you want to add");
                    categoryStock = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("You must enter a number, please try again");
                }
            }
            if(categoryStock< 10){
                System.err.println("Category stock must greater than 10");
            }else{
                return categoryStock;
            }
        }
    }

    //Validate Product Status
    public static boolean inputProductStatus(Scanner sc) {
        while (true){
            System.out.println("Enter Product status ( true | false )");
            String productStatus = sc.nextLine().toLowerCase();
            if(productStatus.equals("false") || productStatus.equals("true")){
                return Boolean.parseBoolean(productStatus);
            }else{
                System.err.println("status must be true or false");
            }
        }
    }

}

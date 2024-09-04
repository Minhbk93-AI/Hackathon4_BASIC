package ra.validate;

import java.util.Scanner;

public class CatalogValidate {
    //Validate CatalogId
    public static int inputCatalogId(Scanner sc){
        while (true){
            try {
                System.out.println("Enter Catalog Id");
                return Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.err.println("You must enter a number, please try again");
            }
        }

    }

    //Validate CatalogName
    public static String inputCatalogName(Scanner sc) {
        while (true){
            System.out.println("Enter Catalog Name");
            String catalogName = sc.nextLine();
            if(catalogName.trim().isEmpty()){
                System.err.println("Product name cannot be null");
            }
            else{
                return catalogName;
            }
        }
    }

    //Validate CatalogDescriptions
    public static String inputCatalogDescriptions(Scanner sc) {
        while (true){
            System.out.println("Enter Catalog Descriptions");
            String catalogDescriptions = sc.nextLine();
            if(catalogDescriptions.trim().isEmpty()){
                System.err.println("Product descriptions cannot be null");
            }
            else{
                return catalogDescriptions;
            }
        }
    }
}

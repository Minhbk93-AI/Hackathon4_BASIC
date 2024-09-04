package ra.validate;

import java.util.Scanner;

public class CatalogValidate {
    //Validate CatalogId
    public static int inputCatalogId(Scanner sc){
        while (true){
            try {
                System.out.println("Nhập vào Catalog Id");
                return Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.err.println("Bạn phải nhập vào là số, vui lòng nhập lại");
            }
        }

    }

    //Validate CatalogName
    public static String inputCatalogName(Scanner sc) {
        while (true){
            System.out.println("Nhập vào Catalog Name");
            String catalogName = sc.nextLine();
            if(catalogName.trim().isEmpty()){
                System.err.println("Product name không thể trống");
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
                System.err.println("Product descriptions không để trống");
            }
            else{
                return catalogDescriptions;
            }
        }
    }
}

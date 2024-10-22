package main.java.week_23_CollectionReview_MVC_ThymeleafPart1.passByValue;

public class ImmutableTest {

    public static void main(String[] args) {
        String schoolName = "Cydeo";
        modifyName(schoolName);
        System.out.println("main method : "+ schoolName);
    }

    static void modifyName(String s){
        s = "Cydeo School";
    }

}

package main.java.week_18_generics_enum_lambda_lombok.lombok.basics_1.singular;

public class MainSingular {
    public static void main(String[] args) {


        Student_Singular build = Student_Singular.builder()
                .name("John")
                .surname("Singular")
                .email("emial@email.com")
                .course("Spring")
                .course("Java")    //singular method enables adding a single item to the collection.
                .build();
        build.setEmail("example@gmail.com");

        System.out.println(build);
    }
}

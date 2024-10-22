package main.java.week_18_generics_enum_lambda_lombok.lombok.constructorlevel_2;

public class MainConstructor {

    public static void main(String[] args) {

        Student build = Student.builder()
                .name("John")
                .surname("Doe")
                .email("email@email.com")
                .phoneNumber(123l)
                .build();

        System.out.println(build);
    }
}

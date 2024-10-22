package main.java.week_18_generics_enum_lambda_lombok.lombok.methodlevel_3;

import lombok.Builder;

public class ImmutableStudentBuilderClass {



    @Builder(builderMethodName = "myMethodlevelBuilder")
    public static ImmutableStudent newStudent(int id, String name) {
        return new ImmutableStudent(id, name);

    }
}

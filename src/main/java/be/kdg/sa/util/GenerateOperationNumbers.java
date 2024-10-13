package be.kdg.sa.util;

import java.util.UUID;

public class GenerateOperationNumbers {
    public static  String generateInspectionNumber(String vesselNumber) {
        return "IO-" + vesselNumber;
    }
}

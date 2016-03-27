package model;


public class ModelHelper {
    public static boolean validateInpuLink(String input) {
        boolean isNotNull = input != null;
        boolean youtube = input.contains("youbute") || input.contains("youtu");
        return false;
    }
}

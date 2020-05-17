package domain.enums;

public enum EnumSex
{
    MALE, FEMALE;

    public static EnumSex getSexForString(String sexString){
        switch (sexString){
            case "male":
                return MALE;
            case "female":
                return FEMALE;
            default:
                return null;
        }
    }
}

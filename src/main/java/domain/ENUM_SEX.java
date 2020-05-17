package domain;

public enum ENUM_SEX
{
    MALE, FEMALE;

    public static ENUM_SEX getSexForString(String sexString){
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

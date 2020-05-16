package domain;

public enum ENUM_SEX
{
    male, female;

    public static ENUM_SEX getSexForString(String sexString){
        switch (sexString){
            case "male":
                return male;
            case "female":
                return female;
            default:
                return null;
        }
    }
}

package domain;

public enum ENUM_GRADE
{
    JUNIOR, MIDDLE, SENIOR;

    public static ENUM_GRADE getEnumForString (String enumString){
        enumString = enumString.toLowerCase();
        switch (enumString) {
            case "junior":
                return  ENUM_GRADE.JUNIOR;
            case "middle":
                return  ENUM_GRADE.MIDDLE;
            case "senior":
                return ENUM_GRADE.SENIOR;
            default:
                return null;
        }
    }
}


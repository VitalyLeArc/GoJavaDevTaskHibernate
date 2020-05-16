package domain;

public enum ENUM_GRADE
{
    Junior, Middle,Senior;

    public static ENUM_GRADE getEnumForString (String enumString){
        enumString = enumString.toLowerCase();
        switch (enumString) {
            case "junior":
                return  ENUM_GRADE.Junior;
            case "middle":
                return  ENUM_GRADE.Middle;
            case "senior":
                return ENUM_GRADE.Senior;
            default:
                return null;
        }
    }
}


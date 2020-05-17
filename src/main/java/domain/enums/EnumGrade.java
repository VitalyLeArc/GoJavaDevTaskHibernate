package domain.enums;

public enum EnumGrade
{
    JUNIOR, MIDDLE, SENIOR;

    public static EnumGrade getEnumForString (String enumString){
        enumString = enumString.toLowerCase();
        switch (enumString) {
            case "junior":
                return  EnumGrade.JUNIOR;
            case "middle":
                return  EnumGrade.MIDDLE;
            case "senior":
                return EnumGrade.SENIOR;
            default:
                return null;
        }
    }
}


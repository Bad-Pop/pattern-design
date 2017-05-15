package fr.epsi.pattern.design.model.modelenum;

public enum TypeEnum {
    LUXE ("Luxe"),
    BEAUTE ("Beauté"),
    PRETAPORTER ("Prêt à porter"),
    ACCESSOIRE ("Accessoire"),
    NONE ("N/A");

    private String label;

    TypeEnum(String label){
        this.label = label;
    }

    public static TypeEnum newTypeEnum(String label) {
        for (TypeEnum typeEnum : TypeEnum.values()) {
            if (typeEnum.getLabel().equalsIgnoreCase(label)){
                return typeEnum;
            }
        }
        return TypeEnum.NONE;
    }

    public String getLabel() {
        return label;
    }
}

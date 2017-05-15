package fr.epsi.pattern.design.model.modelenum;

public enum SizeEnum {
    XS ("xs"),
    S ("s"),
    M ("m"),
    L ("l"),
    XL ("xl"),
    XXL ("xxl"),
    NONE ("N/A");

    private String label;

    SizeEnum(String label){
        this.label = label;
    }

    public static SizeEnum newSizeEnum(String size) {
        for (SizeEnum sizeEnum : SizeEnum.values()) {
            if (sizeEnum.getLabel().equals(size)) {
                return sizeEnum;
            }
        }
        return SizeEnum.NONE;
    }

    public String getLabel() {
        return label;
    }
}

package fr.epsi.pattern.design.model.modelenum;

public enum ColorEnum {

    ROUGE ("Rouge"),
    VERT ("Vert"),
    BLEU ("Bleu"),
    NOIR ("Noir"),
    BLANC ("Blanc"),
    ORANGE ("Orange"),
    NONE ("N/A");

    private String label;

    ColorEnum(String label) {
        this.label = label;
    }

    public static ColorEnum newColorEnum(String pLabel) {
        for (ColorEnum colorEnum : ColorEnum.values()) {
            if (colorEnum.getLabel().equals(pLabel)) {
                return colorEnum;
            }
        }
        return ColorEnum.NONE;
    }

    public String getLabel() {
        return label;
    }
}

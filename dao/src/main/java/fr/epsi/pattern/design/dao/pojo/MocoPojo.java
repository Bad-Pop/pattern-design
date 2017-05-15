package fr.epsi.pattern.design.dao.pojo;

import fr.epsi.pattern.design.model.modelenum.ColorEnum;

public class MocoPojo extends ProductPojo {

    private ColorEnum color;

    public MocoPojo(){}

    public MocoPojo(String label, String type, String color){
        super(label, type);
        this.color = ColorEnum.newColorEnum(color);
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }
}

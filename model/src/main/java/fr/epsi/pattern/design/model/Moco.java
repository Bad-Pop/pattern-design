package fr.epsi.pattern.design.model;

import fr.epsi.pattern.design.model.modelenum.ColorEnum;

public class Moco extends Product{

    private ColorEnum color;

    public Moco(){}

    public Moco(String label, String type, String color){
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

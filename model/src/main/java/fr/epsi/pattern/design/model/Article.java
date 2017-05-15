package fr.epsi.pattern.design.model;

import fr.epsi.pattern.design.model.modelenum.SizeEnum;

public class Article extends Moco{

    private SizeEnum size;

    public Article(){}

    public Article(String label, String type, String color, String size){
        super(label, type, color);
        this.size = SizeEnum.newSizeEnum(size);
    }

    public SizeEnum getSize() {
        return size;
    }

    public void setSize(SizeEnum size) {
        this.size = size;
    }
}

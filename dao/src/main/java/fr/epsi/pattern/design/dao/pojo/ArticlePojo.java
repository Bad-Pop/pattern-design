package fr.epsi.pattern.design.dao.pojo;

import fr.epsi.pattern.design.model.modelenum.SizeEnum;

public class ArticlePojo extends MocoPojo {

    private SizeEnum size;

    public ArticlePojo(){}

    public ArticlePojo(String label, String type, String color, String size){
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

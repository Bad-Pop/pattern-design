package fr.epsi.pattern.design.model;

import fr.epsi.pattern.design.model.modelenum.TypeEnum;

public class Product {

    private String label;
    private TypeEnum type;

    public Product(String label, String type) {
        this.label = label;
        this.type = TypeEnum.newTypeEnum(type);
    }

    public Product(){}

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }
}

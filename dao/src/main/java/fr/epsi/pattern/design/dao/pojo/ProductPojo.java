package fr.epsi.pattern.design.dao.pojo;

import fr.epsi.pattern.design.model.modelenum.TypeEnum;

public class ProductPojo {

    private String label;
    private TypeEnum type;

    public ProductPojo(String label, String type) {
        this.label = label;
        this.type = TypeEnum.newTypeEnum(type);
    }

    public ProductPojo(){}

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

package art.redoc.business.goods.enums;

import lombok.Getter;

public enum PetAttributeTypeEnum {
    HAIR(0, "头发") {
    },
    EAR(1, "耳朵") {
    },
    BODY(2, "身体花纹") {
    },
    BODYCOLOR(3, "身体底色") {
    },
    HEAD(4, "头部") {
    },
    NOSE(5, "鼻子") {
    },
    EYE(6, "眼睛") {
    },
    BELLY(7, "肚皮") {
    },
    RESERIVED1(8, "预留1") {
    },
    FANCY(9, "幻想") {
    },

    FOODIE(10, "吃货属性") {
    },
    COUNT(11, "吃货属性数量") {
    },
    SEX(12, "性别") {
    },
    RESERIVED2(13, "预留2") {
    },
    RESERIVED3(14, "预留3") {
    },
    RESERIVED4(15, "预留4") {
    },
    RESERIVED5(16, "预留5") {
    },
    RESERIVED6(17, "预留6") {
    },
    RESERIVED7(18, "预留7") {
    };

    @Getter
    private Integer index;
    @Getter
    private String name;


    private PetAttributeTypeEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public static PetAttributeTypeEnum getByIndex(Integer index) {
        for (final PetAttributeTypeEnum p : PetAttributeTypeEnum.values()) {
            if (index.equals(p.getIndex())) {
                return p;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }


}

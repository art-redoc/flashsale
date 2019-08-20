package art.redoc.business.goods.enums;

public enum TypeCatalogEnum {
    GENERAL("1", "通用"), GENE("2", "基因"), CONSTELLATION("3", "星座"), STATE("4", "状态");

    String value;
    String name;

    TypeCatalogEnum(final String value, final String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public static TypeCatalogEnum getTypeCatalogByCode(final String value) {
        for (final TypeCatalogEnum consType : TypeCatalogEnum.values()) {
            if (value.equals(consType.getValue())) {
                return consType;
            }
        }
        return null;
    }
}
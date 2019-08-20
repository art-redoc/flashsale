package art.redoc.business.goods.enums;

public enum SexEnum {
	MALE("2", "男"), FEMALE("1", "女"), OTHER("3", "其他");

	String value;
    String name;

    SexEnum(final String value, final String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public static SexEnum getSexByCode(final String value) {
        for (final SexEnum consType : SexEnum.values()) {
            if (value.equals(consType.getValue())) {
                return consType;
            }
        }
        return null;
    }
}
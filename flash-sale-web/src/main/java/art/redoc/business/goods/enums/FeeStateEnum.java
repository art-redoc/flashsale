package art.redoc.business.goods.enums;

public enum FeeStateEnum {
    AUDITING("1","审核中"),AUDIT_FAILED("2","审核失败"),TRANSFERRING("3","交易中"),TRANSFER_FAILED("4","交易失败"),TRANSFER_SUCCESSFUL("5","交易成功");
    String value;
    String name;

    FeeStateEnum(final String value, final String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public static FeeStateEnum getFeeStateByCode(final String value) {
        for (final FeeStateEnum consType : FeeStateEnum.values()) {
            if (value.equals(consType.getValue())) {
                return consType;
            }
        }
        return null;
    }
}

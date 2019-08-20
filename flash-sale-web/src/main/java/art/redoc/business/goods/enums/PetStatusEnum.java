package art.redoc.business.goods.enums;

public enum PetStatusEnum {
    NORMAL("1", "正常"), SIRING("2", "繁育"), SALEAUCTION("3", "兔市"),
    WITHDRAW("4", "提现"),
    SIRINGAUCTION("5", "挂出繁育市场"), COOLOFF("6", "生育后冷却"),
    NORMAL_SIRING("7", "正常提交到繁育待确认状态"),
    NORMAL_SALEAUCTION("8", "正常挂出兔市待确认状态"),
    NORMAL_WITHDRAW("9", "正常到提交待确认状态"),
    NORMAL_GIFT("10", "正常到赠与待确认状态"),
    NORMAL_SIRINGAUCTION("11", "正常到挂出繁育市场待确认状态"),
    SALEAUCTION_NORMAL("12", "有人购买从兔市到普通待确认状态"),
    SIRINGAUCTION_COOLOFF("13", "有人确认繁育从繁育市场到冷却待确认状态"),
    PET_STATUS_TVPET("14", "TV宝宝"),ADVENTURE("15", "探险"),GUARD("16", "守护");

	String value;
    String name;

    PetStatusEnum(final String value, final String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public static PetStatusEnum getPetStatusByCode(final String value) {
        for (final PetStatusEnum consType : PetStatusEnum.values()) {
            if (value.equals(consType.getValue())) {
                return consType;
            }
        }
        return null;
    }
}
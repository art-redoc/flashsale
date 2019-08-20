package art.redoc.business.goods.enums;

public enum PetLifeTypeEnum {

    BUY("1", "买"),
    SELL("2", "卖"),
    GIFT("3", "赠与"),
    WITHDRAW("4", "提取"),
    SALEAUCTION("5", "挂出出售"),
    SIRINGAUCTION("6", "挂出繁育市场"),
    NORMAL_SIRING("7", "正常提交到繁育待确认状态"),
    DRAWING("8", "提币"),
    CANCELSALEN("9", "取消挂单到兔市"),
    CANCELSIRINGAUCTION("10", "取消挂单到繁育市场"),
    SIRING("11", "主动繁育"),
    DESIRING("12", "被繁育"),
    BORN("13", "新生"),
    RECIEVE("14", "收到赠送"),
    DEPOSIT("15", "充币"),
    ADVENTURE("16", "探险"),
    GUARD("17", "守护"),
    ADVENTURE_CITY("18", "在城市探险"),
    ADVENTURE_MOUNTAIN("19", "在山峰探险"),
    ADVENTURE_DESERT("20", "在沙漠探险"),
    ADVENTURE_SWAMP("21", "在沼泽探险"),
    TREASURE_LOSS("22", "藏宝损失"),
    ADVERT_PROFIT("23", "广告收益"),
    COMMUNITY_PROFIT("24", "社区收益"),
    BUY_MALL("25", "商城中购买"),
    FINISH_ADVENTURE("26", "完成探险"),
    TV_DRAW("27", "TV领取"),
    DRAWING_FEE("29", "提币手续费"),
    GUARD_INCOME("30", "守护收益"),
    AIRDROP_BTC("31", "空投BTC"),
    AIRDROP_ETH("32", "空投ETH"),
    AIRDROP_TVOS("33", "空投TVOS"),
    AIRDROP_V钻("34", "空投V钻"),
    CANCEL_GUARD("35", "取消守护"),
    GUARD_LOSS("36", "守护支出"),
    TRANSFER_INCOME("37","转账收入"),
    TRANSFER_LOSS("38","转账支出")
    ;

    String value;
    String name;

    PetLifeTypeEnum(final String value, final String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public static PetLifeTypeEnum getPetLifeTypeByCode(final String value) {
        for (final PetLifeTypeEnum consType : PetLifeTypeEnum.values()) {
            if (value.equals(consType.getValue())) {
                return consType;
            }
        }
        return null;
    }

    public static PetLifeTypeEnum getAirdropByCoinType(CoinTypeEnum coinTypeEnum) {
        switch (coinTypeEnum) {
            case TVOS:
                return PetLifeTypeEnum.AIRDROP_TVOS;
            case V钻:
                return PetLifeTypeEnum.AIRDROP_V钻;
            case ETH:
                return PetLifeTypeEnum.AIRDROP_ETH;
            case BTC:
                return PetLifeTypeEnum.AIRDROP_BTC;
            default:
                return null;
        }
    }
}

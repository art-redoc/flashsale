package art.redoc.business.goods.enums;

import lombok.Getter;

public enum CoinTypeEnum {
    BTC("BTC", "比特币","TICKER_BTC", true, false),
    ETH("ETH", "以太坊","TICKER_ETH", true, false),
    TVOS("TVOS", "电视币","TICKER_TVOS", true, true),
    CNY("CNY","人民币","TICKER_CNY", false, false),
    V钻("VC","V钻","TICKER_VC", true, true);
    @Getter
    String value;
    @Getter
    String name;
    @Getter
    String redisCode;
    // 是否平台使用币种
    @Getter
    boolean used;
    // 是否ERC20币种
    @Getter
    boolean erc20;

    CoinTypeEnum(final String value, final String name, String redisCode, boolean used, boolean erc20) {
        this.value = value;
        this.name = name;
        this.redisCode = redisCode;
        this.used = used;
        this.erc20 = erc20;
    }

    public static CoinTypeEnum getByCode(final String value) {
        for (final CoinTypeEnum consType : CoinTypeEnum.values()) {
            if (value.equals(consType.getValue())) {
                return consType;
            }
        }
        return null;
    }
}

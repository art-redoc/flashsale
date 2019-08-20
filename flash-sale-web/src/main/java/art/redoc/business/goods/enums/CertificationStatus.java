package art.redoc.business.goods.enums;

public enum CertificationStatus {

    PENDING("0", "等待"), PROGRESS("1", "进行中"), SUCCEED("2", "认证成功"), FAILURE("3", "认证失败");

    String value;
    String name;

    CertificationStatus(final String value, final String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

}

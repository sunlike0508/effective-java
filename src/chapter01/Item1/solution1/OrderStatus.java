package chapter01.Item1.solution1;

public enum OrderStatus {
    PREPARING("준비중"), SHIPPED("배송중"), DELIVERING("배달중"), DELIVERED("배달완료");

    private String description;

    OrderStatus(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

}

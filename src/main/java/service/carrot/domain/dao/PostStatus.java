package service.carrot.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import service.carrot.domain.BaseEnumCode;

@AllArgsConstructor
@Getter
public enum PostStatus implements BaseEnumCode<Integer> {
    SALE("판매중", 1),
    Reservation("예약중", 2),
    DEAL_COMPETED("거래완료", 3);

    private final String status;
    private final int id;

    @Override
    public Integer getValue() {
        return this.id;
    }
}

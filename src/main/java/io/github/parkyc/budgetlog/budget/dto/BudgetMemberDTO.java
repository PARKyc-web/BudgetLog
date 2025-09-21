package io.github.parkyc.budgetlog.budget.dto;

import io.github.parkyc.budgetlog.common.enums.BudgetMemberRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetMemberDTO {
    /* 가계부 멤버를 담을 DTO,
    *
    *  # Why)
    *  1. Budget 컬럼이 왜 없는지?? >> 순환참조가 일어남 >> Budget 중 필요한 부분의 데이터만 담음
    *
    *  */

    private String budgetName;
    private String userId;
    private BudgetMemberRole role;
}

package io.github.parkyc.budgetlog.budget.dto;

import io.github.parkyc.budgetlog.budget.entity.BudgetMember;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetCreateDTO {
    /* 가계부 생성을 위한 정보를 받는 DTO */

    /* 가계부 명 */
    private String budgetName;

    /* 가계부에 대한 설명 */
    private String description;

    /* 가계부 멤버 목록 */
    private List<BudgetMember> budgetMembers;
}

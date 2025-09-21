package io.github.parkyc.budgetlog.budget.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDTO {
    /* 가계부 상세 정보를 확인하는 DTO */

    private Long budgetSeq;
    private String budgetName;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    private List<BudgetMemberDTO>  budgetMembers;
}

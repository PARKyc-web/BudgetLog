package io.github.parkyc.budgetlog.budget.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDataDTO {

    private Long budgetSeq;

    private String budgetName;

    private String userId;

    private String userName;

    private Long amount;

    private Long count;

    private Long total;

    /* 등록 및 수정일 */
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

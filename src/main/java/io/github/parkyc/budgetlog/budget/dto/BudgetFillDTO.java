package io.github.parkyc.budgetlog.budget.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BudgetFillDTO {

    /** 가계부 데이터 입력 DTO **/

    /* 대상 가계부 식별자 */
    private Long budgetSeq;

    /* 데이터 작성자(가계부 멤버) ID */
    private Long userId;

    /* 단가 */ // price 로 변경하자
    private Long amount;

    /* 수량 */
    private Long count;

    /**
     * amount * count 값 계산.
     * null 은 0 으로 간주한다.
     */
    public long calculateTotal() {
        long safeAmount = amount != null ? amount : 0L;
        long safeCount = count != null ? count : 0L;
        return safeAmount * safeCount;
    }
}

package io.github.parkyc.budgetlog.budget.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.github.parkyc.budgetlog.budget.entity.QBudget;
import io.github.parkyc.budgetlog.budget.entity.QBudgetMember;
import io.github.parkyc.budgetlog.user.entity.QUserBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BudgetMemberRepositoryImpl implements BudgetMemberQuery {

    private final JPAQueryFactory queryFactory;

    @Override
    public boolean existsBudgetMemberByUserId(Long budgetSeq, String userId) {
        QBudgetMember bm = QBudgetMember.budgetMember;
        QUserBase ub = QUserBase.userBase;
        QBudget b = QBudget.budget;

        Integer result = queryFactory.selectOne()
                .from(bm)
                .join(bm.member, ub)
                .join(bm.budget, b)
                .where(ub.userId.eq(userId))
                .where(b.budgetSeq.eq(budgetSeq))
                .fetchFirst();

        if(result == null) {
            return false;
        }

        return result != 0;
    }
}

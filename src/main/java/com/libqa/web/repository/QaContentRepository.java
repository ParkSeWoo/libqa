package com.libqa.web.repository;

import com.libqa.web.domain.QaContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by yong on 15. 2. 1..
 */
public interface QaContentRepository extends JpaRepository<QaContent, Integer> {
    QaContent findOneByQaIdAndIsDeleted(Integer qaId, boolean isDeleted);

    List<QaContent> findAllByQaIdInAndIsReplyedAndInsertDateBetweenAndIsDeleted(List<Integer> qaIds, boolean isReplyed, Date fromDate, Date today, boolean isDeleted);

    List<QaContent> findAllByQaIdInAndInsertDateBetweenAndIsDeleted(List<Integer> qaIds, Date fromDate, Date today, boolean isDeleted);
}

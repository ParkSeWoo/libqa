package com.libqa.web.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yong on 15. 2. 1..
 */
@Entity
@Data
public class QaRecommand {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer qaRecommandId;

    @Column(nullable = false)
    private Integer qaId;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false, length = 40)
    private String userNick;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isCommand;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date insertDate;
}

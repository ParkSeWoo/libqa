package com.libqa.web.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by songanji on 2015. 2. 8..
 */
@Entity
@Data
public class WikiReply{

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer replyId;

    private Integer wikiId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "Text", nullable = false)
    private String contents;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false, length = 40)
    private String userNick;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isDeleted;

    @Temporal(TemporalType.DATE)
    private Date insertDate;

    @Temporal(TemporalType.DATE)
    private Date updateDate;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "userId", referencedColumnName = "userId"),
            @JoinColumn(name = "replyId", referencedColumnName = "replyId")
    })
    private List<WikiLike> wikiLikes;

}

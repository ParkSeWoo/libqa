package com.libqa.web.domain;

/**
 * @Author : yion
 * @Date : 2015. 10. 11.
 * @Description :
 */

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

import javax.persistence.*;
import java.util.Date;


/**
 * @Author : yion
 * @Date : 2015. 9. 14.
 * @Description :
 */
@Data
@Entity
@Table(name = "persistent_login")
@Slf4j
@EqualsAndHashCode
public class PersistentLogin {

    @Id
    @Column(length = 64, nullable = false)
    private String series;

    @Column(length = 64, nullable = false)
    private String username;

    @Column(length = 64, nullable = false)
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date lastUsed;

    public PersistentLogin(PersistentRememberMeToken persistentRememberMeToken) {
        log.info("########## PersistentLogin : {}", persistentRememberMeToken.toString());
        this.username = persistentRememberMeToken.getUsername();
        this.series = persistentRememberMeToken.getSeries();
        this.lastUsed = persistentRememberMeToken.getDate();
        this.token = persistentRememberMeToken.getTokenValue();
    }
}
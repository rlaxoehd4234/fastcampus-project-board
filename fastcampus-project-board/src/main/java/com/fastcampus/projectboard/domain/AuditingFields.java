package com.fastcampus.projectboard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AuditingFields {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) // passing 에 대한 룰
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @CreatedBy
    @Column(nullable = false , updatable = false , length = 100)  // 업데이트를 불가능하게 만들어야 한다.
    private String createdBy;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) // passing 에 대한 룰
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt;
    @LastModifiedBy
    @Column(nullable = false)
    private String modifiedBy;
}

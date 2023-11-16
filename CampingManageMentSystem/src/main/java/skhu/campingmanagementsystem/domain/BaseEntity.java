package skhu.campingmanagementsystem.domain;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@NoArgsConstructor
@Getter
public class BaseEntity {


    @Column(name = "CREATE_AT", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createAt;

    @Column(name = "UPDATE_AT", nullable = false)
    @LastModifiedDate
    private LocalDateTime updateAt;
}

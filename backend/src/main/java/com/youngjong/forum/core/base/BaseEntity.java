package com.youngjong.forum.core.base;

import com.youngjong.forum.core.security.SecurityUtil;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public abstract class BaseEntity implements Serializable {
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;

    private String createBy;
    private String updateBy;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }


}

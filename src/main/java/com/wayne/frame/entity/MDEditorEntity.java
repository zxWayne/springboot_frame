package com.wayne.frame.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name="tb_markdown")
public class MDEditorEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    /**
     * 创建时间
     */
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="last_modify_time")
    private Date lastModifyTime;

    @Override
    public String toString() {
        return "Editor{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}

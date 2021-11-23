package com.coffee.Coffee.project;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name="File")
@Table(name="file")
public class File {

    @Id
    @SequenceGenerator(
            name = "file_sequence",
            sequenceName ="file_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "file_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;

    @Column(
            name = "file_name",
            nullable = false
    )
    private String fileName;

    @ManyToOne
    @JoinColumn(
            name = "project_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "project_file_fk"
            )
    )
    private Project project;

    public File(){
    }

    public File(String fileName, LocalDateTime createdAt){
        this.createdAt = createdAt;
    }

    public Long getId(){return id;}

    public LocalDateTime getCreatedAt(){return createdAt;}

    public Project getProject(){return project;}

    public String getFileName(){return fileName;}

    public void setId(Long id){this.id = id;}

    public void setCreatedAt(LocalDateTime createdAt){this.createdAt = createdAt;}

    public void setProject(Project project){this.project = project;}

    public void setFileName(String fileName){this.fileName = fileName;}

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", fileName='" + fileName + '\'' +
                ", project=" + project +
                '}';
    }
}

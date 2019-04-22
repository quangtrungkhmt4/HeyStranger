package com.trung.HeyStranger.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reports")
public class Report extends AbstractModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "report_type")
    private String report_type;

    @Column(name = "notes")
    private String notes;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private String created_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    @JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_id")
    @NotNull
    @JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
    private Participant participant;

}

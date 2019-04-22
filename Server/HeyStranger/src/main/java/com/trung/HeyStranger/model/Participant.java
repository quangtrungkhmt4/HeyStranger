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
@Table(name = "participants")
public class Participant extends AbstractModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "nick_name")
    private String nick_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conversation_id")
    @NotNull
    @JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
    private Conversation conversation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    @NotNull
    @JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
    private User user;
}

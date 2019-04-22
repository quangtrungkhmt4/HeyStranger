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
@Table(name = "messages")
public class Message extends AbstractModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "message_type")
    private String message_type;

    @Column(name = "message")
    private String message;

    @Column(name = "attachment_thumb_url")
    private String attachment_thumb_url;

    @Column(name = "attachment_url")
    private String attachment_url;

    @Column(name = "created_at")
    private String created;

    @Column(name = "guid")
    private String guid;

    @Column(name = "deleted_at")
    private String deleted_at;

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

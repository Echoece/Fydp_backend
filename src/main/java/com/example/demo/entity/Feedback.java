package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @SequenceGenerator(
		    name = "feedback_sequence",
		    sequenceName = "feedback_sequence",
		    allocationSize = 1
    )
    @GeneratedValue(
		    strategy = GenerationType.SEQUENCE,
		    generator = "feedback_sequence"
    )
    @Column(name = "id")
    private Long id;

    private String feedback;
    private String userName;
}

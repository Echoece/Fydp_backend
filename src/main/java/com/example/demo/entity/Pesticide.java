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
@Table(name = "p")
public class Pesticide {
    @Id
    @SequenceGenerator(
		    name = "p_sequence",
		    sequenceName = "p_sequence",
		    allocationSize = 1
    )
    @GeneratedValue(
		    strategy = GenerationType.SEQUENCE,
		    generator = "p_sequence"
    )
    @Column(name = "id")
    private Long id;
    @Column(name = "cropname")
    private String cropName;
    @Column(name = "problem_name")
    private String problemName;
    @Column(name = "recommended_pesticide_name")
    private String recommendedPesticideName;
    @Column(name = "recommended_amount")
    private String recommendedAmount;
    @Column(name = "time_to_apply")
    private String timeToApply;
}

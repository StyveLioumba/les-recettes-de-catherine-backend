package com.bdx.anais.ApplicationRecetteCuisine.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tab_step", schema = "recipe")
public class Step {

    @Id
    @Column(name = "step_id")
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    @JsonIgnore
    private Recipe recipe;

    @Column(name = "step_num")
    private Integer numStep;

    @Column(name = "step_description")
    private String description;
}

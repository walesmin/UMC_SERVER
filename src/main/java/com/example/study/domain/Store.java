package com.example.study.domain;


import com.example.study.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "map_id")
    private Maps map;

    private String name;
    private String address;
    private String description;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<MissionStore> missionStores = new ArrayList<>();
}

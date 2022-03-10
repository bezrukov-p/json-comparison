package com.company.difference.forui.artifacts.type1;

import com.company.difference.forui.artifacts.type1.mvn.MvnFieldsForUI;
import com.company.model.artifacts.Artifact;
import com.company.model.artifacts.Mvn;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class Artifact1TypeFieldsForUI {
    private List<MvnFieldsForUI> mvn;
    private String targetRepository;

    {
        mvn = new ArrayList<>();
    }

    public Artifact1TypeFieldsForUI(Artifact artifact) {
        Set<Mvn> mvns = artifact.getMvn();
        for(Mvn m : mvns) {
            mvn.add(new MvnFieldsForUI(m));
        }

        targetRepository = "\"target_repository\": \"" + artifact.getTargetRepository() + "\"";
    }
}

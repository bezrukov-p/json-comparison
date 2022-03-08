package com.company.forui.diffbetweenobjectsforui.uiforartifacts.type1;

import com.company.forui.diffbetweenobjectsforui.uiforartifacts.type1.mvn.MvnFieldsForUI;
import com.company.model.artifacts.Artifact;
import com.company.model.artifacts.Mvn;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class Artifact1TypeFieldsForUI {
    List<MvnFieldsForUI> mvn;
    String targetRepository;

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

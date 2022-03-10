package com.company.difference.forui.rpm;


import com.company.model.rpm.Rpm;
import com.company.model.services.Hashes;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class DiffBetweenRpmForUI {
    private Map<String, String> rpmLeft;
    private Map<String, String> rpmRight;
    private Map<String, String> rpmHashLeft;
    private Map<String, String> rpmHashRight;

    {
        rpmLeft = new LinkedHashMap<>();
        rpmRight = new LinkedHashMap<>();
        rpmHashLeft = new LinkedHashMap<>();
        rpmHashRight = new LinkedHashMap<>();
    }

    public DiffBetweenRpmForUI(Rpm rpm1, Rpm rpm2) {
        if (rpm1 == null) {
            rpm1 = new Rpm();
            rpm1.setHashes(new Hashes());
        }
        if (rpm2 == null) {
            rpm2 = new Rpm();
            rpm2.setHashes(new Hashes());
        }

        String urlColor1 = getResultOfComparingFieldForUI(rpm1.getUrl(), rpm2.getUrl(), true);
        String urlColor2 = getResultOfComparingFieldForUI(rpm1.getUrl(), rpm2.getUrl(), false);
        if (urlColor1 != null)
            rpmLeft.put("\"url\": " + "\"" + rpm1.getUrl() + "\"", urlColor1);
        if (urlColor2 != null)
            rpmRight.put("\"url\": " + "\"" + rpm2.getUrl() + "\"", urlColor2);

        String rpmRepNameColor1 = getResultOfComparingFieldForUI(
                rpm1.getRpmRepositoryName(), rpm2.getRpmRepositoryName(), true);
        String rpmRepNameColor2 = getResultOfComparingFieldForUI(
                rpm1.getRpmRepositoryName(), rpm2.getRpmRepositoryName(), false);
        if (rpmRepNameColor1 != null)
            rpmLeft.put("\"rpm_repository_name\": " + "\"" + rpm1.getRpmRepositoryName() + "\"", rpmRepNameColor1);
        if (rpmRepNameColor2 != null)
            rpmRight.put("\"rpm_repository_name\": " + "\"" + rpm2.getRpmRepositoryName() + "\"", rpmRepNameColor2);

        String shortNameColor1 = getResultOfComparingFieldForUI(
                rpm1.getServiceShortName(), rpm2.getServiceShortName(), true);
        String shortNameColor2 = getResultOfComparingFieldForUI(
                rpm1.getServiceShortName(), rpm2.getServiceShortName(), false);
        if (shortNameColor1 != null)
            rpmLeft.put("\"service-short-name\": " + "\"" + rpm1.getServiceShortName() + "\"", shortNameColor1);
        if (shortNameColor2 != null)
            rpmRight.put("\"service-short-name\": " + "\"" + rpm2.getServiceShortName() + "\"", shortNameColor2);

        String sha1Color1 = getResultOfComparingFieldForUI(
                rpm1.getHashes().getSha1(), rpm2.getHashes().getSha1(), true);
        String sha1Color2 = getResultOfComparingFieldForUI(
                rpm1.getHashes().getSha1(), rpm2.getHashes().getSha1(), false);
        if (sha1Color1 != null)
            rpmHashLeft.put("\"sha1\": " + "\"" + rpm1.getHashes().getSha1() + "\"", sha1Color1);
        if (sha1Color2 != null)
            rpmHashRight.put("\"sha1\": " + "\"" + rpm2.getHashes().getSha1() + "\"", sha1Color2);

        String sha256Color1 = getResultOfComparingFieldForUI(
                rpm1.getHashes().getSha256(), rpm2.getHashes().getSha256(), true);
        String sha256Color2 = getResultOfComparingFieldForUI(
                rpm1.getHashes().getSha256(), rpm2.getHashes().getSha256(), false);
        if (sha256Color1 != null)
            rpmHashLeft.put("\"sha256\": " + "\"" + rpm1.getHashes().getSha256() + "\"", sha256Color1);
        if (sha1Color2 != null)
            rpmHashRight.put("\"sha256\": " + "\"" + rpm2.getHashes().getSha256() + "\"", sha256Color2);
    }

    //сравнение поля для (первый, второй), возвращает цвет либо поля левого объекта, либо правого
    private String getResultOfComparingFieldForUI(Object o1, Object o2, Boolean isForLeft) {
        if(o1 == null && o2 == null)
            return null;
        if (o1 != null && o2 == null)
            return isForLeft ? "red" : null;
        if (o1 == null && o2 != null)
            return isForLeft ? null : "green";
        if (o1.equals(o2))
            return "white";
        else
            return "orange";
    }
}

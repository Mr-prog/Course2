package app;

import data.HitCheckData;
import data.HitCheckServiceBean;
import data.AreaDotData;
import script.HitCheckScriptBean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;

import jakarta.inject.Named;
import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ejb.EJB;
import jakarta.annotation.PostConstruct;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor

@Named
@ApplicationScoped
public class MainPageBean implements Serializable {

    @EJB
    @Getter(value=AccessLevel.NONE)
    @Setter(value=AccessLevel.NONE)
    HitCheckServiceBean hitCheckService;

    @Inject
    @Getter(value=AccessLevel.NONE)
    @Setter(value=AccessLevel.NONE)
    HitCheckScriptBean hitCheckScript;

    private List<HitCheckData> resultsList;

    private float r;
    private float x;
    private float y;


    @PostConstruct
    public void init() {
        updateResultsList();
    }

    public void checkHit() {
        AreaDotData areaDotData = new AreaDotData(r, x, y);
        HitCheckData hitCheckData = hitCheckScript.execute(areaDotData);
        hitCheckService.add(hitCheckData);
        updateResultsList();
    }

    public void cleanResults() {
        hitCheckService.clean();
        updateResultsList();
    }

    public void updateResultsList() {
        resultsList = hitCheckService.getAll();
        Collections.reverse(resultsList);
    }


    public void setX(float x) {
        this.x = fixNegativeZero(x);
    }

    public void setY(float y) {
        this.y = fixNegativeZero(y);
    }

    private float fixNegativeZero(float value) {
        return (value == 0) ? 0 : value;
    }
}
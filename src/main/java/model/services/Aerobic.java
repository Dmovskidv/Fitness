package model.services;

import Interface.Sport;

public class Aerobic implements Sport {

    private String nameService;
    private String timeService;
    private String costService;

    public Aerobic (String nameService, String timeService, String costService) {
        this.nameService = nameService;
        this.timeService = timeService;
        this.costService = costService;
    }

    @Override
    public String getName() {
        return nameService;
    }

    @Override
    public String getTime() {
        return timeService;
    }

    @Override
    public String getCost() {
        return costService;
    }
}

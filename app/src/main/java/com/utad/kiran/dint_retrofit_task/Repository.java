package com.utad.kiran.dint_retrofit_task;

import io.reactivex.Observable;

public class Repository {
    private static volatile Repository ourInstance = new Repository();

    static Repository getInstance() {
        if (ourInstance == null) {
            synchronized (Repository.class) {
                if (ourInstance == null) {
                    ourInstance = new Repository();
                }
            }
        }
        return ourInstance;
    }

    private Repository() {
    }

    private PositionService positionService = PositionService.Factory();

    public Observable<Statistics> getStatisticsInfo(String platformGame, String epic_nickname){
        return positionService.getStatisticsInfo(platformGame,epic_nickname);
    }

}

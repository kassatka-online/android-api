package ru.kassatka.comepay_sdk.model;

import android.content.Intent;

import java.util.UUID;

/**
 * Created by sokolov on 15.08.2018.
 */
@Deprecated
public class Position {
    private UUID uuid;
    private Long id;

    public Position(Intent intent){
        uuid = (UUID) intent.getExtras().get("UUID");
        id = Long.valueOf(intent.getExtras().getString("POSITION"));
    }

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }
}

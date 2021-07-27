package com.guedim.tc.item.model;

import lombok.Value;

@Value
public class ItemResponse {
    String id;
    String category;
    String desc;
    User user;
}

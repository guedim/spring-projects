package com.guedim.tc.item.model;

import lombok.Value;

@Value
public class Item {
    String id;
    String category;
    String desc;
    String userId;
}
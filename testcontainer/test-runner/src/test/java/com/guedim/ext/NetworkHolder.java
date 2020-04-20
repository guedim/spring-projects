package com.guedim.ext;

import org.testcontainers.containers.Network;

public class NetworkHolder {
    private static final Network network = Network.newNetwork();

    public static Network network() {
        return network;
    }
}

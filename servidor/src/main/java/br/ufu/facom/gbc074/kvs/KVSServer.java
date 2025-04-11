package br.ufu.facom.gbc074.kvs;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class KVSServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(8080)
                .addService(new KVSServiceImpl())
                .build()
                .start();

        System.out.println("Servidor iniciado na porta 8080");
        server.awaitTermination();
    }
}

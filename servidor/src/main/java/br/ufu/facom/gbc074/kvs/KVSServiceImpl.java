package br.ufu.facom.gbc074.kvs;

import io.grpc.stub.StreamObserver;

public class KVSServiceImpl extends KVSGrpc.KVSImplBase {
    private final StorageEngine storage;
    private final MQTTManager mqtt;

    public KVSServiceImpl() throws Exception {
        this.storage = new StorageEngine();
        this.mqtt = new MQTTManager();
    }

    @Override
    public void insere(br.ufu.facom.gbc074.kvs.ChaveValor request, StreamObserver<br.ufu.facom.gbc074.kvs.Versao> responseObserver) {
        try {
            int version = storage.insert(request.getChave(), request.getValor());
            mqtt.publishUpdate("insert", request.getChave(), request.getValor(), version);
            responseObserver.onNext(br.ufu.facom.gbc074.kvs.Versao.newBuilder().setVersao(version).build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }
    // Implemente outros métodos...
}
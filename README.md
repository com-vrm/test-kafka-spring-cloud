# Kafka test

Download Confluent Schema Registry

```
curl -O http://packages.confluent.io/archive/7.1/confluent-7.1.1.tar.gz
```

Run Zookeeper

```
./bin/zookeeper-server-start.sh config/zookeeper.properties 
```

Run Kafka

```
./bin/kafka-server-start.sh config/server.properties
```

Run Confluent Schema Registry

```
./bin/schema-registry-start etc/schema-registry/schema-registry.properties
```
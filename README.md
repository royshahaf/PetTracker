# PetTracker

TravisCI + SonarCloud

[![Build Status](https://travis-ci.com/royshahaf/PetTracker.svg?branch=master)](https://travis-ci.com/royshahaf/PetTracker)

CircleCI

[![CircleCI](https://circleci.com/gh/royshahaf/PetTracker/tree/master.svg?style=svg)](https://circleci.com/gh/royshahaf/PetTracker/tree/master)

This is a playground for testing various things

ICallback - an interface for reacting on events, currently supports onDataArrival(Object object)

ITopic - an interface for communicating over a logical topic, currently supports: write(Object object) for writing, read() for blocking reads, and register(ICallback) for non-blocking reads

BaseTopic - an implementation of ITopic that implements ITopic using a LinkedBlockingQueue for messages and notifies a set of callbacks when new data is written

ISender - an interface for sending data, supports send(Object object)

BaseSender - an implementation of ISender that simply uses an ITopic directly to write data

IReceiver - an interface for receiving data, supports receive()

BaseReceover - an implementation of IReceiver that simply uses an ITopic directly to read data

ITracker - an interface to be implemented by all future trackers, currently supports: fuse(Sighting sighting) which receives new raw data to update some internal state, and register(ITopic topic) which adds a new stream of data to be fused

AveragingTracker - a signle object, averaging tracker which, when fusing a new sighting, averages the sighting with previous sightings that have the same timestamp and sends the new averaged track on its track topic


In plan:
1. Implementing other distribution solutions (over Kafka, over Redis, etc)
2. Implementing more sophisticated trackers (capable of clustering, capable of running on longer streams of raw data, etc)
3. Implementing monitoring (metrics, logs/structured logs, etc)
4. Using different containers (Dropwizard, Spring, etc)
5. Adding support for developers that prefer gradle
6. Creating prettier visualizations (currently only have a callback that prints to System.out)
7. Implementing configuration solutions (with zookeeper, consul, etc)
8. and much, much more

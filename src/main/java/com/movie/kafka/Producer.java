/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.movie.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.model.Rating;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Producer extends Thread {
    private final KafkaProducer<Integer, String> producer;
    private final String topic;

    public Producer(String topic) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.70.133:9092");
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "MovieProducer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, RatingSerializer.class.getName());
        producer = new KafkaProducer<>(props);
        this.topic = topic;
    }

    public void run() {
        File file = new File("E:\\University\\实训\\ml-latest-small\\ratings.csv");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "";
        int count = 0;
        try {
            while ((line = reader.readLine()) != null) {
                if (count == 0) {
                    count++;
                    continue;
                }
                count++;
                String[] tmpRow = line.split(",");
                Rating rating = new Rating();
                rating.setUserId(Integer.parseInt(tmpRow[0]));
                rating.setMovieId(Integer.parseInt(tmpRow[1]));
                rating.setRating(Float.parseFloat(tmpRow[2]));
                rating.setTimestamp(Integer.parseInt(tmpRow[3]));
                producer.send(new ProducerRecord(topic, rating.getUserId(), rating), new MovieCallBack(rating.getTimestamp(), rating.getUserId(), rating));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class MovieCallBack implements Callback {

    private final long startTime;
    private final int key;
    private final Object message;

    public MovieCallBack(long startTime, int key, Object message) {
        this.startTime = startTime;
        this.key = key;
        this.message = message;
    }

    public void onCompletion(RecordMetadata metadata, Exception exception) {
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (metadata != null) {
            System.out.println(
                "message(" + key + ", " + message + ") sent to partition(" + metadata.partition() +
                    "), " +
                    "offset(" + metadata.offset() + ") in " + elapsedTime + " ms");
        } else {
            exception.printStackTrace();
        }
    }
}

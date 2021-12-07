package com.naidiuk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StoreService {
    private final StoreDatabase storeDatabase = new StoreDatabase();

    public void writeStoreToJsonFormat(Store store) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(storeDatabase.getPathToJson())) {
            ObjectMapper objectMapper = createObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            bufferedWriter.write(objectMapper.writeValueAsString(store));
        } catch (IOException e) {
            throw new SerializationException("Can't serialize object!\n" + e);
        }
    }

    public Store readStoreFromJsonFormat() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(storeDatabase.getPathToJson())) {
            ObjectMapper objectMapper = createObjectMapper();
            StringBuilder store = new StringBuilder();
            while (bufferedReader.ready()) {
                store.append(bufferedReader.readLine());
            }
            return objectMapper.readValue(store.toString(), Store.class);
        } catch (IOException e) {
            throw new DeserializationException("Can't deserialize object!\n" + e);
        }
    }

    public void writeStoreToXmlFormat(Store store) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(storeDatabase.getPathToXml())) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Store.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(store, bufferedWriter);
        } catch (IOException | JAXBException e) {
            throw new SerializationException("Can't serialize object!\n" + e);
        }
    }

    public Store readStoreFromXmlFormat() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(storeDatabase.getPathToXml())) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Store.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Store) unmarshaller.unmarshal(bufferedReader);
        } catch (IOException | JAXBException e) {
            throw new DeserializationException("Can't deserialize object!\n" + e);
        }
    }

    private ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}

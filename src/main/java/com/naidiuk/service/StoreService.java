package com.naidiuk.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.naidiuk.entity.Store;
import com.naidiuk.error.DeserializationException;
import com.naidiuk.error.SerializationException;

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
    private static final Path pathToJson = Path.of("src/test/resources/Store.json");
    private static final Path pathToXml = Path.of("src/test/resources/Store.xml");
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    public void writeStoreToJsonFormat(Store store) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(pathToJson)) {
            ObjectMapper objectMapper = setModule();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            bufferedWriter.write(objectMapper.writeValueAsString(store));
        } catch (IOException e) {
            throw new SerializationException("Can't serialize object!\n" + e);
        }
    }

    public Store readStoreFromJsonFormat() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(pathToJson)) {
            ObjectMapper objectMapper = setModule();
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
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(pathToXml)) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Store.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(store, bufferedWriter);
        } catch (IOException | JAXBException e) {
            throw new SerializationException("Can't serialize object!\n" + e);
        }
    }

    public Store readStoreFromXmlFormat() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(pathToXml)) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Store.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Store) unmarshaller.unmarshal(bufferedReader);
        } catch (IOException | JAXBException e) {
            throw new DeserializationException("Can't deserialize object!\n" + e);
        }
    }

    private ObjectMapper setModule() {
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
        return OBJECT_MAPPER;
    }
}

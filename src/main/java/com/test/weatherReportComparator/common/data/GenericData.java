package com.test.weatherReportComparator.common.data;

import java.util.HashMap;

public class GenericData {
    private static HashMap<String, Object> data;
    private static GenericData instance;

    private GenericData(){}

    public static GenericData getInstance(){
       synchronized (GenericData.class){
           if(instance == null){
               instance = new GenericData();
               data = new HashMap<>();
           }

           return instance;
       }
    }

    public void addData(String key, Object value){
        synchronized (GenericData.class){
            data.put(key, value);
        }
    }

    public void addData(HashMap<String, Object> data){
        synchronized (GenericData.class){
            GenericData.data.putAll(data);
        }
    }

    public Object getData(String key){
        synchronized (GenericData.class){
            return data.getOrDefault(key, null);
        }
    }

}

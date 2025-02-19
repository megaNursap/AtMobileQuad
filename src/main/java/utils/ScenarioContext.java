package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class ScenarioContext {
    private final static Logger LOGGER = LogManager.getLogger("Context");

    private ScenarioContext() {
        //Prevent create instance
    }

    private static ScenarioContext _INSTANCE;
    private Map<String, Object> data = new HashMap<>();
    private String _tempKey;

    //Apply Singleton
    public static ScenarioContext currentContext() {
        if (_INSTANCE == null) {
            _INSTANCE = new ScenarioContext();
        }
        return _INSTANCE;
    }

    public ScenarioContext set(String key) {
        _tempKey = key;
        return _INSTANCE;
    }

    public void with(Object value) {
        String parseString;
        try{
            parseString = value.toString();
        }
        catch (Exception e){
            parseString = "Value can not parse to String";
        }
        LOGGER.info(String.format("Set data <%s> with value <%s> ", _tempKey, parseString));
        _INSTANCE.data.put(_tempKey, value);
    }

    public Object get(String key) {
        return _INSTANCE.data.getOrDefault(key, null);
    }

    public <T> T get(String key, Class<T> clazz) {
        return clazz.cast(_INSTANCE.data.getOrDefault(key, null));
    }

    public void clear() {
        data = new HashMap<>();
    }

    public String info() {
        String mapAsString = "";
        try {
            mapAsString = data.keySet().stream()
                    .map(key -> "\n KEY: " + key + "   \n " +
                            "VALUE: "+ data.get(key).toString())
                    .collect(Collectors.joining("\n\n ------------- * ------------- \n ", "{", "\n}"));
        } catch(Exception e) {
            mapAsString = "Can not get info";
        }
        finally{
            return mapAsString;
        }
    }

    public List<String> listKeys(){
        return new ArrayList<>(data.keySet());
    }

    public static void setVariable(String key, Object value){
        _INSTANCE.set(key).with(value);
    }

    public static <T> T getVariable(String key, Class<T> clazz) {
        return _INSTANCE.get(key, clazz);
    }

}

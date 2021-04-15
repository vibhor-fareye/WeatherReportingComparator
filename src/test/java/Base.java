import com.test.weatherReportComparator.common.data.GenericData;
import com.test.weatherReportComparator.common.utils.PropertiesHelper;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

public abstract class Base {
    GenericData data = GenericData.getInstance();
    @BeforeSuite
    protected void oneTimeSetup(){
        PropertiesHelper propertiesHelper = new PropertiesHelper();
        Properties properties = propertiesHelper.loadProperties("src/test/resources/config.properties");
        properties.forEach((key, value) -> {data.addData(key.toString(), value);});
        System.out.println();
    }
}

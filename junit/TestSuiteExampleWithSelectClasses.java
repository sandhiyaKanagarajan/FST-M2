ackage Activities;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;

@RunWith(JUnitPlatform.class)
@SelectClasses({
	Activities.Activity1.class
})
public class TestSuiteExampleWithSelectClasses {

}
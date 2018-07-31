package CamelProject.camel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
public class camelRouting {
public static void main(String[] args) throws Exception
{
System.out.println("Initializing the camel context...");
CamelContext camelContext = new DefaultCamelContext();
System.out.println("Implementing Routes......");
camelContext.addRoutes(new RouteBuilder(){
@Override
public void configure() throws Exception{
from("file:D:\\Apache_Camel_Test\\IN").
choice()
.when(xpath("/Order/Country='USA'")).to("file:D:\\Apache_Camel_Test\\A")
.when(xpath("/Order/Country='UK'")).to("file:D:\\Apache_Camel_Test\\B")
.otherwise().to("file:D:\\Apache_Camel_Test\\C")
.end();
}
});
System.out.println("Starting Camel Context for USA......");
camelContext.start();
      Thread.sleep(3000);
      camelContext.stop();
}
}

package automtionPractice.reports.reports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

public class BaseClass {

        static WebDriver driver;

        public static WebDriver getDriver(){

            if(driver==null){
                WebDriver driver;
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Franco\\Downloads\\Testing\\chromedriver.exe");
                driver = new ChromeDriver();
            }
            return driver;
        }

        /**

         * This function will take screenshot

         * @param webdriver

         * @param fileWithPath

         * @throws Exception

         */

        public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

            //Convert web driver object to TakeScreenshot
            TakesScreenshot scrShot =((TakesScreenshot)webdriver);

            //Call getScreenshotAs method to create image file
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination
            File DestFile=new File(fileWithPath);

            //Copy file at destination
            FileUtils.copyFile(SrcFile, DestFile);
        }

    public static void sendPDFReportByGMail(String from, String pass, String to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            //Set from address
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            //Set subject
            message.setSubject(subject);
            message.setText(body);
            BodyPart objMessageBodyPart = new MimeBodyPart();
            objMessageBodyPart.setText("Please Find The Attached Report File!");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(objMessageBodyPart);
            objMessageBodyPart = new MimeBodyPart();

            //Set path to the pdf report file
            String filename = System.getProperty("user.dir")+"\\AutomationPractice.pdf";

            //Create data source to attach the file in mail
            DataSource source = new FileDataSource(filename);
            objMessageBodyPart.setDataHandler(new DataHandler(source));
            objMessageBodyPart.setFileName(filename);
            multipart.addBodyPart(objMessageBodyPart);
            message.setContent(multipart);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            System.err.println("Problems with email address: "+ae.getMessage());
        }
        catch (MessagingException me) {
            System.err.println("Could not connect to SMTP host, review your host and port: "+me.getMessage());
        }
    }
}




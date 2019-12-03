package automtionPractice.video;

import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class specializedScreenRecorder extends ScreenRecorder {

    private String name;
    public specializedScreenRecorder(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
                                     Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder,
                                     String name) throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
        if(!movieFolder.exists()){
            movieFolder.mkdirs();
        }
        else {
                throw new IOException("Movie folder is nor a directory.");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH");
        return new File(movieFolder, name + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));
    }
}

package automtionPractice.video;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;


import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class videoRecorder {
    private ScreenRecorder screenRecorder;

    public void stopRecording() throws IOException {
        this.screenRecorder.stop();
    }

    public void startRecording(String videoPath) throws IOException, AWTException {
        File file = new File(videoPath);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        Rectangle captureSize = new Rectangle(0,0,width,height);

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

        this.screenRecorder = new specializedScreenRecorder(gc, captureSize,
            new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                QualityKey, 1.0f, KeyFrameIntervalKey, 15*60),
            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null, file, "screenRecorded");

             this.screenRecorder.start();
    }

}


package com.github.jberkel.whassup.model;

import com.whatsapp.MediaData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static com.github.jberkel.whassup.model.Fixtures.fileToBytes;
import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class MediaTest {
    @Test
    public void testDeserializeThumbImage() throws Exception {
        Media media = new Media();
        media.thumb_image = fileToBytes(Fixtures.THUMB_IMAGE);
        MediaData md = media.getMediaData();
        assertThat(md).isNotNull();
        assertThat(md.getFile().getAbsolutePath()).isEqualTo("/storage/emulated/0/WhatsApp/Media/WhatsApp Images/IMG-20130526-WA0000.jpg");
        assertThat(md.getProgress()).isEqualTo(100);
        assertThat(md.getFileSize()).isEqualTo(67731L);
        assertThat(md.isTransferred()).isTrue();
    }
}

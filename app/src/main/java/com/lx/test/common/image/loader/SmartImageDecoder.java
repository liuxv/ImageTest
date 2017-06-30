package com.lx.test.common.image.loader;

import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;

import java.io.IOException;

/**
 * Created by changyi on 03/03/2017.
 */

public class SmartImageDecoder implements ImageDecoder {

    ImageDecoder baseImageDecoder = new BaseImageDecoder(false);

    @Override
    public Bitmap decode(ImageDecodingInfo imageDecodingInfo) throws IOException {
        return baseImageDecoder.decode(imageDecodingInfo);
    }
}
